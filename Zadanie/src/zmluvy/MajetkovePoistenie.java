package zmluvy;

import osoba.Poistenec;

/**
 * A class that represents a type of insurance
 * @author vidaf
 *
 */
public class MajetkovePoistenie extends Zmluva{
	private double hodnotaMajetku;
	public MajetkovePoistenie(Poistenec clovekPreZmluvu, double poistnaCiastka, double mesacnaPlatba, double hodnotamajetku)
	{
		this.poistnaCiastka = poistnaCiastka;
		this.mesacnaPlatba = mesacnaPlatba;
		this.hodnotaMajetku = hodnotamajetku;
	}
	//Zmena hodnoty zmluvy na konci mesiaca
	public void koniecMesiaca(Poistenec vlastnik)
	{
		vlastnik.addToPeniaze(-mesacnaPlatba);
		hodnotaMajetku = hodnotaMajetku * 0.001;
		//System.out.println("MajetkovePoistenie");
	}
	
	public String getTypPoistenia()
	{
		return "Majetkove";
	}
}
