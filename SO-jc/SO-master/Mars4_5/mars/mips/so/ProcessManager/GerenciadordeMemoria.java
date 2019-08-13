package mars.mips.so.ProcessManager;

import javax.swing.JOptionPane;

import mars.ProcessingException;
import mars.mips.hardware.RegisterFile;
import mars.tools.Timer;
import mars.util.SystemIO;

public class GerenciadordeMemoria {
	public static int tamBloco; //Tamanho do bloco
	public static int blProcesso; //Blocos por processo
	public static int tpSub; //Tipo de algoritmo de substitui��o de p�ginas

	public GerenciadordeMemoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static boolean verificaAcesso() {
		//Verifica se os programas est�o nos seus limites de acesso � mem�ria
		if (( RegisterFile.getProgramCounter() > TabeladeProcessos.Executando.getLimInf() ) || (RegisterFile.getProgramCounter() < TabeladeProcessos.Executando.getLimSup()) ) {

   			SystemIO.printString("Acesso violado em "+RegisterFile.getProgramCounter()+". Limite fora da �rea de acesso! Limite Permitido: de "+TabeladeProcessos.Executando.getLimSup()+" a "+TabeladeProcessos.Executando.getLimInf()+".\n");
   			JOptionPane.showMessageDialog(null,"Acesso violado em "+RegisterFile.getProgramCounter()+". Limite fora da �rea de acesso! Limite Permitido: de "+TabeladeProcessos.Executando.getLimSup()+" a "+TabeladeProcessos.Executando.getLimInf()+".\n");
   			
   			return true;
   		}
		return false;
	}

	
	public static int getTamBloco() {
		return tamBloco;
	}

	public static void setTamBloco(int tamBloco) {
		GerenciadordeMemoria.tamBloco = tamBloco;
	}

	public static int getBlProcesso() {
		return blProcesso;
	}

	public static void setBlProcesso(int blProcesso) {
		GerenciadordeMemoria.blProcesso = blProcesso;
	}

	public static int getTpSub() {
		return tpSub;
	}

	public static void setTpSub(int tpSub) {
		GerenciadordeMemoria.tpSub = tpSub;
	}
	
	

}
