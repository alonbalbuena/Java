package modelo;

public class NumeroVO {

	private int numero;
	
	public NumeroVO() {
		this.numero = (int) (1 + Math.random() * 10);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
