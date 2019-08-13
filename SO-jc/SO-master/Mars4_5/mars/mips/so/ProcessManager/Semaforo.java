package mars.mips.so.ProcessManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Semaforo {
	public int valor;
	public int endereco;
		
	//Fila de processos bloqueados
	public static Queue<PCB>  Bloqueados = new LinkedList<PCB>() ;
	
	public Semaforo() {
	
		Bloqueados = new LinkedList<PCB>() ;
	}
	
	
	//Gets e Sets
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	
	

}
