package mars.mips.so.ProcessManager;

import java.sql.Date;

import javafx.scene.chart.PieChart.Data;

public class Inode {
	 public static int seq=0; //Para gerar os ids
	 public static int id ;// id do dono do arquivo
	 public static int idInodePai; //Inserir i-node pai
	 public static int idInodeFilho = 0; //i-node filho
	 public static int tipo;// verifica se e arquivo ou diretorio 0 = arquivo 1= diretorio
	 public static int rwx;//rever  se ta certo dessa forma  essa protecao
	 public static int tamAtual;// tamanho atual do arquivo bytes
	 public static int tamAtualDBlocos;// tamano atual  do arquivo em blocos
	 public static Date dataCriacao;// data da criacao 
	 public static Date dataMod;//data da modificacao
	 public static boolean flag;// flag para dizer se e pra oculta o arquivo
	 
	 
	 public static  int contador=0 ;//contador de posicoes 
	
	 
	 public static int Localizacao [] = new int[7];//vetor de inodes, mostra a localização no disco

	 private Inode link; //CRIAR
	 
	 public Inode(){
		 
	 }
	 
	 public Inode(int tip,int Rwx , int tamatual, int tamatualblocos,Date datacriacao, Date datamodificacao, boolean f)
		{
		 	seq++;
			id = seq;
			tipo=tip; //0 ou 1
			rwx=Rwx;
			tamAtual=tamatual;
			tamAtualDBlocos=tamatualblocos;
			dataCriacao=datacriacao;
			dataMod=datamodificacao;
			flag=f;
			
			
		
		}
	 
	public void Escrever(int pos)//funcao que verifica o tamanho dos endereços e retorna o local onde será gravado um endereço
	 {
		
		 if(this.contador<7)
		 {
			 if(this.contador == 0)
			 {
				 this.Localizacao[this.contador] =pos;
				 
			 }
			 else {
				 if (this.contador<7) {
					 this.Localizacao[this.contador] =pos;
				 }
				 
			 }
			 this.contador ++;
		 }
		 else //Se passar do tamanho do endereços
		 {
			 this.link = new Inode(); //FAZER CONSTRUTOR PADRÃO
			 if(this.link.contador == 0)
			 {
				 this.link.Localizacao[this.link.contador]=pos; 
				 
			 }
			 else {
				 if (this.link.contador<7) {
					 this.link.Localizacao[this.link.contador]=pos; 
				 }
			 }
			 this.link.contador ++;
			 
			this.link.idInodePai = this.id;
			this.link.idInodeFilho = this.link.idInodeFilho + 1;
		 
		 }
	 }
}
