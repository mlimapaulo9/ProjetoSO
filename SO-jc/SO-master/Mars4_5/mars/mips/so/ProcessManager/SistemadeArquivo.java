package mars.mips.so.ProcessManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import mars.util.SystemIO;

public class SistemadeArquivo {
	
	//contador global para ocupados

	///////////// super bloco ////////////////////
	public static int tamDiscco; //Tamanho do disco
	public static int QtBlocos; // quantidade de blocos digitada pelo usuario
	public static int TmBloco;// tamanho do bloco 
	public static int blocosLivres, blocosOcuoados; //
	//////////// posicoes
	// 0 tamanho do disco
	// 1 tamanho dos bblocos de alocacao
	// 2 quantidade de blocos do disco
	
	////////////////// super bloco ///////////////
	
	 public static int Disco [];
	 
	 
	 public static ArrayList<Inode> ListaInode = new ArrayList<Inode>()  ;// lista de  inodes (aqui também ficam os arquivos e diretórios)
	 
	 public static Inode Raiz; //Diretório raiz
	 
	 public static int calculaArquivoBlocos(int tamArq) {//Calular o tamanho do arquivo em blocos
		 
		int tam = (tamArq / TmBloco);
		int resto = tamArq % TmBloco;
		 
		if (resto != 0) { tam = tam + 1;} //Se a divisão não for exata, pega mais um bloco
		 
		 return tam;
	 }
	 
	 
	 public static void criaDisco(int tam) { //Vai criar o disco a partir do arquivo txt do disco 
			
		 Disco  = new int[tam]; //Instancia vetor
		 Disco[0] = tamDiscco;
		 Disco[1] = TmBloco;
		 Disco[2] = QtBlocos;
		 
		 
		 blocosLivres = QtBlocos;
		 blocosOcuoados = 0;
		 
		 SistemadeArquivo.blocosLivres = blocosLivres;
	
		 
	 }
	 
	 public static void alteraTamDisco(int tam) { //Altera o tamanho do disco

		 Disco[0] = tam;
		 Disco[2] = Disco[0] / Disco[1];
		 
	 }
	 
	public static void alocacaoDisco(int Blocos, String modo) { //A - alocar , D - desalocar //AJEITAR AQUI PRA DESMARCAR PARTE UTILIZADA DO DISCO
		
		if (modo.equals("A") || (modo.equals("a"))) {
			blocosLivres = blocosLivres - Blocos;
			blocosOcuoados = blocosOcuoados + Blocos;
		}else if (modo.equals("D") || (modo.equals("d"))) {
			blocosLivres = blocosLivres + Blocos;
			blocosOcuoados = blocosOcuoados - Blocos;
		}
		
	}
	
	 
	 public static int Ocupados()// verifica quantos estao ocupados e quantos estao livres()
	 {
		  int contador = 0;
		  
		 
		  for (int i = 0 ; i<Disco[0]; i++)
			 {
			  if(Disco [i]!= 0)
			  {
				  contador++;
				  
			  }
				 
			 }
		 
		return contador; 
	 }
	 
	 
	 public static double Armazenmento()
	 {
		 double resultado;
		 
		 int espacoUtilizado = Ocupados();
		
		resultado = ((double)espacoUtilizado / (double)Disco[0]);
			   
		return resultado*100;
		 
		 
	 }
	 
	 
	 public static void Imprimir()
	 {
		 SystemIO.printString(" Espaço Utilizado (%)"+Armazenmento());
		 
		 SystemIO.printString(" \nEspaço Livre (%)"+(100-Armazenmento()));
		 
	 }
	 
	 public static int localEscrita()
	 {
		 
		  for (int i = 3 ; i<Disco[0]; i++)
			 {
			  if(Disco [i]== 0)
			  {
				  return i;
			  }
			  continue;
			 }
		  return 3;
	 }
	 
	 public static void criaArquivonoDisco(int tam) { //Cria arquivo no disco virtual
		 
			
			//Cria arquivo
			SistemadeArquivo.alocacaoDisco(SistemadeArquivo.calculaArquivoBlocos(tam), "A"); //Aloca espaço do disco
			
			Inode i = new Inode(0, 0, tam, SistemadeArquivo.calculaArquivoBlocos(tam), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), false);
			
			for (int k=0; k < Inode.tamAtual; k++) {
				
				if (SistemadeArquivo.localEscrita() > 2) {
					i.Escrever(SistemadeArquivo.localEscrita());
					SistemadeArquivo.Disco[SistemadeArquivo.localEscrita()] = i.id; //marca a posição do disco com o ID do arquivo
				}
			}
	 }
	 
	 
	 public static void LerArq() throws IOException //Método para ler dados do arquivo de disco e gravar na ferramenta de disco
	 {
		 //AJEITAR AQUI - LER UMA LINHA POR VEZ E GUARDAR NO VETOR
		 
		 File file = new File("Disco.txt");
		
		        int i=3;// contador
			
		
				FileReader fileReader = new FileReader(file);
				BufferedReader reader = new BufferedReader(fileReader);
				String data = null;
				
				//Preenche o Superbloco
				tamDiscco = Integer.parseInt(reader.readLine()); //Pega o tamanho do disco
				TmBloco = Integer.parseInt(reader.readLine()); //Pega o tamanho do disco
				QtBlocos = Integer.parseInt(reader.readLine()); //Pega o tamanho do disco
				
				criaDisco(tamDiscco); //Cria disco
				
				
				while((data = reader.readLine()) != null){
					//System.out.println(data);
					Disco[i]= Integer.parseInt(data);//atribui na posicao i valor de data
					i++;
				}
				
				fileReader.close();
				reader.close();
			
		 
	 }
	 
	 public static void EscreverArq() throws IOException //Método para persistir dados do disco em um arquivo txt
	 {
		
		 String path = "Disco.txt"; 
		 
		//Cria arquivo txt para salvar dados do disco
		 File file = new File(path);
			
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
			
			
			for(int i = 0; i < Disco.length;i++) //Percorre o vetor e salva dados no disco
			{
				
				writer.append(String.valueOf(Disco[i])); //grava dado na posicao i do disco no arquivo
				writer.newLine();
				
			}
					
			writer.flush();
			//Fechando conexão e escrita do arquivo.
			writer.close();
			
		 
	 }
	 

}
