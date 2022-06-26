package osoba;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import poistovna.Zamestnanec;
import uI.UIController;
import udalost.poistnaUdalost;
import zmluvy.MajetkovePoistenie;


/**
 * A class which represents one type of our customer
 * @author vidaf
 *
 */
public class PravnickaOsoba extends Poistenec{
	
	private static int pocet = 0;
	
	public PravnickaOsoba(String meno, Zamestnanec observer)
	{
		this.observer = observer;
		this.meno = meno;
		this.poisteny = false;
		this.jeUdalost = false;
		login = meno;
		passwd = meno;
		peniaze = 1000;
		++pocet;
		UIController.getInstance().addToZoznam(this);
	}
	
	public static int getPocet()
	{
		return pocet;
	}
	//Vrati informacie o poistencovy
	/**
	 * Returns information about the customer
	 */
	public String getInformacie()
	{
		if(this.poisteny)
		{
			return "Meno poistenca je " + this.meno + ",je evidovany ako pravnicka osoba, poistenec ma uzavretu zmluvu\n";
		}
		else
		{
			return "Meno poistenca je " + this.meno + ",je evidovany ako pravnicka ooba, poistenec este nema uzavretu zmluvu\n";
		}
	}
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
	}
	//Vytvory poistenie
	public void poistit(int i, TextArea textfield)
	{
		setPoisteny(new MajetkovePoistenie(this, 500, 280,50000));
		//this.pridajDoZoznamu(clovekPreZmluvu);
		textfield.appendText("Pravnicka osoba " + getMeno() + " uzavrela zmluvu\n");
	}

}
