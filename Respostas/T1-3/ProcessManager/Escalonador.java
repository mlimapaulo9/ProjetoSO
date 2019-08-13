package mars.mips.so.ProcessManager;

public class Escalonador {

	public static PCB Escalonar()
	{
		PCB ok = TabeladeProcessos.ready.peek();		
		return ok;
		
	}
	
}
