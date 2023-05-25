package clases;

public class Persona extends CosaConNombre{
	private String apellido;
	private char genero;
	
	public Persona(String nombre, String apellido, char genero) {
		super(nombre);
		this.apellido = apellido;
		this.genero = genero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return super.toString() + "Apellido: " + apellido + "\nGenero: " + genero + "\n";
	}
	
}
