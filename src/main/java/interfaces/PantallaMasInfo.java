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
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class PantallaMasInfo extends JPanel{
	private VentanaMasInfo ventana;
	public PantallaMasInfo (VentanaMasInfo ventana) {
		setBackground(new Color(179, 215, 255));	
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel laberDireccion = new JLabel(ventana.reserva.getVuelo().getSalida().getNombre()+"->" + ventana.reserva.getVuelo().getDestino().getNombre());
		GridBagConstraints gbc_laberDireccion = new GridBagConstraints();
		gbc_laberDireccion.anchor = GridBagConstraints.WEST;
		gbc_laberDireccion.gridwidth = 3;
		gbc_laberDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_laberDireccion.gridx = 1;
		gbc_laberDireccion.gridy = 1;
		add(laberDireccion, gbc_laberDireccion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pasajeros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panel.add(labelNombre, gbc_labelNombre);
		labelNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		labelNombre.setForeground(new Color(4, 50, 255));
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.WEST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 1;
		gbc_labelApellido.gridy = 0;
		panel.add(labelApellido, gbc_labelApellido);
		labelApellido.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		labelApellido.setForeground(new Color(4, 50, 255));
		
		JLabel labelAsiento = new JLabel("Asiento");
		GridBagConstraints gbc_labelAsiento = new GridBagConstraints();
		gbc_labelAsiento.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento.gridx = 2;
		gbc_labelAsiento.gridy = 0;
		panel.add(labelAsiento, gbc_labelAsiento);
		labelAsiento.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		labelAsiento.setForeground(new Color(4, 50, 255));
		
		JLabel labelPrecio = new JLabel("Precio");
		GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
		gbc_labelPrecio.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio.gridx = 3;
		gbc_labelPrecio.gridy = 0;
		panel.add(labelPrecio, gbc_labelPrecio);
		labelPrecio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		labelPrecio.setForeground(new Color(4, 50, 255));
		
		JLabel labelClase = new JLabel("Clase");
		GridBagConstraints gbc_labelClase = new GridBagConstraints();
		gbc_labelClase.anchor = GridBagConstraints.WEST;
		gbc_labelClase.insets = new Insets(0, 0, 5, 0);
		gbc_labelClase.gridx = 4;
		gbc_labelClase.gridy = 0;
		panel.add(labelClase, gbc_labelClase);
		labelClase.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		labelClase.setForeground(new Color(4, 50, 255));
		
		JLabel labelPasajero1 = new JLabel(ventana.reserva.getPasajeros().get(0).getNombre());
		GridBagConstraints gbc_labelPasajero1 = new GridBagConstraints();
		gbc_labelPasajero1.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero1.gridx = 0;
		gbc_labelPasajero1.gridy = 1;
		panel.add(labelPasajero1, gbc_labelPasajero1);
		
		JLabel labelApellido1 = new JLabel(ventana.reserva.getPasajeros().get(0).getApellido());
		GridBagConstraints gbc_labelApellido1 = new GridBagConstraints();
		gbc_labelApellido1.anchor = GridBagConstraints.WEST;
		gbc_labelApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido1.gridx = 1;
		gbc_labelApellido1.gridy = 1;
		panel.add(labelApellido1, gbc_labelApellido1);
		
		JLabel labelAsiento1 = new JLabel(((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento1 = new GridBagConstraints();
		gbc_labelAsiento1.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento1.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento1.gridx = 2;
		gbc_labelAsiento1.gridy = 1;
		panel.add(labelAsiento1, gbc_labelAsiento1);
		
		JLabel labelPrecio1 = new JLabel(""+((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio1 = new GridBagConstraints();
		gbc_labelPrecio1.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio1.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio1.gridx = 3;
		gbc_labelPrecio1.gridy = 1;
		panel.add(labelPrecio1, gbc_labelPrecio1);
		
		JLabel lblNewLabel = new JLabel(((Pasajero) ventana.reserva.getPasajeros().get(0)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel labelPasajero2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ventana.reserva.getPasajeros().get(1).getNombre());
		GridBagConstraints gbc_labelPasajero2 = new GridBagConstraints();
		gbc_labelPasajero2.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero2.gridx = 0;
		gbc_labelPasajero2.gridy = 2;
		panel.add(labelPasajero2, gbc_labelPasajero2);
		
		JLabel labelApellido2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ventana.reserva.getPasajeros().get(1).getApellido());
		GridBagConstraints gbc_labelApellido2 = new GridBagConstraints();
		gbc_labelApellido2.anchor = GridBagConstraints.WEST;
		gbc_labelApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido2.gridx = 1;
		gbc_labelApellido2.gridy = 2;
		panel.add(labelApellido2, gbc_labelApellido2);
		
		JLabel labelAsiento2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento2 = new GridBagConstraints();
		gbc_labelAsiento2.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento2.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento2.gridx = 2;
		gbc_labelAsiento2.gridy = 2;
		panel.add(labelAsiento2, gbc_labelAsiento2);
		
		JLabel labelPrecio2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio2 = new GridBagConstraints();
		gbc_labelPrecio2.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio2.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio2.gridx = 3;
		gbc_labelPrecio2.gridy = 2;
		panel.add(labelPrecio2, gbc_labelPrecio2);
		
		JLabel labelClase2 = new JLabel(ventana.reserva.getPasajeros().size()<2 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(1)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase2 = new GridBagConstraints();
		gbc_labelClase2.anchor = GridBagConstraints.WEST;
		gbc_labelClase2.insets = new Insets(0, 0, 5, 0);
		gbc_labelClase2.gridx = 4;
		gbc_labelClase2.gridy = 2;
		panel.add(labelClase2, gbc_labelClase2);
		
		JLabel labelPasajero3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ventana.reserva.getPasajeros().get(2).getNombre());
		GridBagConstraints gbc_labelPasajero3 = new GridBagConstraints();
		gbc_labelPasajero3.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero3.insets = new Insets(0, 0, 5, 5);
		gbc_labelPasajero3.gridx = 0;
		gbc_labelPasajero3.gridy = 3;
		panel.add(labelPasajero3, gbc_labelPasajero3);
		
		JLabel labelApellido3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ventana.reserva.getPasajeros().get(2).getApellido());
		GridBagConstraints gbc_labelApellido3 = new GridBagConstraints();
		gbc_labelApellido3.anchor = GridBagConstraints.WEST;
		gbc_labelApellido3.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido3.gridx = 1;
		gbc_labelApellido3.gridy = 3;
		panel.add(labelApellido3, gbc_labelApellido3);
		
		JLabel labelAsiento3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento3 = new GridBagConstraints();
		gbc_labelAsiento3.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento3.insets = new Insets(0, 0, 5, 5);
		gbc_labelAsiento3.gridx = 2;
		gbc_labelAsiento3.gridy = 3;
		panel.add(labelAsiento3, gbc_labelAsiento3);
		
		JLabel labelPrecio3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio3 = new GridBagConstraints();
		gbc_labelPrecio3.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio3.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio3.gridx = 3;
		gbc_labelPrecio3.gridy = 3;
		panel.add(labelPrecio3, gbc_labelPrecio3);
		
		JLabel labelClase3 = new JLabel(ventana.reserva.getPasajeros().size()<3 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(2)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase3 = new GridBagConstraints();
		gbc_labelClase3.anchor = GridBagConstraints.WEST;
		gbc_labelClase3.insets = new Insets(0, 0, 5, 0);
		gbc_labelClase3.gridx = 4;
		gbc_labelClase3.gridy = 3;
		panel.add(labelClase3, gbc_labelClase3);
		
		JLabel labelPasajero4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ventana.reserva.getPasajeros().get(3).getNombre());
		GridBagConstraints gbc_labelPasajero4 = new GridBagConstraints();
		gbc_labelPasajero4.anchor = GridBagConstraints.WEST;
		gbc_labelPasajero4.insets = new Insets(0, 0, 0, 5);
		gbc_labelPasajero4.gridx = 0;
		gbc_labelPasajero4.gridy = 4;
		panel.add(labelPasajero4, gbc_labelPasajero4);
		
		JLabel labelApellido4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ventana.reserva.getPasajeros().get(3).getApellido());
		GridBagConstraints gbc_labelApellido4 = new GridBagConstraints();
		gbc_labelApellido4.anchor = GridBagConstraints.WEST;
		gbc_labelApellido4.insets = new Insets(0, 0, 0, 5);
		gbc_labelApellido4.gridx = 1;
		gbc_labelApellido4.gridy = 4;
		panel.add(labelApellido4, gbc_labelApellido4);
		
		JLabel labelAsiento4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getAsiento().getCodigo());
		GridBagConstraints gbc_labelAsiento4 = new GridBagConstraints();
		gbc_labelAsiento4.anchor = GridBagConstraints.WEST;
		gbc_labelAsiento4.insets = new Insets(0, 0, 0, 5);
		gbc_labelAsiento4.gridx = 2;
		gbc_labelAsiento4.gridy = 4;
		panel.add(labelAsiento4, gbc_labelAsiento4);
		
		JLabel labelPrecio4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : ""+((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getPrice() + " €");
		GridBagConstraints gbc_labelPrecio4 = new GridBagConstraints();
		gbc_labelPrecio4.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio4.insets = new Insets(0, 0, 0, 5);
		gbc_labelPrecio4.gridx = 3;
		gbc_labelPrecio4.gridy = 4;
		panel.add(labelPrecio4, gbc_labelPrecio4);
		
		JLabel labelClase4 = new JLabel(ventana.reserva.getPasajeros().size()<4 ? "" : (((Pasajero) ventana.reserva.getPasajeros().get(3)).getBillete().getAsiento().isPrimeraClase() ? "Primera clase" : "Regular"));
		GridBagConstraints gbc_labelClase4 = new GridBagConstraints();
		gbc_labelClase4.anchor = GridBagConstraints.WEST;
		gbc_labelClase4.gridx = 4;
		gbc_labelClase4.gridy = 4;
		panel.add(labelClase4, gbc_labelClase4);
		
		JButton botonImprimir = new JButton("Imprimir");
		botonImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try (FileWriter fw = new FileWriter("./billete.log", true)) {
					String mensaje = "\nBillete №" + ventana.reserva.getCodigoReserva()+ "\nVuelo: " + ventana.reserva.getVuelo().getSalida().getNombre()+"->" + ventana.reserva.getVuelo().getDestino().getNombre() + "\nPasajeros: \n" 
							+ ventana.reserva.getPasajeros().toString() + "\n-------------------------\n";
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
		gbc_botonCerrar.gridx = 2;
		gbc_botonCerrar.gridy = 3;
		add(botonCerrar, gbc_botonCerrar);
		GridBagConstraints gbc_botonImprimir = new GridBagConstraints();
		gbc_botonImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_botonImprimir.anchor = GridBagConstraints.WEST;
		gbc_botonImprimir.gridx = 3;
		gbc_botonImprimir.gridy = 3;
		add(botonImprimir, gbc_botonImprimir);
	}
}
