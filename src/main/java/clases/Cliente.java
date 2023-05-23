package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaExcepcion;
import utils.DAO;

public class Cliente extends Persona{
	private String email;
	private String contrasena;
	private Billete billete;
	
	public Cliente(String nombre, String apellido, char genero, String email, String contrasena) throws SQLException {
		super(nombre, apellido, genero);
		this.email = email;
		this.contrasena = contrasena;
		
		HashMap<String,Object> cols=new HashMap<String,Object>();
		
		cols.put("nombre",nombre);
		cols.put("apellido", apellido);
		cols.put("genero", genero);
		cols.put("email", email);
		cols.put("contrasena", contrasena);
		DAO.insertar("cliente", cols);
	}
	
	public Cliente(String email,String contrasena) throws SQLException, ClienteNoExisteException, ContraseñaInvalidaExcepcion {
		super("X", "X", 'x');
		LinkedHashSet<String> columnasSacar = new LinkedHashSet<String>();
		columnasSacar.add("nombre");
		columnasSacar.add("apellido");
		columnasSacar.add("genero");
		columnasSacar.add("email");
		columnasSacar.add("contrasena");
		HashMap<String, Object> rescticcionesComEmail = new HashMap<String, Object>();
		rescticcionesComEmail.put("email", email);
		ArrayList<Object> datosSacados = DAO.consultar("cliente", columnasSacar, rescticcionesComEmail);
		
		if(datosSacados.isEmpty()) {
			throw new ClienteNoExisteException("Cliente no existe");
		}
		HashMap<String, Object> rescticcionesComEmail2 = new HashMap<String, Object>();
		rescticcionesComEmail2.put("email", email);
		rescticcionesComEmail2.put("contrasena", contrasena);
		ArrayList<Object> datosSacados2 = DAO.consultar("cliente", columnasSacar, rescticcionesComEmail2);
		
		if (!contrasena.equals(datosSacados.get(4))) {
			throw new ContraseñaInvalidaExcepcion("Contraseña Invalida");
		}
		if(!datosSacados.isEmpty() && contrasena.equals(datosSacados2.get(4))) {
			this.email = email;
			this.contrasena = contrasena;
			this.setNombre((String)datosSacados2.get(0));
			this.setApellido((String)datosSacados2.get(1));
			this.setGenero(((String)datosSacados2.get(2)).charAt(0));
		}
       
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Billete getBillete() {
		return billete;
	}

	public void setBillete(Billete billete) {
		this.billete = billete;
	}

	@Override
	public String toString() {
		return super.toString() + "email: " + email + "\ncontrasena: " + contrasena;
	}
	
	
	
	
}
