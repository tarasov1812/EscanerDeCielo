package clases;

public class Billete {
	private Asiento asiento;
	private boolean isDisponible;
	private short price;
	
	public Billete(Asiento asiento, boolean isDisponible, short price) {
		this.asiento = asiento;
		this.isDisponible = isDisponible;
		this.price = price;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public short getPrice() {
		return price;
	}

	public void setPrice(short price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "asiento: " + asiento + "\nisDisponible: " + isDisponible + "\nprice: " + price + "\n";
	}
	
	

	
	
}
