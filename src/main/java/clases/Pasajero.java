package clases;

public class Pasajero extends Persona{
	private String pasaporte;
	private String numeroAsiento;
	public Pasajero(String nombre, String apellido, char genero, String pasaporte, String numeroAsiento) {
		super(nombre, apellido, genero);
		this.pasaporte = pasaporte;
		this.numeroAsiento = numeroAsiento;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	public String getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
}
