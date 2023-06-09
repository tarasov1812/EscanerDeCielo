package interfaces;

import javax.swing.JPanel;

import clases.Cliente;
import clases.Pasajero;
import clases.Persona;
import clases.Reserva;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementoBillete extends JPanel {
	private Ventana ventana;
	private JTextField campoFehca;
	private JTextField campoCantidadPasajeros;
	private JTextField campoVuelo;
	private JTextField campoPrecio;
	private JTextField campoHoraSalida;

	public ElementoBillete(Ventana ventana, Reserva reserva) {
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
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
		
		JLabel labelHoraSalida = new JLabel("Hora Salida");
		GridBagConstraints gbc_labelHoraSalida = new GridBagConstraints();
		gbc_labelHoraSalida.insets = new Insets(0, 0, 5, 5);
		gbc_labelHoraSalida.gridx = 2;
		gbc_labelHoraSalida.gridy = 0;
		add(labelHoraSalida, gbc_labelHoraSalida);

		JLabel labelPasajeros = new JLabel("Cantidad Pasajeros");
		GridBagConstraints gbc_labelPasajeros = new GridBagConstraints();
		gbc_labelPasajeros.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajeros.gridx = 3;
		gbc_labelPasajeros.gridy = 0;
		add(labelPasajeros, gbc_labelPasajeros);

		JLabel lavelPrecioTotal = new JLabel("Precio Total");
		GridBagConstraints gbc_lavelPrecioTotal = new GridBagConstraints();
		gbc_lavelPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lavelPrecioTotal.gridx = 4;
		gbc_lavelPrecioTotal.gridy = 0;
		add(lavelPrecioTotal, gbc_lavelPrecioTotal);

		campoVuelo = new JTextField(
				reserva.getVuelo().getSalida().getPais() + "->" + reserva.getVuelo().getDestino().getPais());
		labelVuelo.setLabelFor(campoVuelo);
		campoVuelo.setEditable(false);
		GridBagConstraints gbc_campoVuelo = new GridBagConstraints();
		gbc_campoVuelo.insets = new Insets(0, 0, 0, 5);
		gbc_campoVuelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoVuelo.gridx = 0;
		gbc_campoVuelo.gridy = 1;
		add(campoVuelo, gbc_campoVuelo);
		campoVuelo.setColumns(10);

		campoFehca = new JTextField("" + reserva.getVuelo().getFechaDeSalida().toLocalDate());
		labelFechaSalida.setLabelFor(campoFehca);
		campoFehca.setEditable(false);
		GridBagConstraints gbc_campoFehca = new GridBagConstraints();
		gbc_campoFehca.insets = new Insets(0, 0, 0, 5);
		gbc_campoFehca.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoFehca.gridx = 1;
		gbc_campoFehca.gridy = 1;
		add(campoFehca, gbc_campoFehca);
		campoFehca.setColumns(10);
		
		campoHoraSalida = new JTextField("" + reserva.getVuelo().getFechaDeSalida().toLocalTime());
		labelHoraSalida.setLabelFor(campoHoraSalida);
		campoHoraSalida.setEditable(false);
		GridBagConstraints gbc_campoHoraSalida = new GridBagConstraints();
		gbc_campoHoraSalida.insets = new Insets(0, 0, 0, 5);
		gbc_campoHoraSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoHoraSalida.gridx = 2;
		gbc_campoHoraSalida.gridy = 1;
		add(campoHoraSalida, gbc_campoHoraSalida);
		campoHoraSalida.setColumns(10);

		campoCantidadPasajeros = new JTextField("" + (reserva.getPasajeros().size()));
		labelPasajeros.setLabelFor(campoCantidadPasajeros);
		campoCantidadPasajeros.setEditable(false);
		GridBagConstraints gbc_campoCantidadPasajeros = new GridBagConstraints();
		gbc_campoCantidadPasajeros.insets = new Insets(0, 0, 0, 5);
		gbc_campoCantidadPasajeros.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCantidadPasajeros.gridx = 3;
		gbc_campoCantidadPasajeros.gridy = 1;
		add(campoCantidadPasajeros, gbc_campoCantidadPasajeros);
		campoCantidadPasajeros.setColumns(10);

		List<Persona> pasajeros = reserva.getPasajeros();
		short precioTotal = 0;
		for (byte i = 0; i < pasajeros.size(); i++) {
			precioTotal += ((Pasajero) pasajeros.get(i)).getBillete().getPrice();

		}
		campoPrecio = new JTextField("" + precioTotal + " €");
		lavelPrecioTotal.setLabelFor(campoPrecio);
		campoPrecio.setEditable(false);
		GridBagConstraints gbc_campoPrecio = new GridBagConstraints();
		gbc_campoPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_campoPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPrecio.gridx = 4;
		gbc_campoPrecio.gridy = 1;
		add(campoPrecio, gbc_campoPrecio);
		campoPrecio.setColumns(10);

		JButton botonMasInfo = new JButton("Mas info");
		botonMasInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaMasInfo(reserva);
			}
		});
		GridBagConstraints gbc_botonMasInfo = new GridBagConstraints();
		gbc_botonMasInfo.gridx = 5;
		gbc_botonMasInfo.gridy = 1;
		add(botonMasInfo, gbc_botonMasInfo);

	}

}
