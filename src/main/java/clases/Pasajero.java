package clases;

public class Pasajero extends Persona{
	private String pasaporte;
	public Pasajero(String nombre, String apellido, char genero, String pasaporte) {
		super(nombre, apellido, genero);
		this.pasaporte = pasaporte;
	}
	

}
