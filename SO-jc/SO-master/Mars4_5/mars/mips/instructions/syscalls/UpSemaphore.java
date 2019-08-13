package mars.mips.instructions.syscalls;
import mars.util.*;
import mars.*;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.mips.so.ProcessManager.TabeladeSemaforos;

public class UpSemaphore extends AbstractSyscall
{
	
	public UpSemaphore() {
		 super(25, "UpSemaphore");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
			
			Up(RegisterFile.getValue(6)); //Down semaforo  - passa $a2
		
			 }
	
	public static void Up(int end) {
		int indice;
		indice = TabeladeSemaforos.procSemaforo(end);
		
		if (indice == -1) {return;} //Se indice igual -1, não tem semaforo - Sai
		
		//Se tiver processo bloqueado pelo semaforo "indice" retira o mesmo do bloqueio
		if (TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.size() > 0) {			
			
			PCB pcb = TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.peek();
			pcb.setEstado('P');
			TabeladeProcessos.AddProcesso(pcb);
			

			SystemIO.printString("O Processo "+pcb.getPid()+" foi desbloqueado pelo Semaforo "+TabeladeSemaforos.ListaSemaforos.get(indice).endereco+ " valor "+TabeladeSemaforos.ListaSemaforos.get(indice).valor+"\n");
			
			
			TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.remove(); //Remove
			
		}else {
			TabeladeSemaforos.ListaSemaforos.get(indice).valor++; //Incrementa o semaforo
			SystemIO.printString("O Processo "+TabeladeProcessos.Executando.getPid()+" incrementou o semáforo: "+TabeladeSemaforos.ListaSemaforos.get(indice).endereco+ " valor "+TabeladeSemaforos.ListaSemaforos.get(indice).valor+"\n");
			}	
		
	
	}

}
