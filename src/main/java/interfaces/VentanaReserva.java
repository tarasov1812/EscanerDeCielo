package interfaces;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Vuelo;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaReserva extends JFrame{
	private Ventana ventana;
	private Vuelo vuelo;
	private short cantidatReservas;
	private ArrayList<String> asientosElijidos;
	
	public VentanaReserva(Ventana ventana, Vuelo vuelo, short cantidatReservas,  ArrayList<String> asientosElijidos) {
		
		setTitle("Reservar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel labelCantidad = new JLabel("Cantidad de billetes: " + cantidatReservas);
		GridBagConstraints gbc_labelCantidad = new GridBagConstraints();
		gbc_labelCantidad.insets = new Insets(0, 0, 5, 0);
		gbc_labelCantidad.gridx = 1;
		gbc_labelCantidad.gridy = 1;
		getContentPane().add(labelCantidad, gbc_labelCantidad);
		
		String lista = "";
		for(short i = 0; i<asientosElijidos.size(); i++) {
			lista += asientosElijidos.get(i) + ",";
		}
		JLabel labelAsientos = new JLabel("Asientos " + lista);
		GridBagConstraints gbc_labelAsientos = new GridBagConstraints();
		gbc_labelAsientos.insets = new Insets(0, 0, 5, 0);
		gbc_labelAsientos.gridx = 1;
		gbc_labelAsientos.gridy = 2;
		getContentPane().add(labelAsientos, gbc_labelAsientos);
		
		JLabel labelVuelo = new JLabel(vuelo.getDestino().toString());
		GridBagConstraints gbc_labelVuelo = new GridBagConstraints();
		gbc_labelVuelo.gridx = 1;
		gbc_labelVuelo.gridy = 3;
		getContentPane().add(labelVuelo, gbc_labelVuelo);
		JPanel planePanel = new JPanel(new GridBagLayout());
		
		getContentPane().add(planePanel);
		setMinimumSize(new Dimension(500, getHeight()));	
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
