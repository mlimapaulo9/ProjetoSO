package mars.mips.so.ProcessManager;

import mars.mips.hardware.RegisterFile;
import mars.util.SystemIO;

public class GMV {
	public static int qtBlocos=8; //Quantidade de blocos
	public static int qtPGBloco =1; //Uma instruções por bloco
	public static int BlocosLivres = qtBlocos; //Essa quantidade varia à medida que formos ocupando e desocupando os blocos

	public static int AlgSub=0; //Tipos de algoritmo de substituição (0-Fila )
	

	public GMV() {
		// TODO Auto-generated constructor stub
	}
	

	public static int mapear(int end) { //A posição na fila será o resultado do mapeamento
		if (GMV.BlocosLivres > 0) {
			
			MMU.mapa.add(end); //Por conveniência estou mapeando apenas um endereço por página/bloco
			
			GMV.BlocosLivres--; //Decrementa os blocos livres
			
			int Indice = MMU.pegaIndice(end);
			
			if (TabeladeProcessos.Executando != null && TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid()) != -1) {
				TabelaVirtual.tabelaVirtual.get(TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid())).moldura = Indice;
			}
			
			SystemIO.printString("O endereço físico "+end+" foi mapeado para a Tabela Virtual no Bloco "+Indice+" \n");
			return Indice;
		}else {
				
			//Chama algoritmo de substituição de páginas
			int indRemovido = subPagina(AlgSub);
			int removido = MMU.mapa.remove(indRemovido); //Remove a página			
			MMU.mapa.add(indRemovido, end); //Adiciona a nova página

			
			int Indice = MMU.pegaIndice(end);
			if (TabeladeProcessos.Executando != null && TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid()) != -1) {
				TabelaVirtual.tabelaVirtual.get(TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid())).moldura = Indice;
			}
			SystemIO.printString("Não há blocos livres. A Página "+removido+" foi removida para uma nova alocação. ");
			SystemIO.printString("O endereço físico "+end+" foi mapeado para a Tabela Virtual no Bloco "+Indice+ " \n\n");
			
			//mostra a tabela virtual atual
			MMU.mostraTabela();
			
			return Indice;
			
		}
		
		
	}
	
	public static void desmapear(int end) { //Usar quando encerrar um processo
		if (MMU.pegaIndice(end) != -1) {
			MMU.mapa.remove(end);
		}
		
		if (TabelaVirtual.pegaIndice(TabeladeProcessos.Executando.getPid()) != -1) {
			TabelaVirtual.tabelaVirtual.remove(end);
		}
		GMV.BlocosLivres++; //Incrementa os blocos livres
		
	}
	
	

public static int subPagina(int tipo) {//Retorna o índice de quem sai do mapeamento
	int indiceTab=0;
	switch (tipo) {
	case 0: {//FIFO
		if (MMU.vezBloco ==  qtBlocos) {MMU.vezBloco = 0;} //Se atingir o final volta pra o início
		indiceTab = MMU.vezBloco;
		MMU.vezBloco++;
		return indiceTab;
	}
	case 1: {//NRU
		
		return indiceTab;
	}
	case 3: {//SEGUNDA CHANCE
		
		return indiceTab;
	}
	case 4: {//LRU
		
		return indiceTab;
		
	}
	
	default: { SystemIO.printString("Tipo de algoritmo de substituição de páginas não reconheceido!"); return -1;}
	}
	
}

	public static int getQtBlocos() {
		return qtBlocos;
	}

	public static void setQtBlocos(int qtBlocos) {
		GMV.qtBlocos = qtBlocos;
	}

	public static int getQtPGBloco() {
		return qtPGBloco;
	}

	public static void setQtPGBloco(int qtPGBloco) {
		GMV.qtPGBloco = qtPGBloco;
	}

	public static int getBlocosLivres() {
		return BlocosLivres;
	}

	public static void setBlocosLivres(int blocosLivres) {
		BlocosLivres = blocosLivres;
	}

	public static int getAlgSub() {
		return AlgSub;
	}

	public static void setAlgSub(int algSub) {
		AlgSub = algSub;
	}


	
	

}
