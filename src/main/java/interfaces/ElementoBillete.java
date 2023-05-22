package interfaces;

import javax.swing.JPanel;

import clases.Reserva;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ElementoBillete extends JPanel{
	private Ventana ventana;
	private JTextField campoFehca;
	private JTextField campoCantidadPasajeros;
	private JTextField campoVuelo;
	public ElementoBillete(Ventana ventana, Reserva reserva) {
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelVuelo = new JLabel("Vuelo");
		GridBagConstraints gbc_labelVuelo = new GridBagConstraints();
		gbc_labelVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_labelVuelo.gridx = 0;
		gbc_labelVuelo.gridy = 0;
		add(labelVuelo, gbc_labelVuelo);
		
		JLabel labelFechaSalida = new JLabel("Fecha Salida");
		GridBagConstraints gbc_labelFechaSalida = new GridBagConstraints();
		gbc_labelFechaSalida.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaSalida.gridx = 1;
		gbc_labelFechaSalida.gridy = 0;
		add(labelFechaSalida, gbc_labelFechaSalida);
		
		JLabel labelPasajeros = new JLabel("Cantidad Pasajeros");
		GridBagConstraints gbc_labelPasajeros = new GridBagConstraints();
		gbc_labelPasajeros.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajeros.gridx = 2;
		gbc_labelPasajeros.gridy = 0;
		add(labelPasajeros, gbc_labelPasajeros);
		
		campoVuelo = new JTextField(reserva.getVuelo().getSalida().getPais()+"->" + reserva.getVuelo().getDestino().getPais());
		campoVuelo.setEditable(false);
		GridBagConstraints gbc_campoVuelo = new GridBagConstraints();
		gbc_campoVuelo.insets = new Insets(0, 0, 0, 5);
		gbc_campoVuelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoVuelo.gridx = 0;
		gbc_campoVuelo.gridy = 1;
		add(campoVuelo, gbc_campoVuelo);
		campoVuelo.setColumns(10);
		
		campoFehca = new JTextField(""+reserva.getVuelo().getFechaDeSalida());
		campoFehca.setEditable(false);
		GridBagConstraints gbc_campoFehca = new GridBagConstraints();
		gbc_campoFehca.insets = new Insets(0, 0, 0, 5);
		gbc_campoFehca.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoFehca.gridx = 1;
		gbc_campoFehca.gridy = 1;
		add(campoFehca, gbc_campoFehca);
		campoFehca.setColumns(10);
		
		campoCantidadPasajeros = new JTextField("" + (reserva.getPasajeros().size()+1));
		campoCantidadPasajeros.setEditable(false);
		GridBagConstraints gbc_campoCantidadPasajeros = new GridBagConstraints();
		gbc_campoCantidadPasajeros.insets = new Insets(0, 0, 0, 5);
		gbc_campoCantidadPasajeros.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCantidadPasajeros.gridx = 2;
		gbc_campoCantidadPasajeros.gridy = 1;
		add(campoCantidadPasajeros, gbc_campoCantidadPasajeros);
		campoCantidadPasajeros.setColumns(10);
		
		JButton botonMasInfo = new JButton("Mas info");
		GridBagConstraints gbc_botonMasInfo = new GridBagConstraints();
		gbc_botonMasInfo.gridx = 4;
		gbc_botonMasInfo.gridy = 1;
		add(botonMasInfo, gbc_botonMasInfo);
		
	}

}
