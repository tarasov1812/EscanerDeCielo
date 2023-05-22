package clases;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import interfaces.PantallaAreaPersonal;
import utils.DAO;

public class Reserva {
	private long codigoReserva;
	private final LocalDateTime dateTime = LocalDateTime.now();
	private Cliente cliente;
	private Vuelo vuelo;
	private List<Persona> pasajeros;

	public List<Persona> getPasajeros() {
		return pasajeros;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
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

	public Reserva(Vuelo vuelo, Cliente clitente, List<Persona> pasajeros) throws SQLException {
		this.vuelo = vuelo;
		this.setCliente(clitente);
		this.setPasajeros(pasajeros);
		this.codigoReserva = crearNumeroDeReserva();

		HashMap<String, Object> pasajero = new HashMap<String, Object>();
		for (byte i = 0; i < pasajeros.size(); i++) {
			Persona persona = pasajeros.get(i);
			if (persona instanceof Pasajero) {
				pasajero.put("nombre", pasajeros.get(i).getNombre());
				pasajero.put("apellido", pasajeros.get(i).getApellido());
				pasajero.put("genero", pasajeros.get(i).getGenero());
				pasajero.put("email", clitente.getEmail());
				pasajero.put("pasaporte", ((Pasajero) pasajeros.get(i)).getPasaporte());
				pasajero.put("numeroAsiento", ((Pasajero) pasajeros.get(i)).getNumeroAsiento());
				pasajero.put("codigoReserva", codigoReserva);
				DAO.insertar("pasajero", pasajero);
			}

		}

		HashMap<String, Object> vueloMap = new HashMap<String, Object>();
		vueloMap.put("numeroDeVuelo", vuelo.getNumeroDeVuelo());
		vueloMap.put("salida", vuelo.getSalida().getCodigo());
		vueloMap.put("destino", vuelo.getDestino().getCodigo());
		vueloMap.put("fechaSalida", vuelo.getFechaDeSalida());
		vueloMap.put("fechaLlegada", vuelo.getFechaDeLlegada());
		vueloMap.put("codigoReserva", codigoReserva);
		DAO.insertar("vuelo", vueloMap);

		HashMap<String, Object> reservaMap = new HashMap<String, Object>();
		reservaMap.put("cliente", clitente.getEmail());
		reservaMap.put("codigoReserva", codigoReserva);
		DAO.insertar("reserva", reservaMap);

	}

	public Reserva(Vuelo vuelo, List<Persona> pasajeros, long codigoDeReserva) {
		this.vuelo = vuelo;
		this.setPasajeros(pasajeros);
		this.codigoReserva = codigoDeReserva;
	}

	public static ArrayList<Reserva> buscarReservas(Cliente cliente) throws SQLException {

		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		HashMap<String, Object> resticiones = new HashMap<String, Object>();
		resticiones.put("cliente", cliente.getEmail());
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("codigoReserva");
		ArrayList<Object> numerosDeReservas = DAO.consultar("reserva", columnasSelect, resticiones);

		ArrayList<String> numerosDeReservasString = new ArrayList<>();
		for (Object obj : numerosDeReservas) {
			String str = (String) obj;
			numerosDeReservasString.add(str);
		}

		for (int i = 0; i < numerosDeReservasString.size(); i++) {
			List<Persona> pasajeros = new ArrayList<>();
			Vuelo vuelo = null;
			HashMap<String, Object> resticionesPasjeros = new HashMap<String, Object>();
			resticionesPasjeros.put("email", cliente.getEmail());
			resticionesPasjeros.put("codigoReserva", numerosDeReservasString.get(i));
			LinkedHashSet<String> columnasSelectPasajeros = new LinkedHashSet<String>();
			columnasSelectPasajeros.add("nombre");
			columnasSelectPasajeros.add("apellido");
			columnasSelectPasajeros.add("genero");
			columnasSelectPasajeros.add("pasaporte");
			columnasSelectPasajeros.add("numeroAsiento");
			ArrayList<Object> pasajerosSacados = DAO.consultar("pasajero", columnasSelectPasajeros,
					resticionesPasjeros);
			for (int j = 0; j < pasajerosSacados.size(); j = j + 5) {
				pasajeros.add(
						new Pasajero((String) "" + pasajerosSacados.get(j), (String) "" + pasajerosSacados.get(j + 1),
								((String) "" + pasajerosSacados.get(j + 2)).charAt(0),
								(String) "" + pasajerosSacados.get(j + 3), (String) "" + pasajerosSacados.get(j + 4)));
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			HashMap<String, Object> resticionesVuelo = new HashMap<String, Object>();
			resticionesVuelo.put("codigoReserva", numerosDeReservasString.get(i));
			LinkedHashSet<String> columnasSelectVuelo = new LinkedHashSet<String>();
			columnasSelectVuelo.add("numeroDeVuelo");
			columnasSelectVuelo.add("salida");
			columnasSelectVuelo.add("destino");
			columnasSelectVuelo.add("fechaSalida");
			columnasSelectVuelo.add("fechaLlegada");
			ArrayList<Object> vueloSacado = DAO.consultar("vuelo", columnasSelectVuelo, resticionesVuelo);
			for (int k = 0; k < vueloSacado.size(); k = k + 5) {
				vuelo = new Vuelo((String) vueloSacado.get(k), (String) vueloSacado.get(k + 1),
						(String) vueloSacado.get(k + 2),
						LocalDateTime.parse((String) vueloSacado.get(k + 3), formatter),
						LocalDateTime.parse((String) vueloSacado.get(k + 4), formatter));
			}
			Reserva reserva = new Reserva(vuelo, pasajeros, Long.parseLong(numerosDeReservasString.get(i)));
			reservas.add(reserva);
		}

		return reservas;
	}

	private long crearNumeroDeReserva() {

		return dateTime.getYear() * 10000000000L + dateTime.getMonth().getValue() * 100000000
				+ dateTime.getDayOfMonth() * 1000000 + dateTime.getHour() * 10000 + dateTime.getMinute() * 100
				+ dateTime.getSecond();

	}

	@Override
	public String toString() {
		return super.toString() + "codigoReserva: " + codigoReserva + "\ncliente: " + cliente + "\nvuelo: " + vuelo
				+ "\n";
	}

}
