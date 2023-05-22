package interfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import clases.Cliente;
import clases.Vuelo;

public class VentanaElijirAsiento2 extends JFrame{
	protected Cliente clienteLogado;
	protected Vuelo vuelo;
	protected short cantidadAsientoElijidos;
	protected ArrayList<String> listaAsientos;
	
	
	public VentanaElijirAsiento2(Cliente clienteLogado, Vuelo vuelo) {
		this.clienteLogado = clienteLogado;
		this.vuelo = vuelo;
		this.setMinimumSize(new Dimension(500, getHeight()));
		this.setTitle("Reservar");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaAsiento(this));
		this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaAsiento.class)) {
			this.setContentPane(new PantallaAsiento(this));
		}
		if(clase.equals(PantallaReserva.class)) {
			this.setContentPane(new PantallaReserva(this));
		}
	}
}
