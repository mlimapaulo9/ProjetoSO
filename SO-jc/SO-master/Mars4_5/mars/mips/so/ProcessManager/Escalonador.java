package mars.mips.so.ProcessManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

import mars.mips.hardware.RegisterFile;

public class Escalonador {
public static int tipo=1;

	public Escalonador() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static int calculaVez(int ultvez) {
		
		switch (ultvez) {
		
		case 0: 
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
		
		case 1:	
			
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
	
		case 2:	
			
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			
		case 3:	
			
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			
		case 4:	
			
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			
		case 5:	
			
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			
		case 6:	
			
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			
		case 7:	
			
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			
		case 8:	
			
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			
		case 9:	
			
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			
		case 10:	
			if(TabeladeProcessos.Prontos1.size()>0) {TabeladeProcessos.vez = 1; break;}
			if(TabeladeProcessos.Prontos2.size()>0) {TabeladeProcessos.vez = 2; break;}
			if(TabeladeProcessos.Prontos3.size()>0) {TabeladeProcessos.vez = 3; break;}
			if(TabeladeProcessos.Prontos4.size()>0) {TabeladeProcessos.vez = 4; break;}
			if(TabeladeProcessos.Prontos5.size()>0) {TabeladeProcessos.vez = 5; break;}
			if(TabeladeProcessos.Prontos6.size()>0) {TabeladeProcessos.vez = 6; break;}
			if(TabeladeProcessos.Prontos7.size()>0) {TabeladeProcessos.vez = 7; break;}
			if(TabeladeProcessos.Prontos8.size()>0) {TabeladeProcessos.vez = 8; break;}
			if(TabeladeProcessos.Prontos9.size()>0) {TabeladeProcessos.vez = 9; break;}
			if(TabeladeProcessos.Prontos10.size()>0) {TabeladeProcessos.vez = 10; break;}
			
		}
		
		//JOptionPane.showMessageDialog(null, "Vez: "+TabeladeProcessos.vez);		
		return TabeladeProcessos.vez;
	}

   
	public static PCB escalonar(int tipo){ //Escalona pelo tipo passado 1-Fila, 2-Prioridade e 3-Aleatório
		
	//	JOptionPane.showMessageDialog(null, "Vez: "+TabeladeProcessos.vez);
		if (tipo ==1) {//Fila - Tira um e cede a vez pra proxima fila
			
			TabeladeProcessos.vez = calculaVez(TabeladeProcessos.ultVez);

				 
			if(TabeladeProcessos.vez==1) {
				TabeladeProcessos.ultVez =1;
			 if (TabeladeProcessos.Prontos1.size()>0) {
				 PCB pronto = TabeladeProcessos.Prontos1.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos1.remove(); //Remove o PCB da fila
				 
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==2) {
			 TabeladeProcessos.ultVez =2;
			 if (TabeladeProcessos.Prontos2.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos2.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos2.remove(); //Remove o PCB da fila
				 return pronto;
			 }	
			}
		 
		 if(TabeladeProcessos.vez==3) {
			 TabeladeProcessos.ultVez =3;
			 if (TabeladeProcessos.Prontos3.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos3.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos3.remove(); //Remove o PCB da fila
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==4) {
			 TabeladeProcessos.ultVez =4;
			 if (TabeladeProcessos.Prontos4.size()>0) {	
				 JOptionPane.showMessageDialog(null, "Vazio: "+TabeladeProcessos.vez);
				 PCB pronto = TabeladeProcessos.Prontos4.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos4.remove(); //Remove o PCB da fila
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==5) {
			 TabeladeProcessos.ultVez =5;
			 if (TabeladeProcessos.Prontos5.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos5.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos5.remove(); //Remove o PCB da fila
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==6) {
			 TabeladeProcessos.ultVez =6;
			 if (TabeladeProcessos.Prontos6.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos6.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos6.remove(); //Remove o PCB da fila
				 return pronto;
			 }	
			}
		 
		 if(TabeladeProcessos.vez==7) {
			 TabeladeProcessos.ultVez =7;
			 if (TabeladeProcessos.Prontos7.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos7.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos7.remove(); //Remove o PCB da fila
				 return pronto;
			 }	
			}
		 
		 if(TabeladeProcessos.vez==8) {
			 TabeladeProcessos.ultVez =8;
			 if (TabeladeProcessos.Prontos8.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos8.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos8.remove(); //Remove o PCB da fila
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==9) {
			 TabeladeProcessos.ultVez =9;
			 if (TabeladeProcessos.Prontos9.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos9.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos9.remove(); //Remove o PCB da fila
				 return pronto;
			 }
			}
		 
		 if(TabeladeProcessos.vez==10) {
				 TabeladeProcessos.ultVez =10;
			 if (TabeladeProcessos.Prontos10.size()>0) {	
				 PCB pronto = TabeladeProcessos.Prontos10.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos10.remove(); //Remove o PCB da fila
				 return pronto;
			 }	
			}
		 
		} 
		
		if (tipo ==2) {//Prioridade - Passa por cada prioridade e tira dela até esvaziar, depois passa para a proxima prioridade
			//FUNCIONANDO CORRETAMENTE
			if(TabeladeProcessos.Prontos1.size()>0) {
					
				 PCB pronto = TabeladeProcessos.Prontos1.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos1.remove(); //Remove o PCB da fila
				 return pronto;	
				}
			else if(TabeladeProcessos.Prontos2.size()>0) {
					
				 PCB pronto = TabeladeProcessos.Prontos2.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos2.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos3.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos3.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos3.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos4.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos4.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos4.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos5.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos5.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos5.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos6.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos6.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos6.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos7.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos7.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos7.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos8.size()>0) {
					
				 PCB pronto = TabeladeProcessos.Prontos8.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos8.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos9.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos9.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos9.remove(); //Remove o PCB da fila
				 return pronto;
				}
			else if(TabeladeProcessos.Prontos10.size()>0) {
				
				 PCB pronto = TabeladeProcessos.Prontos10.peek(); //Pega o elemento PCB que será retornado para a Execução
				 TabeladeProcessos.Prontos10.remove(); //Remove o PCB da fila
				 return pronto;
				}
			 
			} 
			
			if (tipo ==3) {//Aleatório - Sorteia um número e chama a vez
					//FUNCIONANDO CORRETAMENTE
			Random i = new Random(); 
			calculaVez(TabeladeProcessos.vez= i.nextInt(5) + i.nextInt(5) ); //Gera uma vez entre 0 e 10
			 
			 
			if(TabeladeProcessos.vez==1) {
				 if (TabeladeProcessos.Prontos1.size()>0) {
					 PCB pronto = TabeladeProcessos.Prontos1.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos1.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==2) {
				 if (TabeladeProcessos.Prontos2.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos2.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos2.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==3) {
				 if (TabeladeProcessos.Prontos3.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos3.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos3.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==4) {
				 if (TabeladeProcessos.Prontos4.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos4.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos4.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==5) {
				 if (TabeladeProcessos.Prontos5.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos5.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos5.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==6) {
				 if (TabeladeProcessos.Prontos6.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos6.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos6.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==7) {
				 if (TabeladeProcessos.Prontos7.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos7.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos7.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			 
			 if(TabeladeProcessos.vez==8) {
				 if (TabeladeProcessos.Prontos8.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos8.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos8.remove(); //Remove o PCB da fila
					 return pronto;
				 }	
				}
			 
			 if(TabeladeProcessos.vez==9) {
				 if (TabeladeProcessos.Prontos9.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos9.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos9.remove(); //Remove o PCB da fila
					 return pronto;
				 }	
				}
			 
			 if(TabeladeProcessos.vez==10) {
				 if (TabeladeProcessos.Prontos10.size()>0) {	
					 PCB pronto = TabeladeProcessos.Prontos10.peek(); //Pega o elemento PCB que será retornado para a Execução
					 TabeladeProcessos.Prontos10.remove(); //Remove o PCB da fila
					 return pronto;
				 }
				}
			
			 
			}
				
		return null;
	}

}


