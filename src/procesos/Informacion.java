package procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gui.Dialogo;

public class Informacion implements ActionListener {

	private JButton btnDivisas;
	private JButton btnLongitud;
	private JButton btnTemperatura;
	private JButton btnInfo;
	private JDialog dialogo;

	public Informacion(JButton btnInfo, JButton btnLongitud, JButton btnTemperatura,JButton btnDivisas ,JDialog dialogo) {
		// TODO Auto-generated constructor stub
		this.dialogo = dialogo;
		this.btnDivisas = btnDivisas;
		this.btnLongitud = btnLongitud;
		this.btnTemperatura = btnTemperatura;
		this.btnInfo = btnInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.btnDivisas.setEnabled(!Dialogo.invocado);
		this.btnLongitud.setEnabled(!Dialogo.invocado);
		this.btnTemperatura.setEnabled(!Dialogo.invocado);		
		this.dialogo.setVisible(Dialogo.invocado);
		Dialogo.mostrar(Dialogo.invocado);
	}
}
