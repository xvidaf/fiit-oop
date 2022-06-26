package osoba;

import interfaces.GiveInfo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import poistovna.Zamestnanec;
import uI.poistenecStage;
import udalost.poistnaUdalost;
import zmluvy.*;



/**
 * An abstract class that specifies customers in our project
 * @author vidaf
 *
 */
public abstract class Poistenec extends Clovek implements GiveInfo{
	
	protected boolean poisteny;
	protected Zmluva UzatvorenaZmluva;
	protected Zamestnanec observer;
	protected poistnaUdalost udalost;
	protected boolean jeUdalost;
	protected double peniaze;
	
	public void login(Stage loginStage)
	{
		new poistenecStage(this,loginStage);
	}
	
	public boolean isPoisteny() {
		return poisteny;
	}
	
	public void setPoisteny(Zmluva poistnaZmluva) {
		this.poisteny = true;
		UzatvorenaZmluva = poistnaZmluva;
	}
	
	public void zrusPoisteny()
	{
		this.poisteny = false;
	}
	/**
	 * Used to get information about customer
	 */
	public String getInformacie()
	{
		if(this.poisteny)
		{
			return "Meno poistenca je " + this.meno + ", poistenec ma uzavretu zmluvu\n";
		}
		else
		{
			return "Meno poistenca je " + this.meno + ", poistenec este nema uzavretu zmluvu\n";
		}
	}
	//Strhne mesacnu platbu
	
	/**
	 * Deducts the monthly sum from the customer
	 * @param zamestnanecArea TextArea where we write the text
	 */
	public void koniecMesiaca(TextArea zamestnanecArea) {
		if(peniaze >= UzatvorenaZmluva.getMesacnaPlatba())
		{
			UzatvorenaZmluva.koniecMesiaca(this);
			zamestnanecArea.appendText("Poistenec " + meno + " zaplatil mesacnu platbu, ostava mu na ucte " + peniaze + "\n");
		}
		else {
			zamestnanecArea.appendText("Poistenec " + meno + " nevedel zaplatit mesacnu platbu, jeho poistenie bolo zrusene\n");
			this.zrusPoisteny();
		}
	}
	//Observer update
	/*public void nahlasPoistnuUdalost() {
		udalost = new poistnaUdalost();
		jeUdalost = true;
		observer.update();
	}*/
	
	public boolean isUdalost()
	{
		return jeUdalost;
	}
	//Oznami observerovy ze sa udalost vyriesila
	/**
	 * Notifies the observer that the insurence event has been resolved
	 */
	public void removeUdalost()
	{
		jeUdalost = false;
		observer.updateDone();
	}
	
	public Zamestnanec getObserver()
	{
		return observer;
	}
	
	public Zmluva getZmluva()
	{
		return UzatvorenaZmluva;
	}
	
	/**
	 * Creates a Insurance event and notifies the observer
	 * @param loginTextArea TextArea to write to
	 */
	public abstract void nahlasPoistnuUdalost(TextArea loginTextArea);
	
	public double getPeniaze()
	{
		return peniaze;
	}
	
	/** 
	 * Changes the amount of money a customer has and updates the label
	 * @param pridat The amount we add
	 * @param labelPeniaze The label we change to reflect the change of money
	 */
	public void addToPeniaze(double pridat, Label labelPeniaze)
	{
		peniaze += pridat;
		labelPeniaze.setText("Stav uctu: " + peniaze);
	}
	
	/**
	 *  Changes the amount of money a customer has
	 * @param pridat pridat The amount we add
	 */
	public void addToPeniaze(double pridat)
	{
		peniaze += pridat;
	}
	
	/**
	 * Checks which buttons to display
	 * @param button1 Button to check
	 * @param button2 Button to check
	 * @param button3 Button to check
	 */
	public abstract void checkButtons(Button button1, Button button2, Button button3);
	
	/** 
	 * Chooses and creates an Insurence for customer
	 * @param i Indetifier for the type of Insurance
	 * @param textfielf TextArea to write to
	 */
	public abstract void poistit(int i, TextArea textfield);
	
	public poistnaUdalost getUdalost()
	{
		return udalost;
	}

}
