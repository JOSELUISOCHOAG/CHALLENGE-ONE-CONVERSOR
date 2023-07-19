package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import procesos.Divisa;
import procesos.Informacion;
import procesos.Longitud;
import procesos.Salida;
import procesos.Temperatura;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class Aplicacion extends JFrame {

	private JPanel panelPrincipal;
	private JPanel panelBotones;
	private JPanel panelTitulo;
	private JPanel panelFooter;
	public CargaImagen panelImagen;
	private JButton btnDivisas;
	private JButton btnLongitud;
	private JButton btnTemperatura;
	private JButton btnInfo;
	private JButton btnSalir;
	private JLabel labelTitulo;
	/**
	 * Create the frame.
	 */
	public Aplicacion() {
		ImageIcon icono = new ImageIcon("src/img/Alura.png");
		setIconImage(icono.getImage());
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 908, 601);
		setSize(908, 601);
		setLocationRelativeTo(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		panelBotones = new JPanel();
		panelBotones.setBounds(27, 74, 153, 395);
		panelPrincipal.add(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));

		btnDivisas = Dibujar.dibujaBoton("Divisas",16);
		btnDivisas.setToolTipText("Conversor de monedas y Tipos de cambio");
		// btnDivisas.setForeground(new Color(12,160,94) );
		panelBotones.add(btnDivisas);

		panelImagen = new CargaImagen();
		panelImagen.setBounds(224, 74, 622, 395);
		panelImagen.setVisible(true);
		
		btnLongitud = Dibujar.dibujaBoton("Longitud",16);
		btnLongitud.setToolTipText("Conversor de medidas metricas");
		panelBotones.add(btnLongitud);

		btnTemperatura = Dibujar.dibujaBoton("Temperatura",16);
		btnTemperatura.setToolTipText("Conversor de tempertura");
		panelBotones.add(btnTemperatura);

		btnInfo = Dibujar.dibujaBoton("Informacion",16);
		btnInfo.setToolTipText("Acerca de...");
		panelBotones.add(btnInfo);

		btnSalir = Dibujar.dibujaBoton("Salir",16);
		btnSalir.setToolTipText("Salida de la aplicacion");
		panelBotones.add(btnSalir);

		labelTitulo = new JLabel("Conversor de Monedas - Medidas - Temperatura");
		labelTitulo.setBounds(10, 10, 720, 25);
		labelTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Lucida Console", Font.BOLD, 24));
		
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(69, 10, 740, 51);
		panelTitulo.setLayout(null);
		panelTitulo.add(labelTitulo);
		
		panelPrincipal.add(panelTitulo);
		panelPrincipal.add(panelImagen);
		panelImagen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Dialogo dialogo = new Dialogo(btnDivisas, btnLongitud, btnTemperatura, this);
		
		panelFooter = new JPanel();
		panelFooter.setBounds(69, 489, 740, 51);
		JLabel linea1Footer=Dibujar.dibujaTitulo("Challenge ONE ",24 );
		JLabel linea2Footer=Dibujar.dibujaTitulo("Back End  -  Java",24 );
		linea1Footer.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
		linea2Footer.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
		linea1Footer.setForeground(Color.black);
		linea2Footer.setForeground(new Color(12,160,94) );
		panelFooter.add(linea1Footer);
		panelFooter.add(linea2Footer);
		
		
		panelPrincipal.add(panelFooter);
		
		btnDivisas.addActionListener(new Divisa( panelPrincipal, panelImagen , btnInfo, btnLongitud, btnTemperatura,btnDivisas));
		btnLongitud.addActionListener(new Longitud( panelPrincipal, panelImagen ,btnInfo, btnLongitud, btnTemperatura,btnDivisas));
		btnTemperatura.addActionListener(new Temperatura( panelPrincipal, panelImagen, btnInfo, btnLongitud, btnTemperatura,btnDivisas));
		btnInfo.addActionListener(new Informacion( btnInfo, btnLongitud, btnTemperatura, btnDivisas, dialogo));
		btnSalir.addActionListener(new Salida(this));
		
		
		/*		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(0, 0, 111, 24);
		panelPrincipal.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
	*/
		
	}
	
	public JPanel getVentanaOperaciones() {
		return this.panelPrincipal;
	}
}
