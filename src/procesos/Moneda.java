package procesos;

public class Moneda {
	private int idMoneda;
	private String nombreMoneda;
	private double valorMoneda;
	private String simbol;

	public Moneda() {
	}

	public Moneda(int idMoneda, String nombreMoneda, double valorMoneda, String simbol) {
		this.idMoneda = idMoneda;
		this.nombreMoneda = nombreMoneda;
		this.valorMoneda = valorMoneda;
		this.simbol = simbol;
	}

	// Getter para idMoneda
	public int getIdMoneda() {
		return idMoneda;
	}

	// Setter para idMoneda
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	// Getter para nombreMoneda
	public String getNombreMoneda() {
		return nombreMoneda;
	}

	// Setter para nombreMoneda
	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	// Getter para valorMoneda
	public double getValorMoneda() {
		return valorMoneda;
	}

	// Setter para valorMoneda
	public void setValorMoneda(double valorMoneda) {
		this.valorMoneda = valorMoneda;
	}

	@Override
	public String toString() {
		return nombreMoneda;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public String cambio() {
		return this.valorMoneda + this.simbol;
	}
	
	public String cambio(Moneda moneda ) {
		return (moneda.valorMoneda/this.valorMoneda)+this.simbol;
	}
	
	public double convertir(Moneda monedaDestino, double montoCambiar) {
		double resultado = 0;
		if (this.valorMoneda < monedaDestino.getValorMoneda()) {
			resultado = montoCambiar * (this.valorMoneda * monedaDestino.getValorMoneda());
		} else {
			resultado = (montoCambiar / this.valorMoneda) * monedaDestino.getValorMoneda();
		}
		return resultado;
	}
}
