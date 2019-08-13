package mars.mips.so.ProcessManager;
import mars.mips.hardware.*;
import mars.util.SystemIO;
import java.util.List;

public class PCB {
	
	private int [] regs = new int[32];
	private int estado; // 1- Pronto 2- Executando 3- bloqueado
	private int ProgramCounter; 
	private int prioridade;	
	private int pidProc;
	private int Inf;
	private int Sup;	
	
	public int getInf() {
		return Inf;
	}

	public void setInf(int inf) {
		Inf = inf;
	}

	public int getSup() {
		return Sup;
	}

	public void setSup(int sup) {
		Sup = sup;
	}
	
	private static int i = 0;
	
	public PCB() {
		setPidProc(i);
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getProgramCounter() {
		return ProgramCounter;
	}

	public void setProgramCounter(int programCounter) {
		ProgramCounter = programCounter;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPidProc() {
		return pidProc;
	}

	public void setPidProc(int pidProc) {
		this.pidProc = pidProc;
	}
	
	public  void getRegs() { 

		for (int i=0 ; i<32; i++) {
			this.regs[i] = RegisterFile.getValue(i);
		}
	}
	
	public void setRegs() {
		for (int i=0 ; i<32; i++) {	
			RegisterFile.updateRegister(i, this.regs[i]) ; 
		 
		}
		RegisterFile.setProgramCounter(getProgramCounter());
	}
	
	
	
}
