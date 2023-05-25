package clases;

public class Pasajero extends Persona{
	private String pasaporte;
	private Billete billete;
	public Pasajero(String nombre, String apellido, char genero, String pasaporte, Billete billete) {
		super(nombre, apellido, genero);
		this.pasaporte = pasaporte;
		this.billete = billete;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	public Billete getBillete() {
		return billete;
	}
	public void setBillete(Billete billete) {
		this.billete = billete;
	}
	@Override
	public String toString() {
		return super.toString() + billete + "\n";
	}	
}
