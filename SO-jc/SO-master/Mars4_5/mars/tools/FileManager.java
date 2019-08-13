package mars.tools;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
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
import mars.mips.so.ProcessManager.SistemadeArquivo;
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
public class FileManager extends AbstractMarsToolAndApplication {
    private static String name    = "FileManager";
    private static String version = "Version 1.0 (José Carlos e Ítalo - SO - Ufersa)";
    private static String heading = "Ferramenta de gerenciamento de Disco.";
    
    /**
     * Number of instructions executed until now.
     */

    private JTextField tamDisco;
    private JTextField tamBloco;
    private JLabel Utilizado, BlocosLivres, BlocosOcupados;
    
    private JTextField tamArquivo;
   
 
    public FileManager(String title, String heading) {
    	super(title,heading);
    	
    	
    }
    
    /**
     * Simple construction, likely used by the MARS Tools menu mechanism.
     */
    public FileManager() {
    	super(name + ", " + version, heading);
    	
    	
    }

//	@Override
	public String getName() {
		return name;
	}
	
//	@Override
	protected JComponent buildMainDisplayArea() {
		
		try {
			SistemadeArquivo.LerArq(); //Lê do disco
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create everything
		JPanel panel = new JPanel(new GridBagLayout());

		tamDisco = new JTextField(String.valueOf(SistemadeArquivo.Disco[0]), 3);
		tamDisco.setEditable(true);
		
		tamBloco = new JTextField(String.valueOf(SistemadeArquivo.Disco[1]), 3);
		tamBloco.setEditable(true);
		
		tamArquivo = new JTextField("10", 3);
		tamArquivo.setEditable(true);
		
		
		
		// Add them to the panel
		
		// Fields
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(tamDisco, c);
		c.gridy++;
		
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(tamBloco, c);
		c.gridy++;
		
		c.gridy++;
		c.gridy++;
		c.gridy++;
		c.gridy++;
		panel.add(tamArquivo, c);
		c.gridy++;
		
		
		// Labels
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(new JLabel("Tamanho do Disco (Gigabytes): "), c);
		c.gridy++;
		panel.add(new JLabel("Tamanho do bloco (Gigabytes): "), c);
		c.gridy++;

		panel.add(new JLabel("Armazenamento "), c);
		c.gridy++;
		
		Utilizado = new JLabel("Utilizado:  "+SistemadeArquivo.Armazenmento()+" %");
		BlocosLivres = new JLabel("Blocos Livres: "+SistemadeArquivo.blocosLivres);
		BlocosOcupados = new JLabel("Blocos Ocupados: "+SistemadeArquivo.blocosOcuoados);
		
		
		
		panel.add(Utilizado, c);
		c.gridy++;

		panel.add(BlocosLivres, c);
		c.gridy++;
		panel.add(BlocosOcupados, c);
		
		c.gridy++;

		panel.add(new JLabel("Criar arquivo com tamanho (Gigabytes) "), c);
		c.gridy++;
		
		//System.out.println(SistemadeArquivo.Disco.length);
		
		
		
		
		return panel;
	}
	


		
		
		
		
	
		
	
	

// @Override
	protected void reset() {
		
			
		updateDisplay(); updateDisplay();
		
		
	}
	
//	@Override
	protected void updateDisplay() {
		
		try {
			SistemadeArquivo.EscreverArq(); //Escreve no arquivo de Disco
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SistemadeArquivo.alteraTamDisco( Integer.parseInt(tamDisco.getText()));
			
		SistemadeArquivo.Disco[0] = Integer.parseInt(tamDisco.getText());
		SistemadeArquivo.Disco[1] = Integer.parseInt(tamBloco.getText());
		SistemadeArquivo.Disco[2] = SistemadeArquivo.Disco[0] / SistemadeArquivo.Disco[1];
		
				
		SistemadeArquivo.criaArquivonoDisco(Integer.parseInt(tamArquivo.getText()));
		
		
		BlocosLivres.setText("Blocos Livres: "+SistemadeArquivo.blocosLivres);
		BlocosOcupados.setText("Blocos Ocupados: "+SistemadeArquivo.blocosOcuoados);
		
		Utilizado.setText("Utilizado:  "+SistemadeArquivo.Armazenmento()+" %"); //AJEITAR AQUI
		
		
		//Utilizado.setText("Utilizado:  "+(Double.parseDouble(BlocosOcupados.getText()) / SistemadeArquivo.Disco[0]) * 100 +" %");
		
		
		
		
		
	}
}
