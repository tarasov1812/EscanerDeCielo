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
	private String pais;
	
	public Aeropuerto(String nombre, String codigo, String pais) {
		super(nombre);
		this.codigo = codigo;
		this.pais = pais;
	}
	
	public Aeropuerto(String codigo) {
		super(Aeropuerto.nombreDeAerupueto(codigo));
		this.codigo = codigo;
		this.pais = Aeropuerto.nombreDePais(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return super.toString() + "codigo: " + codigo + "\nciudad: " + pais;
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
	
	public static String codigoDeAeropuerto(String nombre) {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("code");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("name", nombre);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String codigo = (String)lista.get(0);
		return codigo;
	}
	
	public static String nombreDePais(String nombre) {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("countryName");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("code", nombre);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String pais = (String)lista.get(0);
		return pais;
	}
	
	public static String nombreDeAerupueto(String codigo) {
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("name");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("code", codigo);
		ArrayList<Object> lista = null;
		try {
			lista = AeropuertoDAO.consultar("airports", columnasSelect, restricciones);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String nombre = (String)lista.get(0);
		return nombre;
	}
}
