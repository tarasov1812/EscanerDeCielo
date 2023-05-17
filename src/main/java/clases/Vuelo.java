package clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Vuelo {
	private String numeroDeVuelo;
	private Aeropuerto salida;
	private Aeropuerto destino;
	private Aerolinea aerolinea;
	private ArrayList<Cliente> pasajeros;
	private LocalDateTime fechaDeSalida;
	private LocalDateTime fechaDeLlegada;
	private HashMap<String, Billete> billetes;
	private byte numeroDeTransbordos;
	private Avion avion;
	
	public Vuelo(String numeroDeVuelo, Aeropuerto salida, Aeropuerto destino,
			LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada, Avion avion, byte numeroDeTransbordos, Aerolinea aerolinea) {
		this.numeroDeVuelo = numeroDeVuelo;
		this.salida = salida;
		this.destino = destino;
		this.fechaDeSalida = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.avion = avion;
		this.aerolinea = aerolinea;
	}
	
	

	public String getNumeroDeVuelo() {
		return numeroDeVuelo;
	}



	public void setNumeroDeVuelo(String numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}



	public Aeropuerto getSalida() {
		return salida;
	}



	public void setSalida(Aeropuerto salida) {
		this.salida = salida;
	}



	public Aeropuerto getDestino() {
		return destino;
	}



	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}



	public ArrayList<Cliente> getPasajeros() {
		return pasajeros;
	}



	public void setPasajeros(ArrayList<Cliente> pasajeros) {
		this.pasajeros = pasajeros;
	}



	public LocalDateTime getFechaDeSalida() {
		return fechaDeSalida;
	}



	public void setFechaDeSalida(LocalDateTime fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}



	public LocalDateTime getFechaDeLlegada() {
		return fechaDeLlegada;
	}



	public void setFechaDeLlegada(LocalDateTime fechaDeLlegada) {
		this.fechaDeLlegada = fechaDeLlegada;
	}



	public HashMap<String, Billete> getBilletes() {
		return billetes;
	}



	public void setBilletes(HashMap<String, Billete> billetes) {
		this.billetes = billetes;
	}
	
	
	
	public byte getNumeroDeTransbordos() {
		return numeroDeTransbordos;
	}



	public void setNumeroDeTransbordos(byte numeroDeTransbordos) {
		this.numeroDeTransbordos = numeroDeTransbordos;
	}



	public Avion getAvion() {
		return avion;
	}



	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	


	public Aerolinea getAerolinea() {
		return aerolinea;
	}



	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}



	public static ArrayList<Vuelo> buscarVuelo (Aeropuerto salida, Aeropuerto destino, Date fechaSalida) {
		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatter.format(fechaSalida);
        String result = fecha.substring(0, fecha.length() - 3);
        System.out.println(result);
        
        String url = "https://api.travelpayouts.com/aviasales/v3/prices_for_dates?origin=" + salida.getCodigo() + "&destination="+ 
        		destino.getCodigo() +"&departure_at="+ result +"&unique=false&sorting=price&direct=false&currency=eur&limit=30&page=1&one_way=true&token=6369d0da04027bf181d1e80a116953c5";
        		
        		short precio = 0;
        		String horaSalida = "";
        		short duracion = 0;
        		byte numeroDeTransbordos = 0;
        		String aerolineaCode = "";
        		String numeroDeVuelo = "";

                try {
                    URL obj = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLinea;
                    StringBuffer response = new StringBuffer();

                    while ((inputLinea = in.readLine()) != null) {
                        response.append(inputLinea);
                    }
                    in.close();
                    
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode jsonNode = objectMapper.readTree(response.toString());

                    for (JsonNode node : jsonNode.get("data")) {
                        precio = Short.parseShort(node.get("price").asText());
                        aerolineaCode = node.get("airline").asText();
                        numeroDeVuelo = node.get("flight_number").asText();
                        horaSalida = node.get("departure_at").asText();
                        numeroDeTransbordos = Byte.parseByte(node.get("transfers").asText());
                        duracion = Short.parseShort(node.get("duration_to").asText());

                        DateTimeFormatter formatterLocal = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
                        LocalDateTime salidaLocalDate = LocalDateTime.parse(horaSalida, formatterLocal);
                        LocalDateTime llegadaLocalDate = salidaLocalDate.plusMinutes(duracion);

                        Aerolinea aerolinea = new Aerolinea(aerolineaCode, "unknown");

                        Vuelo vuelo = new Vuelo(aerolineaCode + " " + numeroDeVuelo, salida, destino, salidaLocalDate, llegadaLocalDate, new Avion("Boind 737", Avion.generarAsientos(), "B737"), numeroDeTransbordos, aerolinea);
                        vuelo.setBilletes(vuelo.getBilletes(vuelo.avion, precio));
                        vuelos.add(vuelo);
                    }
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
		
		return vuelos;
	}
	
	private HashMap<String, Billete> getBilletes(Avion avion, short precio){
		HashMap<String, Billete> billetes = new HashMap<String, Billete>();
		TreeMap<String, Asiento> aseintos = avion.getAsientos();
		Iterator itm = aseintos.entrySet().iterator();
		short i = 1;
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			billetes.put(i+"", new Billete((Asiento)actual.getValue(), true, precio));
			i++;
		}
		return billetes;
	}


	@Override
	public String toString() {
		return "numeroDeVuelo: " + numeroDeVuelo + "\nsalida: " + salida + "\ndestino: " + destino + "\nfechaDeSalida: " + fechaDeSalida + "\nfechaDeLlegada: " + fechaDeLlegada + "\n";
	}
		
}
