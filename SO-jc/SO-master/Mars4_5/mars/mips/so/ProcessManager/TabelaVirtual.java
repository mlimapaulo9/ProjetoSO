package mars.mips.so.ProcessManager;

import java.util.ArrayList;

public class TabelaVirtual {
	
	
	public static ArrayList<EntradaTabelaVirtual> tabelaVirtual = new ArrayList<EntradaTabelaVirtual>()  ; //Lista de entradas da tabela virtual


	public TabelaVirtual() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntradaTabelaVirtual criaEntrada(PCB pcb) {
		
		EntradaTabelaVirtual entrada = new EntradaTabelaVirtual();
		entrada.idProcesso = pcb.getPid();
		
		return entrada;
	}
	
	public static void adicionar(EntradaTabelaVirtual entrada) {
		tabelaVirtual.add(entrada);
	}
	
	public static void excluir(EntradaTabelaVirtual entrada) {
		tabelaVirtual.remove(entrada.idProcesso);
	}
	
	public static int pegaIndice(int idProcesso) {
		int ind = tabelaVirtual.indexOf(idProcesso);
		return ind;
	}

}
