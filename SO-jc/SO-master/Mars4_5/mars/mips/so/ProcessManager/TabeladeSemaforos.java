package mars.mips.so.ProcessManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JOptionPane;

import mars.mips.hardware.RegisterFile;

public class TabeladeSemaforos {
	 //Filas de processos prontos 
		
	public static ArrayList<Semaforo> ListaSemaforos = new ArrayList<Semaforo>()  ; //Lista de todos os semaforos


//criar uma lista de process e manter um executando e outros em espera(prontos)
	public TabeladeSemaforos() {
		// TODO Auto-generated constructor stub
		 
	}

	//Adiciona semaforo
	public static void AddSemaforo(Semaforo semaforo) {
	
		ListaSemaforos.add(semaforo); //Adiciona semaforo
			
	}
	
	//Procura semaforo
	public static int procSemaforo(int end) {
		for(int i=0; i < ListaSemaforos.size(); i++) {
			if(ListaSemaforos.get(i).getEndereco() == end) {
				//JOptionPane.showMessageDialog(null, "Semaforo "+ ListaSemaforos.get(i).endereco);
				return i; 
			}
		}
		return -1;
	}
		

	
}
