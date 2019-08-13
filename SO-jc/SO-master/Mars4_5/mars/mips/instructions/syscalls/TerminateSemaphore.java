package mars.mips.instructions.syscalls;
import mars.util.*;
import mars.*;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.Semaforo;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.mips.so.ProcessManager.TabeladeSemaforos;

public class TerminateSemaphore extends AbstractSyscall
{
	
	public TerminateSemaphore() {
		 super(23, "TerminateSemaphore");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
			
			Terminar(RegisterFile.getValue(6)); //Terminar semaforo - passa $a2
		
			 }
		public static int Terminar(int end) {
			int indice;
			indice = TabeladeSemaforos.procSemaforo(end);
			
			if (indice == -1) {return indice;} //Se indice igual -1, erro
			
			
			//Se tiver bloqueados na fila do semaforo, coloca todos na fila de prontos e remove a fila de bloqueados
			if (TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.size() > 0) {
				for (int i=0; i< TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.size(); i++) {
					PCB pcb = TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.peek();
					pcb.setEstado('P');
					TabeladeProcessos.AddProcesso(pcb);
					
					TabeladeSemaforos.ListaSemaforos.get(indice).Bloqueados.remove(); //Remove
				
				}	
			}
			
			SystemIO.printString("Semaforo removido: "+TabeladeSemaforos.ListaSemaforos.get(indice).endereco+ "  valor "+TabeladeSemaforos.ListaSemaforos.get(indice).valor+"\n");
			TabeladeSemaforos.ListaSemaforos.remove(indice); //Remove o semaforo
			
			
			return indice; 
		}


}
