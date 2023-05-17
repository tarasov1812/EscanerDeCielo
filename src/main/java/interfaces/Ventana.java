package interfaces;

import javax.swing.JFrame;

import clases.Cliente;
import interfaces.PantallaLogin;
import interfaces.PantallaRegistro;

public class Ventana extends JFrame{
	protected Cliente clienteLogado;
	
	public Ventana() {
		this.setSize(1200, 800);
		this.setTitle("Programa de prueba de clase");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if(clase.equals(PantallaAreaPersonal.class)) {
			this.setContentPane(new PantallaAreaPersonal(this));
		}
		if(clase.equals(PantallaBusqueda.class)) {
			this.setContentPane(new PantallaBusqueda(this));
		}
	}

}
