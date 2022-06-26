package osoba;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import poistovna.Zamestnanec;
import uI.UIController;
import udalost.poistnaUdalost;
import zmluvy.MajetkovePoistenie;
import zmluvy.SocialnePoistenie;
import zmluvy.ZdravotnePoistenie;

/**
 * A class which represents one type of our customer
 * @author vidaf
 *
 */
public class FyzickaOsoba extends Poistenec{
	
	private static int pocet = 0;
	
	public FyzickaOsoba(String meno, Zamestnanec observer)
	{
		this.observer = observer;
		this.jeUdalost = false;
		this.meno = meno;
		poisteny = false;
		login = meno;
		passwd = meno;
		++pocet;
		peniaze = 500;
		UIController.getInstance().addToZoznam(this);
	}
	
	public static int getPocet()
	{
		return pocet;
	}
	
	//Vrati informacie o poistencovy
	
	/**
	 * Returns information about the customer
	 *
	 */
	public String getInformacie()
	{
		if(this.poisteny)
		{
			return "Meno poistenca je " + this.meno + ",je evidovany ako fyzicka osoba, poistenec ma uzavretu zmluvu\n";
		}
		else
		{
			return "Meno poistenca je " + this.meno + ",je evidovany ako fyzicka osoba, poistenec este nema uzavretu zmluvu\n";
		}
	}
	//Nahlasi poistnu udalost, ohlasi ju observerovy
	public void nahlasPoistnuUdalost(TextArea textArea) {
		textArea.appendText("Udalost bola nahlasena\n");
		udalost = new poistnaUdalost(UzatvorenaZmluva.getPoistnaCiastka());
		jeUdalost = true;
		observer.update();
	}
	//Skontroluje a zohladni ktore poistenia su k dispozicii
	public void checkButtons(Button button1, Button button2, Button button3)
	{
		button1.setVisible(true);
		button2.setVisible(true);
		button3.setVisible(true);
	}
	//Vytvory zvolene poistenie
	public void poistit(int i, TextArea textfield)
	{
		if(i == 1)
		{
			setPoisteny(new MajetkovePoistenie(this, 400, 100,15000));
			//this.pridajDoZoznamu(clovekPreZmluvu);
			textfield.appendText("Fyzicka osoba " + getMeno() + " uzavrela majetkovu zmluvu\n");
		}
		else if(i == 2)
		{
			setPoisteny(new SocialnePoistenie(this, 300, 75,0.5));
			//this.pridajDoZoznamu(clovekPreZmluvu);
			textfield.appendText("Fyzicka osoba " + getMeno() + " uzavrela socialnu zmluvu\n");
		}
		else if(i == 3)
		{
			setPoisteny(new ZdravotnePoistenie(this, 250, 50,24));
			//this.pridajDoZoznamu(clovekPreZmluvu);
			textfield.appendText("Fyzicka osoba " + getMeno() + " uzavrela zdravotnu zmluvu\n");
		}
	}
}
