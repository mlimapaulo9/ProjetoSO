package mars.mips.instructions.syscalls;
import mars.util.*;
import mars.*;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.Escalonador;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.mips.so.ProcessManager.TabeladeSemaforos;

public class DownSemaphore extends AbstractSyscall
{
	
	public DownSemaphore() {
		 super(24, "DownSemaphore");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
		
				Down(RegisterFile.getValue(6)); //Down semaforo  - passa $a2
			 }
	
	public static void Down(int end) {
		int indice;
		indice = TabeladeSemaforos.procSemaforo(end); //Procura sem�foro na tabela
		
		if (indice == -1) {return;} //Se indice igual -1, n�o tem semaforo - Sai
		

		if (TabeladeSemaforos.ListaSemaforos.get(indice).valor > 0) {			
			TabeladeSemaforos.ListaSemaforos.get(indice).valor--; //Decrementa o semaforo
		
			SystemIO.printString("O Processo "+TabeladeProcessos.Executando.getPid()+" decrementrou o sem�foro: "+TabeladeSemaforos.ListaSemaforos.get(indice).endereco+ " valor "+TabeladeSemaforos.ListaSemaforos.get(indice).valor+"\n");
			
		}else if (TabeladeSemaforos.ListaSemaforos.get(indice).valor == 0){
			//Pega quem t� executando e bloqueia
			TabeladeProcessos.Executando.setEstado('B');
			TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.add(TabeladeProcessos.Executando);
			
			SystemIO.printString("O Processo "+TabeladeProcessos.Executando.getPid()+" foi bloqueado pelo Semaforo "+TabeladeSemaforos.ListaSemaforos.get(indice).endereco+ " valor "+TabeladeSemaforos.ListaSemaforos.get(indice).valor+"\n");
			
			//Chama o escalonador
			TabeladeProcessos.setExecutando( Escalonador.escalonar(Escalonador.tipo));//1 por padr�o, mas o usu�rio pode trocar.
	
			if (TabeladeProcessos.Executando == null) {System.out.println(" Nulo "); return;}
			TabeladeProcessos.Executando.setEstado('E');
			TabeladeProcessos.Executando.setRegFisicos();

			//JOptionPane.showMessageDialog(null, "Processo Escalonado: PID "+TabeladeProcessos.Executando.getPid()+" Prior "+TabeladeProcessos.Executando.getPrioridade()+" Label "+TabeladeProcessos.Executando.getPC());
		
			SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Executando.getPid() +" - Prioridade: "+TabeladeProcessos.Executando.getPrioridade()+"\n");
			
			}	
		
	}


}
