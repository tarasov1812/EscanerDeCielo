package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import utils.AeropuertoDAO;

public class Aeropuerto extends CosaConNombre{
	private String codigo;
	private String ciudad;
	
	public Aeropuerto(String nombre, String codigo, String ciudad) {
		super(nombre);
		this.codigo = codigo;
		this.ciudad = ciudad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return super.toString() + "codigo: " + codigo + "\nciudad: " + ciudad;
	}
	
	public static String[] listaDePaises() {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("countryName");
		HashMap<String, Object> restricciones = null;
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<String> set = new HashSet<String>();
		for(short i=0;i<lista.size();i++) {
			set.add((String)lista.get(i));
		}
		String[] paises = set.toArray(new String[0]);
		Arrays.sort(paises);
		return paises;
	}
	
	public static String[] listaDeCiudades(String pais) {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("name");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("countryName", pais);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<String> set = new HashSet<String>();
		for(short i=0;i<lista.size();i++) {
			set.add((String)lista.get(i));
		}
		String[] ciudades = set.toArray(new String[0]);
		Arrays.sort(ciudades);
		return ciudades;
	}
	
	public static String codigoDeAeropuerto(String ciudad) {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("code");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("name", ciudad);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String codigo = (String)lista.get(0);
		return codigo;
	}
}
