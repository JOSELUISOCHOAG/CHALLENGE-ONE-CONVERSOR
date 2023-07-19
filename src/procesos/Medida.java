package procesos;

public class Medida {
	private int idMedida;
	private String nombreMedida;
	private double valorMedida;
	private String simbol;

	public Medida() {
	}

	public Medida(int idMedida, String nombreMedida, double valorMedida, String simbol) {
		this.idMedida = idMedida;
		this.nombreMedida = nombreMedida;
		this.valorMedida = valorMedida;
		this.simbol = simbol;
	}

	// Getter para idMedida
	public int getIdMedida() {
		return idMedida;
	}

	// Setter para idMedida
	public void setIdMedida(int idMedida) {
		this.idMedida = idMedida;
	}

	// Getter para nombreMedida
	public String getNombreMedida() {
		return nombreMedida;
	}

	// Setter para nombreMedida
	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}

	// Getter para valorMedida
	public double getValorMedida() {
		return valorMedida;
	}

	// Setter para valorMedida
	public void setValorMedida(double valorMedida) {
		this.valorMedida = valorMedida;
	}

	@Override
	public String toString() {
		return nombreMedida;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public String cambio() {
		return 1 + this.simbol;
	}
	
	public String cambio(Medida medida ) {
		return (medida.valorMedida/this.valorMedida)+this.simbol;
	}
	
	public long convertir(Medida medidaDestino, long montoCambiar) {
		long resultado = (long) (montoCambiar * this.valorMedida / medidaDestino.getValorMedida());		
		return resultado;
	}
	
}
