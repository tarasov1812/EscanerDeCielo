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

public class PantallaVerBilletes extends JPanel{
	private Ventana ventana;
	private JPanel contenedorElementos;
	public PantallaVerBilletes(Ventana ventana) {
		this.ventana = ventana;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelMisBilletes = new JLabel("Mis Billetes");
		add(labelMisBilletes, BorderLayout.NORTH);
		
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
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAreaPersonal.class);
			}
		});
		add(botonAtras, BorderLayout.SOUTH);
		
	}

}
