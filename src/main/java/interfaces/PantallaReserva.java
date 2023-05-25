package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

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
import javax.swing.border.TitledBorder;

public class PantallaReserva extends JPanel {
	private JPanel contenedorElementos;
	private VentanaElijirAsiento ventanaElijir;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public PantallaReserva(VentanaElijirAsiento ventanaElijir) {
		ArrayList<Persona> pasajeros = new ArrayList();
		this.ventanaElijir = ventanaElijir;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pasajero №1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
				JLabel labelAsiento = new JLabel("Asiento");
				GridBagConstraints gbc_labelAsiento = new GridBagConstraints();
				gbc_labelAsiento.anchor = GridBagConstraints.EAST;
				gbc_labelAsiento.insets = new Insets(0, 0, 5, 5);
				gbc_labelAsiento.gridx = 0;
				gbc_labelAsiento.gridy = 0;
				panel.add(labelAsiento, gbc_labelAsiento);
				
						JComboBox comboBoxAsiento = new JComboBox();
						GridBagConstraints gbc_comboBoxAsiento = new GridBagConstraints();
						gbc_comboBoxAsiento.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBoxAsiento.insets = new Insets(0, 0, 5, 5);
						gbc_comboBoxAsiento.gridx = 1;
						gbc_comboBoxAsiento.gridy = 0;
						panel.add(comboBoxAsiento, gbc_comboBoxAsiento);
						Vector<String> listaAsientos = new Vector<>(ventanaElijir.listaAsientos);
						comboBoxAsiento.setModel(new DefaultComboBoxModel(listaAsientos));
						comboBoxAsiento.setSelectedItem(listaAsientos.get(0));
						
								JLabel labelNombre_1 = new JLabel("Nombre");
								GridBagConstraints gbc_labelNombre_1 = new GridBagConstraints();
								gbc_labelNombre_1.anchor = GridBagConstraints.EAST;
								gbc_labelNombre_1.insets = new Insets(0, 0, 5, 5);
								gbc_labelNombre_1.gridx = 0;
								gbc_labelNombre_1.gridy = 1;
								panel.add(labelNombre_1, gbc_labelNombre_1);
								
										textField = new JTextField(ventanaElijir.clienteLogado.getNombre());
										GridBagConstraints gbc_textField = new GridBagConstraints();
										gbc_textField.anchor = GridBagConstraints.WEST;
										gbc_textField.gridwidth = 2;
										gbc_textField.insets = new Insets(0, 0, 5, 0);
										gbc_textField.gridx = 1;
										gbc_textField.gridy = 1;
										panel.add(textField, gbc_textField);
										textField.setEditable(false);
										textField.setColumns(10);
										
												JLabel labelApellido = new JLabel("Apellido");
												GridBagConstraints gbc_labelApellido = new GridBagConstraints();
												gbc_labelApellido.anchor = GridBagConstraints.EAST;
												gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
												gbc_labelApellido.gridx = 0;
												gbc_labelApellido.gridy = 2;
												panel.add(labelApellido, gbc_labelApellido);
												
														textField_1 = new JTextField(ventanaElijir.clienteLogado.getApellido());
														GridBagConstraints gbc_textField_1 = new GridBagConstraints();
														gbc_textField_1.anchor = GridBagConstraints.WEST;
														gbc_textField_1.gridwidth = 2;
														gbc_textField_1.insets = new Insets(0, 0, 5, 0);
														gbc_textField_1.gridx = 1;
														gbc_textField_1.gridy = 2;
														panel.add(textField_1, gbc_textField_1);
														textField_1.setEditable(false);
														textField_1.setColumns(10);
														
																JLabel labelGenero = new JLabel("Genero");
																GridBagConstraints gbc_labelGenero = new GridBagConstraints();
																gbc_labelGenero.anchor = GridBagConstraints.EAST;
																gbc_labelGenero.insets = new Insets(0, 0, 0, 5);
																gbc_labelGenero.gridx = 0;
																gbc_labelGenero.gridy = 3;
																panel.add(labelGenero, gbc_labelGenero);
																
																		JRadioButton radioHombre = new JRadioButton("Hombre");
																		GridBagConstraints gbc_radioHombre = new GridBagConstraints();
																		gbc_radioHombre.insets = new Insets(0, 0, 0, 5);
																		gbc_radioHombre.gridx = 1;
																		gbc_radioHombre.gridy = 3;
																		panel.add(radioHombre, gbc_radioHombre);
																		
																				radioHombre.setEnabled(false);
																				buttonGroup.add(radioHombre);
																				
																						JRadioButton radioMujer = new JRadioButton("Mujer");
																						GridBagConstraints gbc_radioMujer = new GridBagConstraints();
																						gbc_radioMujer.anchor = GridBagConstraints.WEST;
																						gbc_radioMujer.gridx = 2;
																						gbc_radioMujer.gridy = 3;
																						panel.add(radioMujer, gbc_radioMujer);
																						radioMujer.setEnabled(false);
																						buttonGroup.add(radioMujer);
		

		if (ventanaElijir.clienteLogado.getGenero() == 'h') {
			radioHombre.setSelected(true);
		} else {
			radioMujer.setSelected(true);
		}

		JScrollPane lista = new JScrollPane();
		lista.setBorder(null);
		GridBagConstraints gbc_lista = new GridBagConstraints();
		gbc_lista.anchor = GridBagConstraints.NORTH;
		gbc_lista.gridwidth = 2;
		gbc_lista.insets = new Insets(0, 0, 5, 0);
		gbc_lista.fill = GridBagConstraints.HORIZONTAL;
		gbc_lista.gridx = 0;
		gbc_lista.gridy = 1;
		add(lista, gbc_lista);

		contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		for (byte i = 0; i < ventanaElijir.cantidadAsientoElijidos - 1; i++) {
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
						Billete billete = ventanaElijir.vuelo.getBilletes().get(asiento.trim());
						System.out.println(billete);
						pasajeros.add(new Pasajero(nombre, apellido, genero, pasaporte, billete));
					}
				}
				ventanaElijir.clienteLogado.setBillete(
						ventanaElijir.vuelo.getBilletes().get(((String) comboBoxAsiento.getSelectedItem()).trim()));
				pasajeros.add(ventanaElijir.clienteLogado);
				HashSet<String> uniqueAsientos = new HashSet<>(asientos);
				
