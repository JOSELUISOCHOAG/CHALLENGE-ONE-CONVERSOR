package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Dialogo extends JDialog implements WindowListener {
	public static boolean invocado = false;
	private JButton btnDivisas;
	private JButton btnMedidas;
	private JButton btnTemperatura;

	public Dialogo(JButton btnDivisas, JButton btnLongitud, JButton btnTemperatura, JFrame frame) {
		this.btnDivisas = btnDivisas;
		this.btnMedidas = btnLongitud;
		this.btnTemperatura = btnTemperatura;
		setSize(300, 150);
		setTitle("Copyright");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();

		// Obtén las dimensiones del JDialog
		int dialogWidth = getWidth();
		int dialogHeight = getHeight();

		// Calcula las coordenadas x e y para centrar el JDialog
		int x = frame.getX() + (frameWidth - dialogWidth) / 2;
		int y = frame.getY() + (frameHeight - dialogHeight) / 2;

		// Establece las coordenadas para centrar el JDialog
		setLocation(x, y);

		Container cnt = getContentPane();
		cnt.setLayout(new GridLayout(4,1));
		JLabel titulo = Dibujar.dibujaTitulo('\n'+" Acerca de "+'\n', 12);
		JLabel lineaUno = Dibujar.dibujaLabel("Conversor v1.0 - Alura Challenge",12);
		JLabel lineaDos = Dibujar.dibujaLabel("Programacion JAVA-POO-JSwing",12);
		JLabel lineaTres = Dibujar.dibujaLabel("Jose Luis Ochoa. Julio, 2023",12);
		cnt.add(titulo);
		cnt.add(lineaUno);
		cnt.add(lineaDos);
		cnt.add(lineaTres);
		invocado = true;
		addWindowListener(this);
	}

	public static void mostrar(boolean visible) {
		if (invocado) {
			invocado = false;
		} else {
			invocado = true;
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		invocado = true;
		this.btnDivisas.setEnabled(invocado);
		this.btnMedidas.setEnabled(invocado);
		this.btnTemperatura.setEnabled(invocado);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}