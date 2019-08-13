package mars.mips.instructions.syscalls;

import javax.swing.JOptionPane;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.Escalonador;
import mars.mips.so.ProcessManager.GMV;
import mars.mips.so.ProcessManager.MMU;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.tools.Timer;
import mars.util.SystemIO;

public  class SyscallProcessTerminate extends AbstractSyscall {
	public static int terminated=0;
	public SyscallProcessTerminate() {
		
		
		 super(21, "SyscallProcessTerminate");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
		
			terminarProcesso();
	}
	
public static void terminarProcesso() { //recebe $v0
	
	        
	        GMV.desmapear(MMU.pegaIndice(TabeladeProcessos.Executando.getPC()));
	        
			TabeladeProcessos.Executando = null;
			terminated=1;
			
		
			SyscallProcessChange.trocaProcesso(0);
		
			
			
		
		}
}
