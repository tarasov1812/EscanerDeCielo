package clases;

public class CosaConNombre {
	private String nombre;

	public CosaConNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\n";
	}
}
