package interfaces;

import javax.swing.JPanel;

import clases.Cliente;
import clases.Vuelo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.SpinnerListModel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class ElementoReserva extends JPanel{
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoPasaporte;
	private VentanaElijirAsiento ventanaElijir;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String nombre;
	private String apellido;
	private char genero;
	private String pasaporte;
	private String asiento;
	JRadioButton radioHombre;
	JComboBox aientoEligido;
	public ElementoReserva(VentanaElijirAsiento v, byte i) {		
		this.ventanaElijir = v;	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelPasajero = new JLabel("Pasajero №" + (i+2));
		GridBagConstraints gbc_labelPasajero = new GridBagConstraints();
		gbc_labelPasajero.gridwidth = 3;
		gbc_labelPasajero.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero.gridx = 0;
		gbc_labelPasajero.gridy = 0;
		add(labelPasajero, gbc_labelPasajero);
		
		JLabel labelAsiento = new JLabel("Asiento");
		GridBagConstraints gbc_labelAsiento = new GridBagConstraints();
		gbc_labelAsiento.anchor = GridBagConstraints.EAST;
		gbc_labelAsiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento.gridx = 0;
		gbc_labelAsiento.gridy = 1;
		add(labelAsiento, gbc_labelAsiento);
		
		aientoEligido = new JComboBox();
		String[] listaAsientos = ventanaElijir.listaAsientos.toArray(new String[ventanaElijir.listaAsientos.size()]);
		aientoEligido.setModel(new DefaultComboBoxModel(listaAsientos));
		aientoEligido.setSelectedItem(listaAsientos[i+1]);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(aientoEligido, gbc_comboBox);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 2;
		add(labelNombre, gbc_labelNombre);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.anchor = GridBagConstraints.WEST;
		gbc_campoNombre.gridwidth = 2;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 0);
		gbc_campoNombre.gridx = 1;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 3;
		add(labelApellido, gbc_labelApellido);
		
		campoApellido = new JTextField();
		GridBagConstraints gbc_campoApellido = new GridBagConstraints();
		gbc_campoApellido.anchor = GridBagConstraints.WEST;
		gbc_campoApellido.gridwidth = 2;
		gbc_campoApellido.insets = new Insets(0, 0, 5, 0);
		gbc_campoApellido.gridx = 1;
		gbc_campoApellido.gridy = 3;
		add(campoApellido, gbc_campoApellido);
		campoApellido.setColumns(10);
		
		JLabel labelPasaporte = new JLabel("Pasaporte");
		GridBagConstraints gbc_labelPasaporte = new GridBagConstraints();
		gbc_labelPasaporte.anchor = GridBagConstraints.EAST;
		gbc_labelPasaporte.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasaporte.gridx = 0;
		gbc_labelPasaporte.gridy = 4;
		add(labelPasaporte, gbc_labelPasaporte);
		
		campoPasaporte = new JTextField();
		GridBagConstraints gbc_campoPasaporte = new GridBagConstraints();
		gbc_campoPasaporte.anchor = GridBagConstraints.WEST;
		gbc_campoPasaporte.gridwidth = 2;
		gbc_campoPasaporte.insets = new Insets(0, 0, 5, 0);
		gbc_campoPasaporte.gridx = 1;
		gbc_campoPasaporte.gridy = 4;
		add(campoPasaporte, gbc_campoPasaporte);
		campoPasaporte.setColumns(10);
		
		JLabel labelGenero = new JLabel("Genero");
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.anchor = GridBagConstraints.EAST;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 0;
		gbc_labelGenero.gridy = 5;
		add(labelGenero, gbc_labelGenero);
		
		radioHombre = new JRadioButton("Hombre");
		radioHombre.setSelected(true);
		buttonGroup.add(radioHombre);
		GridBagConstraints gbc_radioHombre = new GridBagConstraints();
		gbc_radioHombre.insets = new Insets(0, 0, 5, 5);
		gbc_radioHombre.gridx = 1;
		gbc_radioHombre.gridy = 5;
		add(radioHombre, gbc_radioHombre);
		
		JRadioButton radioMujer = new JRadioButton("Mujer");
		buttonGroup.add(radioMujer);
		GridBagConstraints gbc_radioMujer = new GridBagConstraints();
		gbc_radioMujer.insets = new Insets(0, 0, 5, 0);
		gbc_radioMujer.anchor = GridBagConstraints.WEST;
		gbc_radioMujer.gridx = 2;
		gbc_radioMujer.gridy = 5;
		add(radioMujer, gbc_radioMujer);
		
		
	}
	public String getNombre() {
		return campoNombre.getText();
	}
	public String getApellido() {
		return campoApellido.getText();
	}

	public char getGenero() {
		if(radioHombre.isSelected()) {
			return 'h';
		}
		return 'm';
	}

	public String getPasaporte() {
		return campoPasaporte.getText();
	}
	public String getAsiento() {
		return (String)aientoEligido.getSelectedItem();
	}	
}
