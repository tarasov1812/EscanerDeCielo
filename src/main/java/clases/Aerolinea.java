package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import utils.AeropuertoDAO;

public class Aerolinea extends CosaConNombre{
	private String codigo;
	private String logo;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;
	
	public Aerolinea(String nombre, String codigo, String logo, ArrayList<Vuelo> vuelos, ArrayList<Avion> aviones) {
		super(nombre);
		this.codigo = codigo;
		this.logo = logo;
		this.vuelos = vuelos;
		this.aviones = aviones;
	}
	
	public Aerolinea(String codigo, String nombre) {
		super(nombre);
		this.codigo = codigo;	
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("Name");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("IATA", codigo);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airlines", columnasSelect, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setNombre((String)lista.get(0));
		
		
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public ArrayList<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(ArrayList<Avion> aviones) {
		this.aviones = aviones;
	}
	

	@Override
	public String toString() {
		return super.toString() + "codigo: " + codigo + "\naviones: " + aviones + "\n";
	}
	
	
}