				String asientoDeCliente = comboBoxAsiento.getSelectedItem().toString();

				boolean noConcide = true;
				for (String asiento : asientos) {
				    if (asiento.equals(asientoDeCliente)) {
				    	noConcide = false;
				        break;
				    }
				}
				
				if (asientos.size() == uniqueAsientos.size() && noConcide) {
					Reserva reserva;
					try {
						reserva = new Reserva(ventanaElijir.vuelo, ventanaElijir.clienteLogado, pasajeros);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ventanaElijir.ventana.cambiarAPantalla(PantallaAreaPersonal.class);
					JOptionPane.showMessageDialog(ventanaElijir, "Reservado con exito", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					ventanaElijir.dispose();
				} else {
					asientos.clear();
					uniqueAsientos.clear();
					pasajeros.clear();
					JOptionPane.showMessageDialog(ventanaElijir, "No puedes elijir asientos iguales", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		
				JButton botonAtras = new JButton("Atras");
				botonAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventanaElijir.cantidadAsientoElijidos = 0;
						ventanaElijir.cambiarAPantalla(PantallaAsiento.class);
					}
				});
				
						GridBagConstraints gbc_botonAtras = new GridBagConstraints();
						gbc_botonAtras.anchor = GridBagConstraints.WEST;
						gbc_botonAtras.insets = new Insets(0, 0, 0, 5);
						gbc_botonAtras.gridx = 0;
						gbc_botonAtras.gridy = 2;
						add(botonAtras, gbc_botonAtras);
		GridBagConstraints gbc_botonReservar = new GridBagConstraints();
		gbc_botonReservar.anchor = GridBagConstraints.EAST;
		gbc_botonReservar.gridx = 1;
		gbc_botonReservar.gridy = 2;
		add(botonReservar, gbc_botonReservar);
	}
}
