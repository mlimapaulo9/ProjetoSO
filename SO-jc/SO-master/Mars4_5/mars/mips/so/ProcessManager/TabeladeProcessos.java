package mars.mips.so.ProcessManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JOptionPane;

import mars.mips.hardware.RegisterFile;
import mars.util.SystemIO;

public class TabeladeProcessos {
	 //Filas de processos prontos 
		
	public static Queue<PCB> Prontos1 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos2 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos3 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos4 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos5 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos6 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos7 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos8 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos9 = new LinkedList<PCB>()  ;
	public static Queue<PCB> Prontos10 = new LinkedList<PCB>() ;
	
	//Fila de espera para gravar o limite inferior de acesso à memória
	public static Queue<PCB> LimInfPend = new LinkedList<PCB>() ;
	
	public static int vez=1;
	public static int ultVez=0;
	
	
	
	public static PCB Executando; //Processo em execução

//criar uma lista de process e manter um executando e outros em espera(prontos)
	public TabeladeProcessos() {
		// TODO Auto-generated constructor stub
		 
	}

	
	public static PCB criaPCB(int label, int fim, int prioridade) {

		PCB processo = new PCB(); //Cria PCB e preenche os atributos
		
		processo.setPC(label); //Pega endereço de memória e joga no processo criado
		processo.setLimSup(label); //Inicio do programa do processo
		processo.setLimInf(fim); //Fim do programa do processo
		processo.setEstado('P');
		processo.setPrioridade(prioridade);//pega a prioridade e coloca no processo
		
		//Cria entrada virtual e guarda na tabela virtual
		TabelaVirtual.adicionar(TabelaVirtual.criaEntrada(processo));

		SystemIO.printString("Limites: PCB "+processo.getPid()+ " Sup "+processo.getLimSup()+" inf "+ processo.getLimInf()+"\n");
		

		return processo;
	}
		
	public static void AddProcesso(PCB processo) {//Adiciona Processo à fila adequada
	//	JOptionPane.showMessageDialog(null, "Processo adicionado: PID "+processo.getPid()+" Prior "+processo.getPrioridade()+" Label "+processo.getPC());		
		
		switch (processo.getPrioridade()) {
		
		case 1: Prontos1.add(processo); break;
		case 2: Prontos2.add(processo); break;
		case 3: Prontos3.add(processo); break;
		case 4: Prontos4.add(processo); break;
		case 5: Prontos5.add(processo); break;
		case 6: Prontos6.add(processo); break;
		case 7: Prontos7.add(processo); break;
		case 8: Prontos8.add(processo); break;
		case 9: Prontos9.add(processo); break;
		case 10: Prontos10.add(processo); break;
		
		}
			
	}
	


	public static PCB getExecutando() {
		return Executando;
	}

	public static void setExecutando(PCB executando) {
		Executando = executando;
	}

	
}
