package clases;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
	private long codigoReserva;
	private Cliente cliente;
	private List<Vuelo> vuelos;
	private List<Persona> pasajeros;
	
	
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	public List<Persona> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(List<Persona> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public long getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Reserva(List<Vuelo> vuelos, Cliente clitente, List<Persona> pasajeros) {
        this.vuelos = vuelos;
        this.setCliente(clitente);
        this.setPasajeros(pasajeros);
    }
	
	@Override
	public String toString() {
		return super.toString() + "codigoReserva: " + codigoReserva + "\ncliente=" + cliente + "\n";
	}
	
}
