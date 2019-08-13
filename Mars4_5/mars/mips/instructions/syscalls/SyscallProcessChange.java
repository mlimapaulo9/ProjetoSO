package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.Escalonador;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.util.SystemIO;

public class SyscallProcessChange extends AbstractSyscall {

	public static int v0=0;
	
	public SyscallProcessChange() {
		super(20, "SyscallProcessChange");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		Troca();
	}
	
	public static void Troca() {
	
				if (TabeladeProcessos.Running != null) {
					
					TabeladeProcessos.Running.getRegs(); 
					TabeladeProcessos.Running.setProgramCounter(RegisterFile.getProgramCounter());
					TabeladeProcessos.AddProcesso(TabeladeProcessos.Running);

					TabeladeProcessos.setRunning( Escalonador.Escalonar());
	
					
					if (TabeladeProcessos.Running == null) {System.out.println(" Nulo "); return;}
					
					TabeladeProcessos.Running.setEstado(2);
					TabeladeProcessos.Running.setRegs();
					
					SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Running.getPidProc() +" - Prioridade: "+TabeladeProcessos.Running.getPrioridade()+"\n");
					
				
				
				} else {					
					TabeladeProcessos.setRunning( Escalonador.Escalonar());
			
					TabeladeProcessos.Running.setEstado(3);
					TabeladeProcessos.Running.setRegs();
					
					SystemIO.printString("PC: "+RegisterFile.getProgramCounter()+" - PID : "+TabeladeProcessos.Running.getPidProc() +" - Prioridade: "+TabeladeProcessos.Running.getPrioridade()+"\n");
					
				}	
	
	
	}
	
	

}
