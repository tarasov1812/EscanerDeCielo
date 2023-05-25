package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Reserva;

public class VentanaMasInfo extends JFrame{
	protected Reserva reserva;
	public VentanaMasInfo(Reserva reserva) {
		this.reserva = reserva;
		this.setSize(600, 250);
		this.setTitle("Informacion de billete");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaMasInfo(this));
		this.setVisible(true);
	}
}
