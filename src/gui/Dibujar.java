package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import procesos.Divisa;
import procesos.Moneda;

public class Dibujar {
	
	public static JPanel dibujaPanel(JPanel panelOrigen) {
  
		JPanel panelNuevo = new JPanel();
		panelNuevo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panelNuevo.setBounds(224, 74, 622, 395);
		panelNuevo.setVisible(true);
		panelOrigen.add(panelNuevo);
		panelOrigen.revalidate();
		return panelNuevo;
	}

	public static JLabel dibujaLabel(String texto,int font ) {
		JLabel lbl = new JLabel(texto);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Lucida Console", Font.PLAIN, font));
		return lbl;		
	}
	public static JLabel dibujaTitulo(String texto,int font ) {
		JLabel lbl = new JLabel(texto);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Lucida Console", Font.BOLD, font));
		return lbl;		
	}
	
	public static JButton dibujaBoton(String texto, int font ) {
		JButton btn = new JButton(texto);
		btn.setFont(new Font("Lucida Console", Font.PLAIN, font));
		return btn;
	}
	
	public static JTextField dibujaGetNum(int longi, int font) {
		JTextField text = new JTextField(longi);
		text.setFont(new Font("Lucida Console", Font.PLAIN, font));
		text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Permitir números y un punto decimal
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }

                // Permitir solo un punto decimal
                if (c == '.' && text.getText().contains(".")) {
                    e.consume();
                }
            }
        });
	
		return text;
	}


	public static JTextField dibujaGetString(int longi, int font) {
		JTextField text = new JTextField(longi);
		text.setFont(new Font("Lucida Console", Font.PLAIN, font));
		
		return text;
	}

	
	public static JComboBox menuCombo(JComboBox combo) {
		combo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		return combo;
	}
	
	
}
