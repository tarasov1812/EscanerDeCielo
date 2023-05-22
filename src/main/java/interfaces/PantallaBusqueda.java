package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;

import clases.Aeropuerto;
import clases.Asiento;
import clases.Billete;
import clases.Vuelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class PantallaBusqueda extends JPanel {
	private JDateChooser departureDateChooser;
	private Ventana ventana;
	private JPanel contenedorElementos;
	private String fecha;

	public PantallaBusqueda(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelBusqueda = new JLabel("Dime a donde quieres ir " + v.clienteLogado.getNombre());
		GridBagConstraints gbc_labelBusqueda = new GridBagConstraints();
		gbc_labelBusqueda.gridwidth = 7;
		gbc_labelBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_labelBusqueda.gridx = 1;
		gbc_labelBusqueda.gridy = 1;
		add(labelBusqueda, gbc_labelBusqueda);

		JLabel labelDate = new JLabel("Date");
		GridBagConstraints gbc_labelDate = new GridBagConstraints();
		gbc_labelDate.insets = new Insets(0, 0, 5, 5);
		gbc_labelDate.gridx = 1;
		gbc_labelDate.gridy = 3;
		add(labelDate, gbc_labelDate);

		departureDateChooser = new JDateChooser();
		departureDateChooser.setDate(new Date());

		departureDateChooser.getCalendarButton().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		departureDateChooser.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_departureDateChooser = new GridBagConstraints();
		gbc_departureDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_departureDateChooser.gridx = 2;
		gbc_departureDateChooser.gridy = 3;
		add(departureDateChooser, gbc_departureDateChooser);

		JLabel labelDesde = new JLabel("Desde");
		GridBagConstraints gbc_labelDesde = new GridBagConstraints();
		gbc_labelDesde.anchor = GridBagConstraints.EAST;
		gbc_labelDesde.insets = new Insets(0, 0, 5, 5);
		gbc_labelDesde.gridx = 3;
		gbc_labelDesde.gridy = 3;
		add(labelDesde, gbc_labelDesde);

		JComboBox comboBoxCiudadOrigen = new JComboBox();
		GridBagConstraints gbc_comboBoxCiudadOrigen = new GridBagConstraints();
		gbc_comboBoxCiudadOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCiudadOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCiudadOrigen.gridx = 6;
		gbc_comboBoxCiudadOrigen.gridy = 3;
		add(comboBoxCiudadOrigen, gbc_comboBoxCiudadOrigen);

		JComboBox comboBoxPaisOrigen = new JComboBox();
		String[] paises = Aeropuerto.listaDePaises();
		comboBoxPaisOrigen.setModel(new DefaultComboBoxModel(paises));
		comboBoxPaisOrigen.setSelectedItem("Spain");
		comboBoxPaisOrigen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBoxPaisOrigen.getSelectedItem().toString();
				comboBoxCiudadOrigen.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades(selectedValue)));
			}
		});
		comboBoxCiudadOrigen.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades("Spain")));
		comboBoxCiudadOrigen.setSelectedItem("Malaga");
		
		GridBagConstraints gbc_comboBoxPaisOrigen = new GridBagConstraints();
		gbc_comboBoxPaisOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPaisOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPaisOrigen.gridx = 4;
		gbc_comboBoxPaisOrigen.gridy = 3;
		add(comboBoxPaisOrigen, gbc_comboBoxPaisOrigen);

		JLabel labelCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_labelCiudad = new GridBagConstraints();
		gbc_labelCiudad.anchor = GridBagConstraints.EAST;
		gbc_labelCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad.gridx = 5;
		gbc_labelCiudad.gridy = 3;
		add(labelCiudad, gbc_labelCiudad);
		
		JCheckBox checkMes = new JCheckBox("Ver mes completo");
		GridBagConstraints gbc_checkMes = new GridBagConstraints();
		gbc_checkMes.insets = new Insets(0, 0, 5, 5);
		gbc_checkMes.gridx = 2;
		gbc_checkMes.gridy = 4;
		add(checkMes, gbc_checkMes);
		
		JLabel labelA = new JLabel("A");
		GridBagConstraints gbc_labelA = new GridBagConstraints();
		gbc_labelA.anchor = GridBagConstraints.EAST;
		gbc_labelA.insets = new Insets(0, 0, 5, 5);
		gbc_labelA.gridx = 3;
		gbc_labelA.gridy = 4;
		add(labelA, gbc_labelA);
		
		JComboBox comboBoxPaisDestion = new JComboBox();
		GridBagConstraints gbc_comboBoxPaisDestion = new GridBagConstraints();
		gbc_comboBoxPaisDestion.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPaisDestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPaisDestion.gridx = 4;
		gbc_comboBoxPaisDestion.gridy = 4;
		add(comboBoxPaisDestion, gbc_comboBoxPaisDestion);
		comboBoxPaisDestion.setModel(new DefaultComboBoxModel(paises));	
		comboBoxPaisDestion.setSelectedItem("Spain");
		
		JLabel labelCiudad_1 = new JLabel("Ciudad");
		GridBagConstraints gbc_labelCiudad_1 = new GridBagConstraints();
		gbc_labelCiudad_1.anchor = GridBagConstraints.EAST;
		gbc_labelCiudad_1.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad_1.gridx = 5;
		gbc_labelCiudad_1.gridy = 4;
		add(labelCiudad_1, gbc_labelCiudad_1);
		
		JComboBox comboBoxCiudadDestino = new JComboBox();
		GridBagConstraints gbc_comboBoxCiudadDestino = new GridBagConstraints();
		gbc_comboBoxCiudadDestino.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCiudadDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCiudadDestino.gridx = 6;
		gbc_comboBoxCiudadDestino.gridy = 4;
		add(comboBoxCiudadDestino, gbc_comboBoxCiudadDestino);
		
		comboBoxPaisDestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = comboBoxPaisDestion.getSelectedItem().toString();
				System.out.println("Selected Value es" + selectedValue);
				comboBoxCiudadDestino.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades(selectedValue)));
				
			}
		});
		comboBoxCiudadDestino.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades("Spain")));
		comboBoxCiudadDestino.setSelectedItem("Barcelona");

		JScrollPane lista = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(lista, gbc_scrollPane);

		contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		
		//Resibimos la fecha
		

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contenedorElementos.removeAll();
				contenedorElementos.revalidate();
				contenedorElementos.repaint();
				Aeropuerto salida = new Aeropuerto(comboBoxCiudadOrigen.getSelectedItem().toString(),
						Aeropuerto.codigoDeAeropuerto(comboBoxCiudadOrigen.getSelectedItem().toString()),
						comboBoxCiudadOrigen.getSelectedItem().toString());
				Aeropuerto destino = new Aeropuerto(comboBoxCiudadDestino.getSelectedItem().toString(),
						Aeropuerto.codigoDeAeropuerto(comboBoxCiudadDestino.getSelectedItem().toString()),
						comboBoxCiudadDestino.getSelectedItem().toString());
				
				Date departureDate = departureDateChooser.getDate();		
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        String fechaDia = formatter.format(departureDate);
		        String fechaMes = fechaDia.substring(0, fechaDia.length() - 3);
		        
		        if(checkMes.isSelected()) {
		        	fecha = fechaMes;
		        } else {
		        	fecha = fechaDia;
		        }


				ArrayList<Vuelo> vuelos = Vuelo.buscarVuelo(salida, destino, fecha);
				for (int i = 0; i < vuelos.size(); i++) {
					contenedorElementos.add(new ElementoResultadoBusqueda(ventana, vuelos.get(i)));
				}
				contenedorElementos.revalidate();
				contenedorElementos.repaint();

			}
		});

		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_botonBuscar.gridx = 7;
		gbc_botonBuscar.gridy = 3;
		add(botonBuscar, gbc_botonBuscar);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAreaPersonal.class);
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 1;
		gbc_botonAtras.gridy = 6;
		add(botonAtras, gbc_botonAtras);
	}

}
