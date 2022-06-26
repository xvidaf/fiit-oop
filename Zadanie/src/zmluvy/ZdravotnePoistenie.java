package zmluvy;

import java.io.Serializable;

import osoba.Poistenec;

/**
 * A class that represents a type of insurance
 * @author vidaf
 *
 */
public class ZdravotnePoistenie extends Zmluva implements Serializable{
	int vek;
	public ZdravotnePoistenie(Poistenec clovekPreZmluvu, double poistnaCiastka, double mesacnaPlatba, double vek)
	{
		this.poistnaCiastka = poistnaCiastka;
		this.mesacnaPlatba = mesacnaPlatba + mesacnaPlatba;
		this.vek = (int) vek;
	}
	//Zmena hodnoty zmluvy na konci mesiaca
	public void koniecMesiaca(Poistenec vlastnik)
	{
		//System.out.println("zdravotnePoistenie ");
		vlastnik.addToPeniaze(-mesacnaPlatba);
		mesacnaPlatba = mesacnaPlatba - mesacnaPlatba*0.01;
	}
	
	public String getTypPoistenia()
	{
		return "Zdravotne";
	}
}
