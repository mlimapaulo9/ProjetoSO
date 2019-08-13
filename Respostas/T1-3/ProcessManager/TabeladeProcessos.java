package mars.mips.so.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

import mars.util.SystemIO;

public class TabeladeProcessos {

	public static PCB Running;
	
	public static Queue<PCB> ready = new LinkedList<PCB>()  ;
	
	public static PCB novoPCB(int label, int fim, int prioridade) {

		PCB processo = new PCB(); //Cria PCB e preenche os atributos
		
		processo.setProgramCounter(label);
		processo.setSup(label); 
		processo.setInf(fim); 
		processo.setEstado(1);
		processo.setPrioridade(prioridade);
		
		SystemIO.printString("Limites: PCB "+processo.getPidProc()+ " Sup "+processo.getSup()+" inf "+ processo.getInf()+"\n");
		

		return processo;
	}
	
	public static void AddProcesso(PCB processo) {
			
		
			ready.add(processo);
			
		
			
	}

	public static PCB getRunning() {
		return Running;
	}

	public static void setRunning(PCB running) {
		Running = running;
	}
		
	
	
			
	
}
