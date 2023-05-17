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

public class PantallaBusqueda extends JPanel {
	private JDateChooser departureDateChooser;
	private JButton btnNewButton;
	private Ventana ventana;
	private JPanel contenedorElementos;

	public PantallaBusqueda(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelAdonde = new JLabel("New label");
		GridBagConstraints gbc_labelAdonde = new GridBagConstraints();
		gbc_labelAdonde.insets = new Insets(0, 0, 5, 5);
		gbc_labelAdonde.gridx = 1;
		gbc_labelAdonde.gridy = 1;
		add(labelAdonde, gbc_labelAdonde);

		JLabel labelDate = new JLabel("Date");
		GridBagConstraints gbc_labelDate = new GridBagConstraints();
		gbc_labelDate.insets = new Insets(0, 0, 5, 5);
		gbc_labelDate.gridx = 1;
		gbc_labelDate.gridy = 3;
		add(labelDate, gbc_labelDate);

		departureDateChooser = new JDateChooser();
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

		JLabel labelPais = new JLabel("Pais");
		GridBagConstraints gbc_labelPais = new GridBagConstraints();
		gbc_labelPais.anchor = GridBagConstraints.EAST;
		gbc_labelPais.insets = new Insets(0, 0, 5, 5);
		gbc_labelPais.gridx = 3;
		gbc_labelPais.gridy = 3;
		add(labelPais, gbc_labelPais);

		JComboBox comboBoxCiudad = new JComboBox();
		GridBagConstraints gbc_comboBoxCiudad = new GridBagConstraints();
		gbc_comboBoxCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCiudad.gridx = 6;
		gbc_comboBoxCiudad.gridy = 3;
		add(comboBoxCiudad, gbc_comboBoxCiudad);

		JComboBox comboBoxPais = new JComboBox();
		String[] paises = Aeropuerto.listaDePaises();
		comboBoxPais.setModel(new DefaultComboBoxModel(paises));

		String selectedValue = "Spain";
		comboBoxPais.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Получаем текущее выбранное значение из JComboBox
				String selectedValue = comboBoxPais.getSelectedItem().toString();
				System.out.println("Выбранное значение: " + selectedValue);
				comboBoxCiudad.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades(selectedValue)));
			}
		});
		GridBagConstraints gbc_comboBoxPais = new GridBagConstraints();
		gbc_comboBoxPais.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPais.gridx = 4;
		gbc_comboBoxPais.gridy = 3;
		add(comboBoxPais, gbc_comboBoxPais);

		JLabel labelCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_labelCiudad = new GridBagConstraints();
		gbc_labelCiudad.anchor = GridBagConstraints.EAST;
		gbc_labelCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad.gridx = 5;
		gbc_labelCiudad.gridy = 3;
		add(labelCiudad, gbc_labelCiudad);

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

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aeropuerto salida = new Aeropuerto("Malaga", "AGP", "Malaga");
				Aeropuerto destino = new Aeropuerto(comboBoxCiudad.getSelectedItem().toString(),
						Aeropuerto.codigoDeAeropuerto(comboBoxCiudad.getSelectedItem().toString()),
						comboBoxCiudad.getSelectedItem().toString());

				Date departureDate = departureDateChooser.getDate();

				// создаем новую модель данных для таблицы с полученными данными о рейсах
				ArrayList<Vuelo> vuelos = Vuelo.buscarVuelo(salida, destino, departureDate);
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

//		String[] columnNames = {"Hora de Salida", "Precio", "Duracion", "Transbordos", "Aerolinea"};
//	    Object[][] data = {{"10:00", "100$", "2 horas", "sin tranbordo", "Turkish Airline"}
//	                       };

//	    final JTable table = new JTable(data, columnNames);

//        comboBoxPais = new JComboBox();
//        String[] paises = Aeropuerto.listaDePaises();
//        comboBoxPais.setModel(new DefaultComboBoxModel(paises));
//        add(comboBoxPais);
//        
//        String selectedValue = "Spain";
//        comboBoxPais.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Получаем текущее выбранное значение из JComboBox
//                String selectedValue = comboBoxPais.getSelectedItem().toString();
//                System.out.println("Выбранное значение: " + selectedValue);
//                comboBoxCuidad.setModel(new DefaultComboBoxModel(Aeropuerto.listaDeCiudades(selectedValue)));
//            }
//        });

//        btnNewButton = new JButton("Buscar");
//        btnNewButton.addMouseListener(new MouseAdapter() {
//        	@Override
//        	public void mouseClicked(MouseEvent e) {
//        		Aeropuerto salida = new Aeropuerto("Malaga", "AGP", "Malaga");
//        		Aeropuerto destino = new Aeropuerto(comboBoxCuidad.getSelectedItem().toString(), Aeropuerto.codigoDeAeropuerto(comboBoxCuidad.getSelectedItem().toString()), comboBoxCuidad.getSelectedItem().toString());
//        		
//        		Date departureDate = departureDateChooser.getDate();
//        		
//                // создаем новую модель данных для таблицы с полученными данными о рейсах
//        		ArrayList<Vuelo> vuelos = Vuelo.buscarVuelo(salida, destino, departureDate);
//				for(int i = 0, i< vuelos.size(); i++) {
//        			new ElementoResulta (vuelos.get(i));
//				}
////        		
//        		
//                DefaultTableModel model = new DefaultTableModel(data, columnNames);
//                
////                 обновляем модель данных таблицы
//                table.setModel(model);
//                JButton botonComparar = new JButton("Comprar");
//                botonComparar.addMouseListener(new MouseAdapter() {
//                	@Override
//                	public void mouseClicked(MouseEvent e) {
//                		new SeatSelectionGUI(vuelo);
//                	}
//                });
//                add(botonComparar);
//        	}
//        });
//        add(btnNewButton);

	}

}
