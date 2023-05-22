package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import clases.Billete;

public class PantallaAsiento extends JPanel{	
	private VentanaElijirAsiento2 ventanaElijir;
	private JButton[][] asientosParaMostar;
	ArrayList<JButton> asientosElijidos = new ArrayList<JButton>();

	public PantallaAsiento(VentanaElijirAsiento2 v) {
		this.ventanaElijir = v;
		ventanaElijir.listaAsientos = new ArrayList<String>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		HashMap<String, Billete> billetes = ventanaElijir.vuelo.getBilletes();
		

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
				boolean isPrimeraClase = false;
				boolean isEmergencia = false;
        		Iterator itm = billetes.entrySet().iterator();
        		while (itm.hasNext()) {
        			Entry actual = (Entry) itm.next();
        			Billete billete = (Billete) actual.getValue();
        			
        			if(billete.getAsiento().getCodigo().equals(i+letters[y])) {
        				numero = billete.getAsiento().getCodigo();
        				precio = "" + billete.getPrice() + " €";
        				isDisponible = billete.isDisponible();
        				isPrimeraClase = billete.getAsiento().isPrimeraClase();
        				isEmergencia = billete.getAsiento().isSalidaDeEmergencia();
        			}     			
        		}
        		
				gbc.gridx++;
				JButton button = new JButton(numero+"\n");
				button.setEnabled(isDisponible);
				if (isDisponible) {
				    button.setToolTipText(precio);
				}
				if (isPrimeraClase) {
				    button.setForeground(Color.BLUE);
				} else if(isEmergencia){
					button.setForeground(Color.ORANGE);
				} else {
					button.setForeground(Color.GREEN);
				}
				
				button.setPreferredSize(new Dimension(20, 100));
				add(button, gbc);
				asientosParaMostar[i - 1][y] = button;
				if (y == 2) {
					gbc.gridx++;
					gbc.weightx = 1.0;
					add(Box.createVerticalGlue(), gbc);
					gbc.weightx = 0.0;
				}
				
				button.addActionListener(e -> {
					if (ventanaElijir.cantidadAsientoElijidos < 4) {
						button.setSelected(!button.isSelected());
						if (button.isSelected()) {
							ventanaElijir.cantidadAsientoElijidos++;
						} else {
							ventanaElijir.cantidadAsientoElijidos--;
						}
					} else if (button.isSelected()) {
						button.setSelected(false);
						ventanaElijir.cantidadAsientoElijidos--;
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
				ventanaElijir.listaAsientos.add(asiento.getText());
			}
			System.out.println(ventanaElijir.cantidadAsientoElijidos);
		});
		botonReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ventanaElijir.cantidadAsientoElijidos>0) {
					asientosElijidos = null;
					v.cambiarAPantalla(PantallaReserva.class);
				}
			}
		});
		buttonPanel.add(botonReservar);
		
		

		gbc.gridx = 0;
		gbc.gridy = numRows + 1;
		gbc.gridwidth = 8;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(buttonPanel, gbc);
		v.setContentPane(this);
		v.pack();
	}

}
