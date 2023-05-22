package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import clases.Billete;
import clases.Pasajero;
import clases.Persona;
import clases.Reserva;
import clases.Vuelo;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class PantallaReserva extends JPanel{
	private JPanel contenedorElementos;
	private VentanaElijirAsiento2 ventanaElijir;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public PantallaReserva(VentanaElijirAsiento2 ventanaElijir) {
		ArrayList<Persona> pasajeros = new ArrayList();
		this.ventanaElijir = ventanaElijir;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelPasajero_1 = new JLabel("Pasajero №1");
		GridBagConstraints gbc_labelPasajero_1 = new GridBagConstraints();
		gbc_labelPasajero_1.gridwidth = 3;
		gbc_labelPasajero_1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero_1.gridx = 1;
		gbc_labelPasajero_1.gridy = 0;
		add(labelPasajero_1, gbc_labelPasajero_1);
		
		String asientos = "";
		for(byte i = 0; i<ventanaElijir.listaAsientos.size(); i++) {
			asientos += ventanaElijir.listaAsientos.get(i) +",";
		}
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaElijir.cantidadAsientoElijidos = 0;
				ventanaElijir.cambiarAPantalla(PantallaAsiento.class);
			}
		});
		
		JLabel labelAsiento = new JLabel("Asiento");
		GridBagConstraints gbc_labelAsiento = new GridBagConstraints();
		gbc_labelAsiento.anchor = GridBagConstraints.EAST;
		gbc_labelAsiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento.gridx = 1;
		gbc_labelAsiento.gridy = 1;
		add(labelAsiento, gbc_labelAsiento);
		
		JComboBox comboBox = new JComboBox();
		String[] listaAsientos = ventanaElijir.listaAsientos.toArray(new String[ventanaElijir.listaAsientos.size()]);
		comboBox.setModel(new DefaultComboBoxModel(listaAsientos));
		comboBox.setSelectedItem(listaAsientos[0]);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		JLabel labelNombre_1 = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre_1 = new GridBagConstraints();
		gbc_labelNombre_1.anchor = GridBagConstraints.EAST;
		gbc_labelNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre_1.gridx = 1;
		gbc_labelNombre_1.gridy = 2;
		add(labelNombre_1, gbc_labelNombre_1);
		
		textField = new JTextField(ventanaElijir.clienteLogado.getNombre());
		textField.setEditable(false);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 1;
		gbc_labelApellido.gridy = 3;
		add(labelApellido, gbc_labelApellido);
		
		textField_1 = new JTextField(ventanaElijir.clienteLogado.getApellido());
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		
		JLabel labelGenero = new JLabel("Genero");
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.anchor = GridBagConstraints.EAST;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 1;
		gbc_labelGenero.gridy = 4;
		add(labelGenero, gbc_labelGenero);
		
		JRadioButton radioHombre = new JRadioButton("Hombre");
		
		radioHombre.setEnabled(false);
		buttonGroup.add(radioHombre);
		GridBagConstraints gbc_radioHombre = new GridBagConstraints();
		gbc_radioHombre.insets = new Insets(0, 0, 5, 5);
		gbc_radioHombre.gridx = 2;
		gbc_radioHombre.gridy = 4;
		add(radioHombre, gbc_radioHombre);
		
		JRadioButton radioMujer = new JRadioButton("Mujer");
		radioMujer.setEnabled(false);
		buttonGroup.add(radioMujer);
		GridBagConstraints gbc_radioMujer = new GridBagConstraints();
		gbc_radioMujer.anchor = GridBagConstraints.WEST;
		gbc_radioMujer.insets = new Insets(0, 0, 5, 5);
		gbc_radioMujer.gridx = 3;
		gbc_radioMujer.gridy = 4;
		add(radioMujer, gbc_radioMujer);
		
		if(ventanaElijir.clienteLogado.getGenero() == 'h') {
			radioHombre.setSelected(true);
		} else {
			radioMujer.setSelected(true);
		}
		
		JScrollPane lista = new JScrollPane();
		lista.setBorder(null);
		GridBagConstraints gbc_lista = new GridBagConstraints();
		gbc_lista.anchor = GridBagConstraints.NORTH;
		gbc_lista.gridheight = 3;
		gbc_lista.gridwidth = 3;
		gbc_lista.insets = new Insets(0, 0, 5, 5);
		gbc_lista.fill = GridBagConstraints.HORIZONTAL;
		gbc_lista.gridx = 1;
		gbc_lista.gridy = 6;
		add(lista, gbc_lista);
		
		contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		for (byte i  = 0; i < ventanaElijir.cantidadAsientoElijidos-1; i++) {
			contenedorElementos.add(new ElementoReserva(ventanaElijir, i));
		}
		contenedorElementos.revalidate();
		contenedorElementos.repaint();
		
		
		
		JButton botonReservar = new JButton("Reservar");
		botonReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> nombres = new ArrayList();
				ArrayList<String> apellidos = new ArrayList();
				ArrayList<Character> generos = new ArrayList();
				ArrayList<String> pasaportes = new ArrayList();
				ArrayList<String> asientos = new ArrayList();
				for (Component componente : contenedorElementos.getComponents()) {
				    if (componente instanceof ElementoReserva) {
				        ElementoReserva elemento = (ElementoReserva) componente;
				        String nombre = elemento.getNombre();
				        String apellido = elemento.getApellido();
				        char genero = elemento.getGenero();
				        String pasaporte = elemento.getPasaporte();
				        String asiento = elemento.getAsiento();
				        nombres.add(nombre);
				        apellidos.add(apellido);
				        generos.add(genero);
				        pasaportes.add(pasaporte);
				        asientos.add(asiento);
				        Billete billete = ventanaElijir.vuelo.getBilletes().get(asiento);
				        System.out.println(billete);
				        pasajeros.add(new Pasajero(nombre, apellido, genero, pasaporte, asiento));
				    }
				}
				pasajeros.add(ventanaElijir.clienteLogado);				
				Reserva reserva;
				try {
					reserva = new Reserva(ventanaElijir.vuelo, ventanaElijir.clienteLogado, pasajeros);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventanaElijir.dispose();
			}
		});
		GridBagConstraints gbc_botonReservar = new GridBagConstraints();
		gbc_botonReservar.anchor = GridBagConstraints.EAST;
		gbc_botonReservar.insets = new Insets(0, 0, 5, 5);
		gbc_botonReservar.gridx = 3;
		gbc_botonReservar.gridy = 9;
		add(botonReservar, gbc_botonReservar);
		
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.NORTHWEST;
		gbc_botonAtras.insets = new Insets(0, 0, 0, 5);
		gbc_botonAtras.gridx = 1;
		gbc_botonAtras.gridy = 10;
		add(botonAtras, gbc_botonAtras);
	}
}
