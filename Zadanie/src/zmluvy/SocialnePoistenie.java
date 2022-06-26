package zmluvy;

import osoba.Poistenec;

/**
 * A class that represents a type of insurance
 * @author vidaf
 *
 */
public class SocialnePoistenie extends Zmluva{
	
	private double urok;
	public SocialnePoistenie(Poistenec clovekPreZmluvu, double poistnaCiastka, double mesacnaPlatba, double urok)
	{
		this.poistnaCiastka = poistnaCiastka;
		this.mesacnaPlatba = mesacnaPlatba;
		this.urok = urok;
	}
	//Zmena hodnoty zmluvy na konci mesiaca
	public void koniecMesiaca(Poistenec vlastnik)
	{
		vlastnik.addToPeniaze(-mesacnaPlatba);
		poistnaCiastka = poistnaCiastka*urok + poistnaCiastka + mesacnaPlatba;
		//System.out.println("SocialnePoistenie");
	}
	
	public String getTypPoistenia()
	{
		return "Socialne";
	}
}
