package mars.mips.so.ProcessManager;

import java.util.ArrayList;

import mars.mips.hardware.Memory;
import mars.util.SystemIO;

public class MMU {
	public static int hit=0;
	public static int miss=0;
	public static int indBloco;
	public static int vezBloco=0; //Marca o ultimo removido para FIFO
	public static ArrayList<Integer> mapa = new ArrayList<Integer>()  ; //Para mapeamento da tabela virtual

	public MMU() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean hit_miss(int end) {
		
		if (pegaIndice(end) == -1) {//Não encontrado MISS
			
			return false; //MISS
		}else { //encontrado
			if (TabeladeProcessos.Executando != null && TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid()) != -1) {
				TabelaVirtual.tabelaVirtual.get(TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid())).pagReferenciada = true; //referenciada
				TabelaVirtual.tabelaVirtual.get(TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid())).R = true; 
				
			}	
			
			indBloco = pegaIndice(end);
			return true; //HIT
		}
		
	}
	
	public static int pegaIndice(int end) {
		int ind = mapa.indexOf(end);
		return ind;
	}
	
	public static void mostraTabela() {
		
		SystemIO.printString("\n\n-------------------Tabela Virtual------------------- \n\n");
		for (int i=0;  i<mapa.size(); i++) {
			SystemIO.printString("Endereço virtual: "+i+ " ----> Endereço físico: "+mapa.get(i)+"\n");
		}
		SystemIO.printString("\n\n--------------------------------------------------------- \n\n");
	}

}
