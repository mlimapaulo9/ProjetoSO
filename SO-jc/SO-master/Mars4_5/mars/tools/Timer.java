package mars.tools;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.prism.paint.Stop;

import mars.ProgramStatement;
import mars.mips.hardware.AccessNotice;
import mars.mips.hardware.AddressErrorException;
import mars.mips.hardware.Memory;
import mars.mips.hardware.MemoryAccessNotice;
import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;
import mars.mips.instructions.BasicInstruction;
import mars.mips.instructions.BasicInstructionFormat;
import mars.mips.instructions.syscalls.SyscallExit;
import mars.mips.instructions.syscalls.SyscallProcessChange;
import mars.mips.instructions.syscalls.SyscallProcessTerminate;
import mars.mips.so.ProcessManager.Escalonador;
import mars.mips.so.ProcessManager.GMV;
import mars.mips.so.ProcessManager.GerenciadordeMemoria;
import mars.mips.so.ProcessManager.MMU;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.simulator.Simulator;
import mars.util.SystemIO;

/**
 * 
 * Instruction counter tool. Can be used to know how many instructions
 * were executed to complete a given program. 
 * 
 * Code slightly based on MemoryReferenceVisualization.
 * 
 * @author Felipe Lessa <felipe.lessa@gmail.com>
 *
 */
//@SuppressWarnings("serial")
public class Timer extends AbstractMarsToolAndApplication {
    private static String name    = "Timer";
    private static String version = "Version 1.0 (José Carlos e Ítalo - SO - Ufersa)";
    private static String heading = "Contando o número de instruções executadas para chamar o Escalonador.";
    
    /**
     * Number of instructions executed until now.
     */
    protected int counter = 0;
    public static int timerINI = 0; // 0 - Timer desativado ---- 1 - Timer ativado
    public static boolean OK = true; //true - Atingiu o número desejado de instruções ----- false - não atingiu (PC bloqueado)
    public static int limite = 0; //Verifica se ultrapassou o limite de instruções estabelecido (counter)
    public static boolean acessoviolado=false; //verifica se acessou área de memória de terceiros
    private JTextField counterField;
    private JTextField escalonamento;
    private JLabel inst;
    
    
    
    /**
     * The last address we saw. We ignore it because the only way for a
     * program to execute twice the same instruction is to enter an infinite
     * loop, which is not insteresting in the POV of counting instructions.
     */
    protected int lastAddress = -1;
    
   	/**
   	 * Simple constructor, likely used to run a stand-alone memory reference visualizer.
   	 * @param title String containing title for title bar
   	 * @param heading String containing text for heading shown in upper part of window.
   	 */
    public Timer(String title, String heading) {
    	super(title,heading);
    }
    
