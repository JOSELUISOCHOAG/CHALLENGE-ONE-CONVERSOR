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

public class Divisa implements ActionListener {

	private static JComboBox<Moneda> comboMonedaOrigen;
	private static JComboBox<Moneda> comboMonedaDestino;
	private Moneda monedaOrigen = new Moneda();
	private Moneda monedaDestino = new Moneda();
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
	

	public Divisa(JPanel panelPrincipal, JPanel panelImagen ,JButton btnInfo, JButton btnLongitud, JButton btnTemperatura,
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
		comboMonedaOrigen = new JComboBox<Moneda>(llenarListaMonedas().toArray(new Moneda[0]));
		comboMonedaDestino = new JComboBox<Moneda>();
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

		JLabel lblTitulo = Dibujar.dibujaTitulo("Operaciones de cambio con Divisas", 20);
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

		comboMonedaOrigen.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelOrigen.add(comboMonedaOrigen);

		comboMonedaDestino.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		panelDestino.add(comboMonedaDestino);

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

		resultadoInfo = Dibujar.dibujaLabel("Su tipo de Cambio es", 14);
		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 16);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Total convertido", 14);
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
				//	comboMonedaOrigen.requestFocus();
				//	comboMonedaOrigen.setPopupVisible(true);
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
						comboMonedaOrigen.requestFocus();
						comboMonedaOrigen.setPopupVisible(true);
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
				monedaOrigen = (Moneda) comboMonedaOrigen.getSelectedItem();
				comboMonedaDestino.requestFocus();
				mostrarMonedasSinSeleccion(monedaOrigen);
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
					monedaDestino = (Moneda) comboMonedaDestino.getSelectedItem();
					if (cambio.isEmpty()) {
						throw new ExceptionProceso("Ingrese un valor para convertir");
					}
					if (Double.parseDouble(cambio) <= 0) {
						throw new ExceptionProceso("El monto debe ser mayor a 0");
					}
					if (monedaDestino.getNombreMoneda() == null || monedaOrigen.getNombreMoneda() == null) {
						throw new ExceptionProceso("No se han seleccionado tipos de monedas");
					}
					double valor = Double.parseDouble(cambio);
					valor = monedaOrigen.convertir(monedaDestino, valor);
					mostrarInfo.setText(monedaOrigen.cambio() + " -> " + monedaDestino.getValorMoneda() + monedaDestino.getSimbol());
					DecimalFormat formato = new DecimalFormat("#.00");
					mostrarInfo.setHorizontalAlignment(SwingConstants.CENTER);
					mostrarValor.setText(formato.format(valor) + " " + monedaDestino);
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

	public static List<Moneda> llenarListaMonedas() {
		List<Moneda> listaMonedas = new ArrayList<>();
		listaMonedas.clear();
		Moneda moneda1 = new Moneda(1, "Dolar USA     ", 1.0, "$");
		Moneda moneda2 = new Moneda(2, "Euro EUR      ", 1.122, "€");
		Moneda moneda3 = new Moneda(3, "Libra GBP     ", 1.31, "£");
		Moneda moneda4 = new Moneda(4, "Yen JAP       ", 110.35, "¥");
		Moneda moneda5 = new Moneda(5, "Dolar CAN     ", 1.23, "C$");
		Moneda moneda6 = new Moneda(6, "Peso CLP      ", 811.32, "c$");
		Moneda moneda7 = new Moneda(7, "Peso COP      ", 4099.00, "$c");
		Moneda moneda8 = new Moneda(8, "Bolívar VEN   ", 30.15, "BsD");
		Moneda moneda9 = new Moneda(9, "Peso ARG      ", 512.25, "$a");
		Moneda moneda10 = new Moneda(10, "Boliviano BOB", 6.96, "Bs");
		Moneda moneda11 = new Moneda(11, "Real BRA     ", 5.18, "R$");
		Moneda moneda12 = new Moneda(12, "Sol PER       ", 3.56, "S/.");

		listaMonedas.add(moneda1);
		listaMonedas.add(moneda2);
		listaMonedas.add(moneda3);
		listaMonedas.add(moneda4);
		listaMonedas.add(moneda5);
		listaMonedas.add(moneda6);
		listaMonedas.add(moneda7);
		listaMonedas.add(moneda8);
		listaMonedas.add(moneda9);
		listaMonedas.add(moneda10);
		listaMonedas.add(moneda11);
		listaMonedas.add(moneda12);
		return listaMonedas;
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

		resultadoInfo = Dibujar.dibujaLabel("Su tipo de Cambio es", 14);
		panelResultado.add(resultadoInfo);

		mostrarInfo = Dibujar.dibujaGetNum(30, 17);
		mostrarInfo.setHorizontalAlignment(JTextField.RIGHT);
		mostrarInfo.setEditable(false);
		panelResultado.add(mostrarInfo);

		resultadoValor = Dibujar.dibujaLabel("Total convertido", 14);
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
				//	comboMonedaOrigen.requestFocus();
				//	comboMonedaOrigen.setPopupVisible(true);
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
						comboMonedaOrigen.requestFocus();
						comboMonedaOrigen.setPopupVisible(true);
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

	static void mostrarMonedasSinSeleccion(Moneda monedaSeleccionada) {
		comboMonedaDestino.removeAllItems();
		ComboBoxModel<Moneda> model = comboMonedaOrigen.getModel();
		for (int i = 0; i < model.getSize(); i++) {
			Moneda moneda = model.getElementAt(i);
			if (!moneda.equals(monedaSeleccionada)) {
				comboMonedaDestino.addItem(moneda);
			}
		}
		comboMonedaDestino.requestFocus();
		comboMonedaDestino.setSelectedIndex(0);
		comboMonedaDestino.setPopupVisible(true);
	}

}
