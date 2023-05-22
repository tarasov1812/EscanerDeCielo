package interfaces;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class PantallaAreaPersonal extends JPanel{
	private Ventana ventana;

	public PantallaAreaPersonal(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelBienvenido = new JLabel("Buenos Dias " + v.clienteLogado.getNombre());
		GridBagConstraints gbc_labelBienvenido = new GridBagConstraints();
		gbc_labelBienvenido.gridwidth = 2;
		gbc_labelBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_labelBienvenido.gridx = 1;
		gbc_labelBienvenido.gridy = 1;
		add(labelBienvenido, gbc_labelBienvenido);
		
		JButton botonBuscar = new JButton("Buscar Vuelos");
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaBusqueda.class);
			}
		});
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_botonBuscar.gridx = 1;
		gbc_botonBuscar.gridy = 2;
		add(botonBuscar, gbc_botonBuscar);
		
		JButton botonMisBilletes = new JButton("Ver mis Billetes");
		botonMisBilletes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaVerBilletes.class);
			}
		});
		GridBagConstraints gbc_botonMisBilletes = new GridBagConstraints();
		gbc_botonMisBilletes.insets = new Insets(0, 0, 5, 5);
		gbc_botonMisBilletes.gridx = 2;
		gbc_botonMisBilletes.gridy = 2;
		add(botonMisBilletes, gbc_botonMisBilletes);
	}
}
