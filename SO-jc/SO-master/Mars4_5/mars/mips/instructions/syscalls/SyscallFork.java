package mars.mips.instructions.syscalls;

import java.beans.Statement;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.TabeladeProcessos;
import mars.util.SystemIO;

public class SyscallFork extends AbstractSyscall {
	public SyscallFork() {
		
		 super(19, "SyscallFork");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {
		//Cria processo e adiciona a tabela de processos
		criaProcesso(RegisterFile.getValue(4), RegisterFile.getValue(26), RegisterFile.getValue(27)); 
	}
	
	public void criaProcesso(int label, int fim, int prioridade) {

		//$a0 = label, $a1 = fim do programa, $a2= prioridade
		TabeladeProcessos.AddProcesso(TabeladeProcessos.criaPCB(label, fim, prioridade)); //Cria processo e adiciona na tabela de processos pendentes de limInferior
		 	
		//ESSA SERÁ USADA PARA A PARTE DE MEMORIA
		//TabeladeProcessos.AddPend(TabeladeProcessos.criaPCB(label, prioridade)); //Cria processo e adiciona na tabela de processos pendentes de limInferior
		
		
		
	}
	

}
