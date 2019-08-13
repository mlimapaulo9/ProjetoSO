package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.TabeladeProcessos;

public class SyscallProcessTerminate extends AbstractSyscall {

	public static int finalizado=0;
	
	public SyscallProcessTerminate() {
		super(21, "SyscallProcessTerminate");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		terminarProcesso();
	}

	private static void terminarProcesso() {
		// TODO Auto-generated method stub
		TabeladeProcessos.Running = null;
		finalizado=1;
		
	
		SyscallProcessChange.Troca();		
	}

}
