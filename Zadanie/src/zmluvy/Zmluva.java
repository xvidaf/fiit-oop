package zmluvy;

import java.io.Serializable;

import osoba.*;

/**
 * An  abstract class that represents insurance types
 * @author vidaf
 *
 */
public abstract class Zmluva implements Serializable{
	protected double poistnaCiastka;
	protected double mesacnaPlatba;
	protected boolean mesiacZaplateny;
	/**	Changes the parameters of Insurance at end of month
	 * @param Vlastnik
	 */
	public abstract void koniecMesiaca(Poistenec Vlastnik);
	
	public double getPoistnaCiastka() {
		return poistnaCiastka;
	}

	public double getMesacnaPlatba() {
		return mesacnaPlatba;
	}

	public boolean isMesiacZaplateny() {
		return mesiacZaplateny;
	}

	public void setMesiacZaplateny(boolean mesiacZaplateny) {
		this.mesiacZaplateny = mesiacZaplateny;
	}
	
	/**	Returns a string containing the name of the Insurance type
	 * @return
	 */
	public abstract String getTypPoistenia();
	
}
