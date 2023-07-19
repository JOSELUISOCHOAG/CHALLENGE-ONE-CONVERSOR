package procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Salida implements ActionListener {
	JFrame ventana;
	public Salida(JFrame ventana) {
		// TODO Auto-generated constructor stub
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int opcion = JOptionPane.showOptionDialog(ventana, "¿Salir de la Aplicaion?", "Mensaje de Confirmación",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (opcion == JOptionPane.YES_OPTION) {
    		this.ventana.dispose();
    		System.exit(0);
        }
	}
}
