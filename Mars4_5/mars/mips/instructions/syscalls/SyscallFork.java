package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.TabeladeProcessos;

public class SyscallFork extends AbstractSyscall{
	
	public SyscallFork() {
		super(19, "SyscallFork");
		// TODO Auto-generated constructor stub
	}

	public void criaProcesso(int id, int fim, int prioridade) {
		
		TabeladeProcessos.AddProcesso(TabeladeProcessos.novoPCB(id, fim, prioridade));
		 			
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		criaProcesso(RegisterFile.getValue(4), RegisterFile.getValue(26), RegisterFile.getValue(27));		
		
	}	

	
	
}
