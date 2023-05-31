package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import utils.AeropuertoDAO;

public class Aerolinea extends CosaConNombre {
	private String codigo;

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
			e.printStackTrace();
		}
		if (!lista.isEmpty()) {
			this.setNombre((String) lista.get(0));
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return super.toString() + "codigo: " + codigo;
	}

}