    /**
     * Simple construction, likely used by the MARS Tools menu mechanism.
     */
    public Timer() {
    	super(name + ", " + version, heading);
    }

//	@Override
	public String getName() {
		return name;
	}
	
//	@Override
	protected JComponent buildMainDisplayArea() {
		// Create everything
		JPanel panel = new JPanel(new GridBagLayout());

		counterField = new JTextField("3", 3);
		counterField.setEditable(true);
		
		
		
		// Add them to the panel
		
		// Fields
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(counterField, c);

		c.insets = new Insets(0, 0, 0, 0);
		c.gridy++;
		
		
		// Labels
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(new JLabel("Quantidade de Instruções: "), c);
		
		

		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridwidth = 1;
		
		inst = new JLabel("Contador: ");
		c.gridy++;
		panel.add(inst, c);
		inst.setVisible(true);
		
		c.gridy++;
		panel.add(new JLabel("Escalonamento [1-Fila     2-Prioridade    3-Aleatório] "), c);
		c.gridy++;
		c.insets = new Insets(0, 0, 0, 100);
		escalonamento = new JTextField("1", 3);
		
		panel.add(escalonamento, c);
		
		
		
		
		
		return panel;
	}
	
//	@Override
	protected void addAsObserver() {
		//PASSAR AQUI OS ENDEREÇOS INICIAL E FINAL DO PROGRAMA
		addAsObserver(Memory.textBaseAddress, Memory.textLimitAddress);
	}

//	@Override
	protected void processMIPSUpdate(Observable resource, AccessNotice notice) {
		
		
		
		//Define o tipo de escalonamento selecionado
		if (escalonamento.getText().equals("1")) {
			Escalonador.tipo = 1; //Fila
		}
		
		if (escalonamento.getText().equals("2")) { //prioridade
			Escalonador.tipo = 2;
		}
		
		if (escalonamento.getText().equals("3")) { //Aleatória
			Escalonador.tipo = 3;
		}
		
		if (!notice.accessIsFromMIPS()) return;
		if (notice.getAccessType() != AccessNotice.READ) return;
		MemoryAccessNotice m = (MemoryAccessNotice) notice;
		int a = m.getAddress();
		
		if (a == lastAddress) return;
		lastAddress = a;
		
	
		//Verifica se o endereço passado por PC está mapeado, senão manda mapear
		if (! MMU.hit_miss(m.getAddress())) {
			SystemIO.printString("\nMiss:  ");
			
			GMV.mapear(m.getAddress()); //Mapea endeço
			MMU.miss++;
			
		}else {
			MMU.hit++;
			SystemIO.printString("\nHit: Endereço "+m.getAddress()+" encontrado no blobo "+MMU.indBloco +" da Tabela Virtual.\n");
		}
		
		SystemIO.printString("\n\n          Totais -----> Hits: "+MMU.hit+" Miss: "+MMU.miss+"\n\n\n");
		
			
		if (limite == Integer.parseInt(counterField.getText()) && ( (Escalonador.tipo == 1) || (Escalonador.tipo == 3)) ) {//Desbloqueia limite quando chegar no estabelacido
			limite = 0;
			OK = true;
		}
		
		if (SyscallProcessChange.flag == 1) {
			counter++;
			limite++; //Valor para travamento do PC
			
		}
		
		if (limite == Integer.parseInt(counterField.getText())  && ( (Escalonador.tipo == 1) || (Escalonador.tipo == 3)) ) {//Bloqueia limite quando chegar  no estabelacido
			if (TabeladeProcessos.Executando != null) {
				OK = false;
			}
			
		}
		
		
		if (counter == Integer.parseInt(counterField.getText())) {
			
			reset(); //Zera o contador e escalona quando atinge a quantidade de instruções escolhida
			
			}
		
		try {
			ProgramStatement stmt = Memory.getInstance().getStatement(a);
			BasicInstruction instr = (BasicInstruction) stmt.getInstruction(); 
			BasicInstructionFormat format = instr.getInstructionFormat();
			
		} catch (AddressErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateDisplay();
	}
	
//	@Override
	protected void initializePreGUI() {
		counter = 0;
		lastAddress = -1;
	}
	
// @Override
	protected void reset() {
		
		counter = 0;
		int priorAnterior=0;
		
		//Troca de processos
		if (TabeladeProcessos.Executando != null) { //Se existe processo em Execução
			//Quem estava executando vai pra o fim da sua fila de prontos
			priorAnterior = TabeladeProcessos.Executando.getPrioridade();
			
			TabeladeProcessos.Executando.setEstado('P');			
			TabeladeProcessos.Executando.getRegFisicos(); //salva conteúdo dos registradores físicos		
			TabeladeProcessos.Executando.setPC(RegisterFile.getProgramCounter()); //Salva pc físico				
	
			TabeladeProcessos.AddProcesso(TabeladeProcessos.Executando);

			TabeladeProcessos.setExecutando(Escalonador.escalonar(Escalonador.tipo));//1 por padrão, mas o usuário pode trocar.
			
			if (priorAnterior == TabeladeProcessos.Executando.getPrioridade() ) { OK = true;} //Se tirar da mesma fila em sequencial, mantém o PC ativo
					
			//JOptionPane.showMessageDialog(null, "Processo Escalonado: PID "+TabeladeProcessos.Executando.getPid()+" Prior "+TabeladeProcessos.Executando.getPrioridade()+" Label "+TabeladeProcessos.Executando.getPC());
			if (TabeladeProcessos.Executando == null) {System.out.println(" Nulo ");return;}
			

			TabeladeProcessos.Executando.setEstado('E');
			TabeladeProcessos.Executando.setRegFisicos(); //Passa os valores do PCB para os registradores físicos		
			
			SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Executando.getPid() +" - Prioridade: "+TabeladeProcessos.Executando.getPrioridade()+"\n");
			
		
		} else { //Se não há processo em execução
			
		
			TabeladeProcessos.vez= 0; //Inicia o supondo que a vez não é de ninguém
			TabeladeProcessos.setExecutando(Escalonador.escalonar(Escalonador.tipo));//1 por padrão, mas o usuário pode trocar.
			
			//JOptionPane.showMessageDialog(null, "Processo Escalonado: PID "+TabeladeProcessos.Executando.getPid()+" Prior "+TabeladeProcessos.Executando.getPrioridade()+" Label "+TabeladeProcessos.Executando.getPC());
			if (TabeladeProcessos.Executando == null) {System.out.println(" Nulo "); return;}
			
			if (priorAnterior == TabeladeProcessos.Executando.getPrioridade() ) { OK = true;} //Se tirar da mesma fila em sequencial, mantém o PC ativo
			
			TabeladeProcessos.Executando.setEstado('E');
			TabeladeProcessos.Executando.setRegFisicos();

			SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Executando.getPid() +" - Prioridade: "+TabeladeProcessos.Executando.getPrioridade()+"\n");

		}	
		
		//Fim Troca de processos
		
		//Verifica se os programas estão nos seus limites de acesso à memória
		 acessoviolado = GerenciadordeMemoria.verificaAcesso();
			
		 
		 
			
		
		
			//lastAddress = -1;		
		updateDisplay();
		
		
	}
	
//	@Override
	protected void updateDisplay() {
		inst.setText("Contador: "+ String.valueOf(counter));
		
		
		
		
	}
}
