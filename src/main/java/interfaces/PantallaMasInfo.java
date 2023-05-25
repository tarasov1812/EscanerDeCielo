package interfaces;

import javax.swing.JPanel;

import clases.Reserva;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import clases.Pasajero;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class PantallaMasInfo extends JPanel{
	private VentanaMasInfo ventana;
	public PantallaMasInfo (VentanaMasInfo ventana) {	
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 1;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.WEST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 2;
		gbc_labelApellido.gridy = 1;
		add(labelApellido, gbc_labelApellido);
		
		JLabel labelAsiento = new JLabel("Asiento");
		GridBagConstraints gbc_labelAsiento = new GridBagConstraints();
		gbc_labelAsiento.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento.gridx = 3;
		gbc_labelAsiento.gridy = 1;
		add(labelAsiento, gbc_labelAsiento);
		
		JLabel labelPrecio = new JLabel("Precio");
		GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
		gbc_labelPrecio.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio.gridx = 4;
		gbc_labelPrecio.gridy = 1;
		add(labelPrecio, gbc_labelPrecio);
		
		JLabel labelClase = new JLabel("Clase");
		GridBagConstraints gbc_labelClase = new GridBagConstraints();
		gbc_labelClase.anchor = GridBagConstraints.WEST;
		gbc_labelClase.insets = new Insets(0, 0, 5, 5);
		gbc_labelClase.gridx = 5;
		gbc_labelClase.gridy = 1;
		add(labelClase, gbc_labelClase);
		
		JLabel labelPasajero1 = new JLabel(ventana.reserva.getPasajeros().get(0).getNombre());
		GridBagConstraints gbc_labelPasajero1 = new GridBagConstraints();
		gbc_labelPasajero1.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero1.gridx = 1;
		gbc_labelPasajero1.gridy = 2;
		add(labelPasajero1, gbc_labelPasajero1);
		
		JLabel labelApellido1 = new JLabel(ventana.reserva.getPasajeros().get(0).getApellido());
		GridBagConstraints gbc_labelApellido1 = new GridBagConstraints();
		gbc_labelApellido1.anchor = GridBagConstraints.WEST;
		gbc_labelApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido1.gridx = 2;
		gbc_labelApellido1.gridy = 2;
		add(labelApellido1, gbc_labelApellido1);
		
		JLabel labelAsiento1 = new JLabel(((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento1 = new GridBagConstraints();
		gbc_labelAsiento1.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento1.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento1.gridx = 3;
		gbc_labelAsiento1.gridy = 2;
		add(labelAsiento1, gbc_labelAsiento1);
		
		JLabel labelPrecio1 = new JLabel(""+((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio1 = new GridBagConstraints();
		gbc_labelPrecio1.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio1.gridx = 4;
		gbc_labelPrecio1.gridy = 2;
		add(labelPrecio1, gbc_labelPrecio1);
		
		JLabel lblNewLabel = new JLabel(((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel labelPasajero2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ventana.reserva.getPasajeros().get(1).getNombre());
		GridBagConstraints gbc_labelPasajero2 = new GridBagConstraints();
		gbc_labelPasajero2.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero2.gridx = 1;
		gbc_labelPasajero2.gridy = 3;
		add(labelPasajero2, gbc_labelPasajero2);
		
		JLabel labelApellido2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ventana.reserva.getPasajeros().get(1).getApellido());
		GridBagConstraints gbc_labelApellido2 = new GridBagConstraints();
		gbc_labelApellido2.anchor = GridBagConstraints.WEST;
		gbc_labelApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido2.gridx = 2;
		gbc_labelApellido2.gridy = 3;
		add(labelApellido2, gbc_labelApellido2);
		
		JLabel labelAsiento2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento2 = new GridBagConstraints();
		gbc_labelAsiento2.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento2.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento2.gridx = 3;
		gbc_labelAsiento2.gridy = 3;
		add(labelAsiento2, gbc_labelAsiento2);
		
		JLabel labelPrecio2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio2 = new GridBagConstraints();
		gbc_labelPrecio2.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio2.gridx = 4;
		gbc_labelPrecio2.gridy = 3;
		add(labelPrecio2, gbc_labelPrecio2);
		
		JLabel labelClase2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase2 = new GridBagConstraints();
		gbc_labelClase2.anchor = GridBagConstraints.WEST;
		gbc_labelClase2.insets = new Insets(0, 0, 5, 5);
		gbc_labelClase2.gridx = 5;
		gbc_labelClase2.gridy = 3;
		add(labelClase2, gbc_labelClase2);
		
		JLabel labelPasajero3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ventana.reserva.getPasajeros().get(2).getNombre());
		GridBagConstraints gbc_labelPasajero3 = new GridBagConstraints();
		gbc_labelPasajero3.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero3.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero3.gridx = 1;
		gbc_labelPasajero3.gridy = 4;
		add(labelPasajero3, gbc_labelPasajero3);
		
		JLabel labelApellido3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ventana.reserva.getPasajeros().get(2).getApellido());
		GridBagConstraints gbc_labelApellido3 = new GridBagConstraints();
		gbc_labelApellido3.anchor = GridBagConstraints.WEST;
		gbc_labelApellido3.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido3.gridx = 2;
		gbc_labelApellido3.gridy = 4;
		add(labelApellido3, gbc_labelApellido3);
		
		JLabel labelAsiento3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento3 = new GridBagConstraints();
		gbc_labelAsiento3.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento3.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento3.gridx = 3;
		gbc_labelAsiento3.gridy = 4;
		add(labelAsiento3, gbc_labelAsiento3);
		
		JLabel labelPrecio3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio3 = new GridBagConstraints();
		gbc_labelPrecio3.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio3.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio3.gridx = 4;
		gbc_labelPrecio3.gridy = 4;
		add(labelPrecio3, gbc_labelPrecio3);
		
		JLabel labelClase3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase3 = new GridBagConstraints();
		gbc_labelClase3.anchor = GridBagConstraints.WEST;
		gbc_labelClase3.insets = new Insets(0, 0, 5, 5);
		gbc_labelClase3.gridx = 5;
		gbc_labelClase3.gridy = 4;
		add(labelClase3, gbc_labelClase3);
		
		JLabel labelPasajero4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ventana.reserva.getPasajeros().get(3).getNombre());
		GridBagConstraints gbc_labelPasajero4 = new GridBagConstraints();
		gbc_labelPasajero4.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero4.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero4.gridx = 1;
		gbc_labelPasajero4.gridy = 5;
		add(labelPasajero4, gbc_labelPasajero4);
		
		JLabel labelApellido4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ventana.reserva.getPasajeros().get(3).getApellido());
		GridBagConstraints gbc_labelApellido4 = new GridBagConstraints();
		gbc_labelApellido4.anchor = GridBagConstraints.WEST;
		gbc_labelApellido4.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido4.gridx = 2;
		gbc_labelApellido4.gridy = 5;
		add(labelApellido4, gbc_labelApellido4);
		
		JLabel labelAsiento4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento4 = new GridBagConstraints();
		gbc_labelAsiento4.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento4.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento4.gridx = 3;
		gbc_labelAsiento4.gridy = 5;
		add(labelAsiento4, gbc_labelAsiento4);
		
		JLabel labelPrecio4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio4 = new GridBagConstraints();
		gbc_labelPrecio4.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio4.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio4.gridx = 4;
		gbc_labelPrecio4.gridy = 5;
		add(labelPrecio4, gbc_labelPrecio4);
		
		JLabel labelClase4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase4 = new GridBagConstraints();
		gbc_labelClase4.anchor = GridBagConstraints.WEST;
		gbc_labelClase4.insets = new Insets(0, 0, 5, 5);
		gbc_labelClase4.gridx = 5;
		gbc_labelClase4.gridy = 5;
		add(labelClase4, gbc_labelClase4);
		
		JButton botonImprimir = new JButton("Imprimir");
		botonImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try (FileWriter fw = new FileWriter("./billete.log", true)) {
					String mensaje = "Pasajeros: \n" 
							+ ventana.reserva.getPasajeros().toString() + " van a viajar a " + ventana.reserva.getVuelo().getDestino().getNombre();
					fw.write(mensaje);
					fw.flush();
					fw.close();
					JOptionPane.showMessageDialog(ventana, "Impreso con éxito", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e2) {
					System.err.println(e2);
				}
			}
		});
		
		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.dispose();
			}
		});
		GridBagConstraints gbc_botonCerrar = new GridBagConstraints();
		gbc_botonCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCerrar.gridx = 4;
		gbc_botonCerrar.gridy = 8;
		add(botonCerrar, gbc_botonCerrar);
		GridBagConstraints gbc_botonImprimir = new GridBagConstraints();
		gbc_botonImprimir.anchor = GridBagConstraints.WEST;
		gbc_botonImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_botonImprimir.gridx = 5;
		gbc_botonImprimir.gridy = 8;
		add(botonImprimir, gbc_botonImprimir);
	}
}
