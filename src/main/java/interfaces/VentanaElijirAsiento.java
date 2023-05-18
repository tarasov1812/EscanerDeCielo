package interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clases.Billete;
import clases.Vuelo;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaElijirAsiento extends JFrame {

	private JButton[][] asientosParaMostar;
	private short cantidadAsientoElijidos;
	ArrayList<JButton> asientosElijidos = new ArrayList<JButton>();
	ArrayList<String> asientosEl = new ArrayList<String>();

	public VentanaElijirAsiento(Vuelo vuelo, Ventana ventana) {

		setTitle("Elije hasta 4 asientos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		HashMap<String, Billete> billetes = vuelo.getBilletes();
		
		JPanel planePanel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;

		String[] letters = { "A", "B", "C", "D", "E", "F" };
		int numRows = 26;
		asientosParaMostar = new JButton[numRows][letters.length]; 
		
		for (int i = 1; i <= numRows; i++) {
			gbc.gridy++;
			gbc.gridx = 1;
			for (int y = 0; y < letters.length; y++) {
				String precio = "1";
				String numero = "2";
				boolean isDisponible = true;
        		Iterator itm = billetes.entrySet().iterator();
        		while (itm.hasNext()) {
        			Entry actual = (Entry) itm.next();
        			Billete billete = (Billete) actual.getValue();
        			
        			if(billete.getAsiento().getCodigo().equals(i+letters[y])) {
        				numero = billete.getAsiento().getCodigo();
        				precio = "" + billete.getPrice() + " €";
        				isDisponible = billete.isDisponible();
        			}     			
        		}
        		
				gbc.gridx++;
				JButton button = new JButton(numero+"\n");
				button.setEnabled(isDisponible);
				if (isDisponible) {
				    button.setToolTipText(precio);
				}
				
				button.setPreferredSize(new Dimension(20, 100));
				planePanel.add(button, gbc);
				asientosParaMostar[i - 1][y] = button;
				if (y == 2) {
					gbc.gridx++;
					gbc.weightx = 1.0;
					planePanel.add(Box.createVerticalGlue(), gbc);
					gbc.weightx = 0.0;
				}
				
				button.addActionListener(e -> {
					if (cantidadAsientoElijidos < 4) {
						button.setSelected(!button.isSelected());
						if (button.isSelected()) {
							cantidadAsientoElijidos++;
						} else {
							cantidadAsientoElijidos--;
						}
					} else if (button.isSelected()) {
						button.setSelected(false);
						cantidadAsientoElijidos--;
					}
				});
			}
		}

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton botonReservar = new JButton("Reservar");
		botonReservar.addActionListener(e -> {
			asientosElijidos.clear();
			for (int i = 0; i < asientosParaMostar.length; i++) {
				for (int j = 0; j < asientosParaMostar[i].length; j++) {
					JButton button = asientosParaMostar[i][j];
					if (button.isSelected()) {
						asientosElijidos.add(button);
					}
				}
			}
			for (JButton asiento : asientosElijidos) {
				asientosEl.add(asiento.getText());
			}
			System.out.println(cantidadAsientoElijidos);
		});
		botonReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cantidadAsientoElijidos>0) {
					new VentanaReserva(ventana, vuelo, cantidadAsientoElijidos, asientosEl);
					dispose();
				}
			}
		});
		buttonPanel.add(botonReservar);

		gbc.gridx = 0;
		gbc.gridy = numRows + 1;
		gbc.gridwidth = 8;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		planePanel.add(buttonPanel, gbc);

		getContentPane().add(planePanel);

		setMinimumSize(new Dimension(500, getHeight()));
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
