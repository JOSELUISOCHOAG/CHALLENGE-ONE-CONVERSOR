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

public class Temperatura implements ActionListener {

	private static JComboBox<Grado> comboGradoOrigen;
	private static JComboBox<Grado> comboGradoDestino;
	private Grado gradoOrigen = new Grado();
	private Grado gradoDestino = new Grado();
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
	

	public Temperatura(JPanel panelPrincipal, JPanel panelImagen ,JButton btnInfo, JButton btnLongitud, JButton btnTemperatura,
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
		comboGradoOrigen = new JComboBox<Grado>(llenarListaGrados().toArray(new Grado[0]));
		comboGradoDestino = new JComboBox<Grado>();
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

		JLabel lblTitulo = Dibujar.dibujaTitulo("Operaciones con unidades de Temperatura", 20);
		lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTitulo);

		lblMonto = Dibujar.dibujaLabel("Cantidad a Convertir", 14);
		panelMonto.add(lblMonto);

		txtMonto = Dibujar.dibujaGetNum(20, 16);
		txtMonto.setToolTipText("Ingrese el monto a Cambiar y presiones Enter");
		txtMonto.setEditable(true);
		txtMonto.requestFocusInWindow(); // .requestFocus();
		txtMonto.setHorizontalAlignment(JTextField.RIGHT);
		panelMonto.add(txtMonto);

		JLabel lblTipoOrigen = Dibujar.dibujaLabel("De", 14);
		panelOrigen.add(lblTipoOrigen);

		JLabel lblTipoDestino = Dibujar.dibujaLabel("A", 14);
		panelDestino.add(lblTipoDestino);

		comboGradoOrigen.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelOrigen.add(comboGradoOrigen);

		comboGradoDestino.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelDestino.add(comboGradoDestino);

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

		resultadoInfo = Dibujar.dibujaLabel("Formula utilizada", 14);
		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 16);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Valor resultante", 14);
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
				//	comboGradoOrigen.requestFocus();
				//	comboGradoOrigen.setPopupVisible(true);
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
						comboGradoOrigen.requestFocus();
						comboGradoOrigen.setPopupVisible(true);
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
				gradoOrigen = (Grado) comboGradoOrigen.getSelectedItem();
				comboGradoDestino.requestFocus();
				mostrarGradosSinSeleccion(gradoOrigen);
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
					gradoDestino = (Grado) comboGradoDestino.getSelectedItem();
					if (cambio.isEmpty()) {
						throw new ExceptionProceso("Ingrese un valor para convertir");
					}
					if (Double.parseDouble(cambio) <= 0) {
						throw new ExceptionProceso("El monto debe ser mayor a 0");
					}
					if (gradoDestino.getNombreGrado() == null || gradoOrigen.getNombreGrado() == null) {
						throw new ExceptionProceso("No se han seleccionado tipos de grados");
					}
					double valor = Double.parseDouble(cambio);
					valor = gradoOrigen.convertir(gradoDestino, valor, mostrarInfo);
					// mostrarInfo.setText(gradoOrigen.cambio() + " -> " + gradoDestino.getValorGrado() + gradoDestino.getSimbol());
					DecimalFormat formato = new DecimalFormat("#.00");
					mostrarInfo.setHorizontalAlignment(SwingConstants.CENTER);
					mostrarValor.setText(formato.format(valor) + " " + gradoDestino);
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

	public static List<Grado> llenarListaGrados() {
		List<Grado> listaGrados = new ArrayList<>();
		listaGrados.clear();
		Grado grado1 = new Grado(1, "Celsius   ", 32, "°C");
		Grado grado2 = new Grado(2, "Fahrenheit", -32, "°F");
		Grado grado3 = new Grado(3, "Kelvin    ", 273, "°K");
		Grado grado4 = new Grado(4, "Rankine   ", 1.8, "°R");
		
		listaGrados.add(grado1);
		listaGrados.add(grado2);
		listaGrados.add(grado3);
		listaGrados.add(grado4);
		return listaGrados;
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

		resultadoInfo = Dibujar.dibujaLabel("Formula Utilizada", 14);
		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 17);
		mostrarInfo.setHorizontalAlignment(JTextField.RIGHT);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Valor resultante", 14);
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
				//	comboGradoOrigen.requestFocus();
				//	comboGradoOrigen.setPopupVisible(true);
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
						comboGradoOrigen.requestFocus();
						comboGradoOrigen.setPopupVisible(true);
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

	static void mostrarGradosSinSeleccion(Grado gradoSeleccionada) {
		comboGradoDestino.removeAllItems();
		ComboBoxModel<Grado> model = comboGradoOrigen.getModel();
		for (int i = 0; i < model.getSize(); i++) {
			Grado grado = model.getElementAt(i);
			if (!grado.equals(gradoSeleccionada)) {
				comboGradoDestino.addItem(grado);
			}
		}
		comboGradoDestino.requestFocus();
		comboGradoDestino.setSelectedIndex(0);
		comboGradoDestino.setPopupVisible(true);
	}

}
