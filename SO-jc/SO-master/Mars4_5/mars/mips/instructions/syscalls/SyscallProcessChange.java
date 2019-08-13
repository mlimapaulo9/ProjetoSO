package mars.mips.instructions.syscalls;
import mars.util.*;

import javax.swing.JOptionPane;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.Memory;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.Escalonador;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.tools.Timer;

public class SyscallProcessChange  extends AbstractSyscall {
	public static int flag=0;
	public SyscallProcessChange() {
			
		 super(20, "SyscallProcessChange");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
		
		trocaProcesso(0);
	}
	
	public static void trocaProcesso(int tipo) { //recebe $v0
		flag = 1; //1 Para iniciar a contagem de instruções - PARA USAR O PROCESSCHANGE DEIXAR EM 0

		//Troca de processos
				if (TabeladeProcessos.Executando != null) { //Se existe processo em Execução
					//Quem estava executando vai pra o fim da sua fila de prontos
					
					if (tipo == 0) { TabeladeProcessos.Executando.setEstado('P');}
					
					TabeladeProcessos.Executando.getRegFisicos(); //salva conteúdo dos registradores físicos
					TabeladeProcessos.Executando.setPC(RegisterFile.getProgramCounter()); //Salva pc físico
					TabeladeProcessos.AddProcesso(TabeladeProcessos.Executando);

					TabeladeProcessos.setExecutando( Escalonador.escalonar(Escalonador.tipo));//1 por padrão, mas o usuário pode trocar.
	
					
					if (TabeladeProcessos.Executando == null) {System.out.println(" Nulo "); return;}
					
					TabeladeProcessos.Executando.setEstado('E');
					TabeladeProcessos.Executando.setRegFisicos(); //Passa os valores do PCB para os registradores físicos
					
					//JOptionPane.showMessageDialog(null, "Processo Escalonado: PID "+TabeladeProcessos.Executando.getPid()+" Prior "+TabeladeProcessos.Executando.getPrioridade()+" Label "+TabeladeProcessos.Executando.getPC());
					
					SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Executando.getPid() +" - Prioridade: "+TabeladeProcessos.Executando.getPrioridade()+"\n");
					
				
				
				} else { //Se não há processo em execução
					if (SyscallProcessTerminate.terminated ==0 ) {
						TabeladeProcessos.vez= 0; //Inicia o supondo que a vez não é de ninguém
					}
					
					if (Timer.timerINI==1) {Timer.OK=true;}
					
					TabeladeProcessos.setExecutando( Escalonador.escalonar(Escalonador.tipo));//1 por padrão, mas o usuário pode trocar.
			
					
					if (TabeladeProcessos.Executando == null) {System.out.println(" Nulo "); return;}
					TabeladeProcessos.Executando.setEstado('E');
					TabeladeProcessos.Executando.setRegFisicos();
		
					//JOptionPane.showMessageDialog(null, "Processo Escalonado: PID "+TabeladeProcessos.Executando.getPid()+" Prior "+TabeladeProcessos.Executando.getPrioridade()+" Label "+TabeladeProcessos.Executando.getPC());

					
					SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Executando.getPid() +" - Prioridade: "+TabeladeProcessos.Executando.getPrioridade()+"\n");
					
				}	
				
				//Fim Troca de processos	
	
	}
}
