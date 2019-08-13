package mars.mips.so.ProcessManager;

public class EntradaTabelaVirtual {
	
	public int idProcesso; //id do Processo
	public boolean pagReferenciada = false; 
	public boolean pagModificada = false; 
	public boolean R, W, X = false; 
	public boolean bitPA = false; 
	public int moldura; //número da moldura
	

	public EntradaTabelaVirtual() {
		// TODO Auto-generated constructor stub
	}


	public int getIdProcesso() {
		return idProcesso;
	}


	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}


	public boolean isR() {
		return R;
	}


	public void setR(boolean r) {
		R = r;
	}


	public boolean isW() {
		return W;
	}


	public void setW(boolean w) {
		W = w;
	}


	public boolean isX() {
		return X;
	}


	public void setX(boolean x) {
		X = x;
	}


	public void setPagReferenciada(boolean pagReferenciada) {
		this.pagReferenciada = pagReferenciada;
	}


	public void setPagModificada(boolean pagModificada) {
		this.pagModificada = pagModificada;
	}


	public void setBitPA(boolean bitPA) {
		this.bitPA = bitPA;
	}


	public int getMoldura() {
		return moldura;
	}


	public void setMoldura(int moldura) {
		this.moldura = moldura;
	}

	
}
