package clases;

public class Asiento {
	private String codigo;
	private boolean salidaDeEmergencia;
	private boolean primeraClase;
	
	public Asiento(String codigo, boolean salidaDeEmergencia, boolean primeraClase) {
		this.codigo = codigo;
		this.salidaDeEmergencia = salidaDeEmergencia;
		this.primeraClase = primeraClase;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isSalidaDeEmergencia() {
		return salidaDeEmergencia;
	}
	public void setSalidaDeEmergencia(boolean salidaDeEmergencia) {
		this.salidaDeEmergencia = salidaDeEmergencia;
	}
	public boolean isPrimeraClase() {
		return primeraClase;
	}
	public void setPrimeraClase(boolean primeraClase) {
		this.primeraClase = primeraClase;
	}
	
	@Override
	public String toString() {
		return "codigo=" + codigo + "\nsalidaDeEmergencia: " + salidaDeEmergencia + "\nprimeraClase="
				+ primeraClase + "\n";
	}
	
}
