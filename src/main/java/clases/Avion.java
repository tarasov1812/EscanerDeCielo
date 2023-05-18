package clases;

import java.awt.Dimension;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.JButton;

public class Avion extends CosaConNombre {
	private TreeMap<String, Asiento> asientos;
	private String codigo;

	public Avion(String nombre, TreeMap<String, Asiento> asientos, String codigo) {
		super(nombre);
		this.asientos = asientos;
		this.codigo = codigo;
	}

	public TreeMap<String, Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(TreeMap<String, Asiento> asientos) {
		this.asientos = asientos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return super.toString() + "codigo=" + codigo + "\nasientos=" + asientos + "\n";
	}

	public static TreeMap<String, Asiento> generarAsientos() {
		TreeMap<String, Asiento> asientos = new TreeMap<String, Asiento>();
		String[] letters = { "A", "B", "C", "D", "E", "F" };
		int numRows = 26;
		for (int i = 1; i <= numRows; i++) {
			for (int y = 0; y < letters.length; y++) {
				if (i > 0 && i < 4) {
					asientos.put(i + letters[y], new Asiento(i + letters[y], false, true));
				} else if (i == 14 && y == 0 || i == 14 && y == 5) {
					asientos.put(i + letters[y], new Asiento(i + letters[y], true, false));
				} else {
					asientos.put(i + letters[y], new Asiento(i + letters[y], false, false));
				}
			}
		}
		return asientos;
	}
}
