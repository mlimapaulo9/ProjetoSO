package mars.mips.instructions.syscalls;

import mars.util.*;
import mars.*;

public class MySiscall extends AbstractSyscall{
	
	
	
	public MySiscall() {
		super(18, "MySyscall");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		SystemIO.printString("Olá Syscall, Itágores aqui!\n");
		
	}

}
