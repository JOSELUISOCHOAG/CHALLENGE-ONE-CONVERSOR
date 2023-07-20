package procesos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

import gui.Aplicacion;
import gui.Dibujar;

public class Longitud implements ActionListener {

	private static JComboBox<Medida> comboMedidaOrigen;
	private static JComboBox<Medida> comboMedidaDestino;
	private Medida medidaOrigen = new Medida();
	private Medida medidaDestino = new Medida();
	private JPanel panelProceso;
	private JButton btnInfo;
	private JButton btnMedidas;
	private JButton btnTemperatura;
	private JButton btnDivisas;
	private JPanel panelPrincipal;
	private JPanel panelImagen;

	private JTextField txtMonto;
	private JTextField mostrarValor;
	private JTextField mostrarInfo;
	private JButton btnContinuar;
	private JButton btnConvertir;
	private JButton btnSeleccionar;
	private JLabel resultadoInfo;
	private JLabel resultadoValor;
	private JLabel lblMonto;
	

	public Longitud(JPanel panelPrincipal, JPanel panelImagen ,JButton btnInfo, JButton btnLongitud, JButton btnTemperatura,
			JButton btnDivisas) {

		this.btnInfo = btnInfo;
		this.btnMedidas = btnLongitud;
		this.btnTemperatura = btnTemperatura;
		this.panelPrincipal = panelPrincipal;
		this.btnDivisas = btnDivisas;
		this.panelImagen = panelImagen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panelImagen.setVisible(false);
		comboMedidaOrigen = new JComboBox<Medida>(llenarListaMedidas().toArray(new Medida[0]));
		comboMedidaDestino = new JComboBox<Medida>();
		panelProceso = Dibujar.dibujaPanel(panelPrincipal);
		JPanel panelTitulo = Dibujar.dibujaPanel(panelProceso);
		JPanel panelMonto = Dibujar.dibujaPanel(panelProceso);
		JPanel panelOrigen = Dibujar.dibujaPanel(panelProceso);
		JPanel panelDestino = Dibujar.dibujaPanel(panelProceso);
		JPanel panelResultado = Dibujar.dibujaPanel(panelProceso);
		JPanel panelBotones = Dibujar.dibujaPanel(panelProceso);

		// panelProceso.setLayout(new BoxLayout(panelProceso, BoxLayout.Y_AXIS));
		panelProceso.setLayout(new GridLayout(6, 1, 25, 10));
		panelProceso.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));

		panelMonto.setLayout(new GridLayout(1, 2, 10, 10));
		panelResultado.setLayout(new GridLayout(2, 2, 2, 2));
		panelBotones.setLayout(new GridLayout(1, 2, 20, 10));
		panelDestino.setLayout(new GridLayout(1, 3, 10, 10));
		panelOrigen.setLayout(new GridLayout(1, 3));

		btnInfo.setEnabled(false);
		btnMedidas.setEnabled(false);
		btnTemperatura.setEnabled(false);
		btnDivisas.setEnabled(false);

		JLabel lblTitulo = Dibujar.dibujaTitulo("Operaciones con unidades de Longitud", 20);
		lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTitulo);

		lblMonto = Dibujar.dibujaLabel("Cantidad a Convertir", 14);
		panelMonto.add(lblMonto);

		txtMonto = Dibujar.dibujaGetNum(20, 16);
		txtMonto.setToolTipText("Ingrese la distancia a convertir y presiones Enter");
		txtMonto.setEditable(true);
		txtMonto.requestFocusInWindow(); // .requestFocus();
		txtMonto.setHorizontalAlignment(JTextField.RIGHT);
		panelMonto.add(txtMonto);

		JLabel lblTipoOrigen = Dibujar.dibujaLabel("De", 14);
		panelOrigen.add(lblTipoOrigen);

		JLabel lblTipoDestino = Dibujar.dibujaLabel("A", 14);
		panelDestino.add(lblTipoDestino);

		comboMedidaOrigen.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelOrigen.add(comboMedidaOrigen);

		comboMedidaDestino.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelDestino.add(comboMedidaDestino);

		btnSeleccionar = Dibujar.dibujaBoton("Seleccionar", 14);
		btnSeleccionar.setEnabled(false);
		panelOrigen.add(btnSeleccionar);

		btnConvertir = Dibujar.dibujaBoton("Convertir", 14);
		panelDestino.add(btnConvertir);

		JButton btnRegresar = Dibujar.dibujaBoton("Regresar", 14);
		panelBotones.add(btnRegresar);

		btnContinuar = Dibujar.dibujaBoton("Continuar", 14);
		btnContinuar.setEnabled(false);
		panelBotones.add(btnContinuar);

		resultadoInfo = Dibujar.dibujaLabel("Factor de conversion", 14);
		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 16);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Valor equivalente", 14);
		panelResultado.add(resultadoValor);

		mostrarValor = Dibujar.dibujaGetNum(30, 16);
		mostrarValor.setEditable(false);
		panelResultado.add(mostrarValor);

		panelProceso.revalidate();
		panelPrincipal.revalidate();

		txtMonto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!txtMonto.getText().isEmpty()) {
					btnSeleccionar.setEnabled(true);
				//	comboMedidaOrigen.requestFocus();
				//	comboMedidaOrigen.setPopupVisible(true);
				} 
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!txtMonto.getText().isEmpty()) {
						btnSeleccionar.setEnabled(true);
						comboMedidaOrigen.requestFocus();
						comboMedidaOrigen.setPopupVisible(true);
					} else {
						JOptionPane.showMessageDialog(panelPrincipal, "Ingrese un valor para convertir", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		txtMonto.requestFocusInWindow();

		btnSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				medidaOrigen = (Medida) comboMedidaOrigen.getSelectedItem();
				comboMedidaDestino.requestFocus();
				mostrarMedidasSinSeleccion(medidaOrigen);
				txtMonto.setEditable(false);
			}
		});

		btnConvertir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnContinuar.setEnabled(true);
					mostrarInfo.setEditable(false);
					mostrarValor.setEditable(false);
					String cambio = txtMonto.getText();
					medidaDestino = (Medida) comboMedidaDestino.getSelectedItem();
					if (cambio.isEmpty()) {
						throw new ExceptionProceso("Ingrese un valor para convertir");
					}
					if (Double.parseDouble(cambio) <= 0) {
						throw new ExceptionProceso("El monto debe ser mayor a 0");
					}
					if (medidaDestino.getNombreMedida() == null || medidaOrigen.getNombreMedida() == null) {
						throw new ExceptionProceso("No se han seleccionado tipos de medidas");
					}
					long valor = Long.parseLong(cambio);
					valor = medidaOrigen.convertir(medidaDestino, valor);
					mostrarInfo.setText(medidaOrigen.cambio() + " -> " + medidaDestino.cambio(medidaOrigen) );
					DecimalFormat formato = new DecimalFormat("#.00");
					mostrarInfo.setHorizontalAlignment(SwingConstants.CENTER);
					mostrarValor.setText(formato.format(valor) + " " + medidaDestino);
					mostrarValor.setHorizontalAlignment(SwingConstants.RIGHT);
					panelResultado.revalidate();
				} catch (ExceptionProceso error) {
					JOptionPane.showMessageDialog(panelPrincipal, error.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					refrescar(panelResultado, panelMonto);
					// TODO: handle exception
				}
			}
		});

		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProceso.removeAll();
				panelProceso.setVisible(false);
				panelImagen.setVisible(true);
				panelPrincipal.revalidate();
				btnInfo.setEnabled(true);
				btnMedidas.setEnabled(true);
				btnTemperatura.setEnabled(true);
				btnDivisas.setEnabled(true);
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSeleccionar.setEnabled(false);
				btnContinuar.setEnabled(false);
				refrescar(panelResultado, panelMonto);
			}
		});

	}

	public static List<Medida> llenarListaMedidas() {
		List<Medida> listaMedidas = new ArrayList<>();
		listaMedidas.clear();
		Medida medida1 = new Medida(1,  "Kilometro  ", 1000, "km");
		Medida medida2 = new Medida(2,  "Hectometro ",  100, "hm");
		Medida medida3 = new Medida(3,  "Decametro  ",   10, "dam");
		Medida medida4 = new Medida(4,  "Metro      ",    1, "m");
		Medida medida5 = new Medida(5,  "Decimetro  ",  0.1, "dm");
		Medida medida6 = new Medida(6,  "Centimetro ", 0.01, "cm");
		Medida medida7 = new Medida(7,  "Milimetro  ",0.001, "mm");
		
		listaMedidas.add(medida1);
		listaMedidas.add(medida2);
		listaMedidas.add(medida3);
		listaMedidas.add(medida4);
		listaMedidas.add(medida5);
		listaMedidas.add(medida6);
		listaMedidas.add(medida7);
		return listaMedidas;
	}

	private void refrescar(JPanel panelResultado, JPanel panelMonto) {

		panelResultado.removeAll();
		panelMonto.removeAll();
		
		lblMonto = Dibujar.dibujaLabel("Cantidad a Convertir", 14);
		panelMonto.add(lblMonto);
		txtMonto = Dibujar.dibujaGetNum(20, 16);
		txtMonto.setEditable(true);
		txtMonto.requestFocusInWindow(); // .requestFocus();
		txtMonto.setHorizontalAlignment(JTextField.RIGHT);
		panelMonto.add(txtMonto);

		
		resultadoInfo = Dibujar.dibujaLabel("Factor de conversion", 14);

		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 17);
		mostrarInfo.setHorizontalAlignment(JTextField.RIGHT);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Valor equivalente", 14);
		resultadoValor.setHorizontalAlignment(JTextField.RIGHT);
		panelResultado.add(resultadoValor);

		mostrarValor = Dibujar.dibujaGetNum(30, 17);
		mostrarValor.setEditable(false);
		panelResultado.add(mostrarValor);

		txtMonto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!txtMonto.getText().isEmpty()) {
					btnSeleccionar.setEnabled(true);
				//	comboMedidaOrigen.requestFocus();
				//	comboMedidaOrigen.setPopupVisible(true);
				} 
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!txtMonto.getText().isEmpty()) {
						btnSeleccionar.setEnabled(true);
						comboMedidaOrigen.requestFocus();
						comboMedidaOrigen.setPopupVisible(true);
					} else {
						JOptionPane.showMessageDialog(panelPrincipal, "Ingrese un valor para convertir", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		txtMonto.requestFocusInWindow();
		panelMonto.repaint();
		panelMonto.revalidate();

		panelResultado.repaint();
		panelResultado.revalidate();
		panelProceso.revalidate();
	}

	static void mostrarMedidasSinSeleccion(Medida medidaSeleccionada) {
		comboMedidaDestino.removeAllItems();
		ComboBoxModel<Medida> model = comboMedidaOrigen.getModel();
		for (int i = 0; i < model.getSize(); i++) {
			Medida medida = model.getElementAt(i);
			if (!medida.equals(medidaSeleccionada)) {
				comboMedidaDestino.addItem(medida);
			}
		}
		comboMedidaDestino.requestFocus();
		comboMedidaDestino.setSelectedIndex(0);
		comboMedidaDestino.setPopupVisible(true);
	}

}
