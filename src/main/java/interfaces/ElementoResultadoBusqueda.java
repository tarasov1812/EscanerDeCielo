package interfaces;

import javax.swing.JPanel;

import clases.Billete;
import clases.Cliente;
import clases.Vuelo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ElementoResultadoBusqueda extends JPanel{
	Ventana ventana;
	Vuelo vuelo;
	
	public ElementoResultadoBusqueda(Ventana ventana, Vuelo vuelo) {
		Duration duration = Duration.between(vuelo.getFechaDeSalida(), vuelo.getFechaDeLlegada());       		
		long hours = duration.toHours();
		long minutes = duration.toMinutes() % 60;
		String durationString = String.format("%d h %d m", hours, minutes);
		
		short masBarato = 24000;
		HashMap<String, Billete> billetes = vuelo.getBilletes();
		Iterator itm = billetes.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			Billete billete = (Billete) actual.getValue();
			if(masBarato > billete.getPrice()) {
				masBarato = billete.getPrice();
			}
			
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelHora = new JLabel(vuelo.getFechaDeSalida().toLocalDate().toString() + " " + vuelo.getFechaDeSalida().toLocalTime().toString());
		GridBagConstraints gbc_labelHora = new GridBagConstraints();
		gbc_labelHora.anchor = GridBagConstraints.WEST;
		gbc_labelHora.insets = new Insets(0, 0, 0, 5);
		gbc_labelHora.gridx = 0;
		gbc_labelHora.gridy = 0;
		add(labelHora, gbc_labelHora);
		
		JLabel labelPrecio = new JLabel(masBarato + " €");
		GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
		gbc_labelPrecio.anchor = GridBagConstraints.WEST;
		gbc_labelPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_labelPrecio.gridx = 1;
		gbc_labelPrecio.gridy = 0;
		add(labelPrecio, gbc_labelPrecio);
		
		JLabel labelDuracion = new JLabel(durationString);
		GridBagConstraints gbc_labelDuracion = new GridBagConstraints();
		gbc_labelDuracion.anchor = GridBagConstraints.WEST;
		gbc_labelDuracion.insets = new Insets(0, 0, 0, 5);
		gbc_labelDuracion.gridx = 2;
		gbc_labelDuracion.gridy = 0;
		add(labelDuracion, gbc_labelDuracion);
		
		JLabel labelTransbordos = new JLabel("" + vuelo.getNumeroDeTransbordos());
		GridBagConstraints gbc_labelTransbordos = new GridBagConstraints();
		gbc_labelTransbordos.anchor = GridBagConstraints.WEST;
		gbc_labelTransbordos.insets = new Insets(0, 0, 0, 5);
		gbc_labelTransbordos.gridx = 3;
		gbc_labelTransbordos.gridy = 0;
		add(labelTransbordos, gbc_labelTransbordos);
		
		JLabel labelAerolinea = new JLabel(vuelo.getAerolinea().getNombre());
		GridBagConstraints gbc_labelAerolinea = new GridBagConstraints();
		gbc_labelAerolinea.anchor = GridBagConstraints.WEST;
		gbc_labelAerolinea.insets = new Insets(0, 0, 0, 5);
		gbc_labelAerolinea.gridx = 4;
		gbc_labelAerolinea.gridy = 0;
		add(labelAerolinea, gbc_labelAerolinea);
		
		JButton botonVerAsientos = new JButton("Ver Asientos");
		botonVerAsientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaElijirAsiento2(ventana.clienteLogado, vuelo, ventana);
			}
		});
		GridBagConstraints gbc_botonVerAsientos = new GridBagConstraints();
		gbc_botonVerAsientos.anchor = GridBagConstraints.WEST;
		gbc_botonVerAsientos.gridx = 5;
		gbc_botonVerAsientos.gridy = 0;
		add(botonVerAsientos, gbc_botonVerAsientos);
		
		
	}
}
