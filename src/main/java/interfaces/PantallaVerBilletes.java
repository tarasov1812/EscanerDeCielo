package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import clases.Reserva;
import clases.Vuelo;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PantallaVerBilletes extends JPanel{
	private Ventana ventana;
	private JPanel contenedorElementos;
	public PantallaVerBilletes(Ventana ventana) {
		setBackground(new Color(179, 215, 255));
		this.ventana = ventana;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelMisBilletes = new JLabel("Mis Billetes");
		labelMisBilletes.setForeground(new Color(4, 50, 255));
		labelMisBilletes.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		labelMisBilletes.setHorizontalAlignment(SwingConstants.CENTER);
		labelMisBilletes.setHorizontalTextPosition(SwingConstants.CENTER);
		labelMisBilletes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(labelMisBilletes, BorderLayout.NORTH);
		labelMisBilletes.setPreferredSize(new Dimension(100, 100));
		labelMisBilletes.setMinimumSize(new Dimension(100, 100));
		labelMisBilletes.setMaximumSize(new Dimension(100, 100));
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		
		ArrayList<Reserva> reservas = null;
		try {
			reservas = Reserva.buscarReservas(ventana.clienteLogado);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < reservas.size(); i++) {
			contenedorElementos.add(new ElementoBillete(ventana, reservas.get(i)));
		}
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setForeground(new Color(4, 50, 255));
		botonAtras.setPreferredSize(new Dimension(50, 50));
		botonAtras.setMinimumSize(new Dimension(50, 50));
		botonAtras.setMaximumSize(new Dimension(50, 50));
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAreaPersonal.class);
			}
		});
		add(botonAtras, BorderLayout.SOUTH);
		
	}

}
