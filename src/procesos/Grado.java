package procesos;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Grado {
	private int idGrado;
	private String nombreGrado;
	private double valorGrado;
	private String simbol;

	public Grado() {
	}

	public Grado(int idGrado, String nombreGrado, double valorGrado, String simbol) {
		this.idGrado = idGrado;
		this.nombreGrado = nombreGrado;
		this.valorGrado = valorGrado;
		this.simbol = simbol;
	}

	// Getter para idGrado
	public int getIdGrado() {
		return idGrado;
	}

	// Setter para idGrado
	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	// Getter para nombreGrado
	public String getNombreGrado() {
		return nombreGrado;
	}

	// Setter para nombreGrado
	public void setNombreGrado(String nombreGrado) {
		this.nombreGrado = nombreGrado;
	}

	// Getter para valorGrado
	public double getValorGrado() {
		return valorGrado;
	}

	// Setter para valorGrado
	public void setValorGrado(double valorGrado) {
		this.valorGrado = valorGrado;
	}

	@Override
	public String toString() {
		return nombreGrado;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public String cambio() {
		return this.valorGrado + this.simbol;
	}
	
	public String cambio(Grado grado ) {
		return (grado.valorGrado/this.valorGrado)+this.simbol;
	}
	
	public double convertir(Grado gradoDestino, Double valor, JTextField mostrarInfo) throws ExceptionProceso {
		switch (this.idGrado) {
		case 1:
			switch (gradoDestino.getIdGrado()) {
			case 2:
				valor = valor * 9 / 5 + 32;
				mostrarInfo.setText("°C × 9/5 + 32 = °F");
				break;
			case 3:
				valor = valor + 273;
				mostrarInfo.setText("°C + 273 = °K");
				break;
			case 4:
				valor = valor * 9 / 5 + 491.67;
				mostrarInfo.setText("°C × 9/5 + 491.67 = °R");
				break;
			}
			break;
		case 2:
			switch (gradoDestino.getIdGrado()) {
			case 1:
				valor = (valor - 32) * 5 / 9;
				mostrarInfo.setText("(°F - 32) × 5/9 = °C");
				break;
			case 3:
				valor = (valor - 32) * 5 / 9 + 273.15;
				mostrarInfo.setText("(°F - 32) × 9/5 + 273.15= °K");
				break;
			case 4:
				valor = (valor + 459.67);
				mostrarInfo.setText("(°F + 459.67) = °R");
				break;
			}
			break;
		case 3:
			switch (gradoDestino.getIdGrado()) {
			case 1:
				valor = (valor - 273.15);
				mostrarInfo.setText("(°K - 273.15) = °C");
				break;
			case 2:
				valor = (valor - 273.15) * 9 / 5 + 32;
				mostrarInfo.setText("(°K - 273.15) × 9/5 = °F");
				break;
			case 4:
				valor = (valor * 1.8);
				mostrarInfo.setText("(°K × 1.8 = °R");
				break;
			}
			break;
		case 4:
			switch (gradoDestino.getIdGrado()) {
			case 1:
				valor = (valor - 491.67) * 5 / 9;
				mostrarInfo.setText("(°R - 491.67) × 5/9 = °C");
				break;
			case 2:
				valor = (valor - 459.67);
				mostrarInfo.setText("(°R - 459.67) = °F");
				break;
			case 3:
				valor = valor * 5 / 9;
				mostrarInfo.setText("°R × 5/9 = °K");
				break;
			}
			break;
		default:
			throw new ExceptionProceso("Unexpected value : none select valor ");
		}
		
		
		return valor;
	}
}
