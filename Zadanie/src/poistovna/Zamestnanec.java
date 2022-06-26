package poistovna;

import array.GenericArray;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import osoba.Clovek;
import osoba.Poistenec;
import uI.UIController;
import uI.zamestnanecStage;

/**
 * A class which represents an employee
 * @author vidaf
 *
 */
public class Zamestnanec extends Clovek{
	private int pocetPoistencov = 0;
	//private Poistenec[] zoznamPoistencov = new Poistenec[10];
	private GenericArray<Poistenec> zoznamPoistencov = new GenericArray(10);
	private int pocetNevybavenychUdalosti;
	
	public Zamestnanec(String menoZamestnanca)
	{
		pocetNevybavenychUdalosti = 0;
		meno = menoZamestnanca;
		pocetPoistencov = 0;
		login = menoZamestnanca;
		passwd = menoZamestnanca;
	}
	//Prihlasi pouzivatela
	public void login(Stage loginStage)
	{
		//System.out.println("Toto by sa nemalo vypisat");
		new zamestnanecStage(this, loginStage);
	}
	
	public int getPocetPoistencov() {
		return pocetPoistencov;
	}
	//Prida poistenca k spravovanym poistencom
	/**
	 * Adds the customer to the list of managed customers
	 * @param poistenec The customer to add
	 */
	public void pridajDoZoznamu(Poistenec poistenec)
	{
		/*zoznamPoistencov[pocetPoistencov] = poistenec;*/
		zoznamPoistencov.setObjektNaIndexe(pocetPoistencov, poistenec);
		UIController.getInstance().addToZoznam(poistenec);
		pocetPoistencov++;
	}
	//Vypise vsetkych klientov poistenca
	/**
	 * Lists all the clients of employee
	 * @return
	 */
	public String vypisKlientov()
	{
		String s = " ";
		for(int i = 0; i < pocetPoistencov; ++i)
		{
			//s = s.concat(zoznamPoistencov[i].getMeno());
			s = s.concat(zoznamPoistencov.getObjektNaIndexe(i).getMeno());
		}
		s = s.concat("\n");
		return s;
	}
	//Vypise klienta na mieste klientId
	/** Returns the name of the customer on id 1
	 * @param klientId
	 * @return
	 */
	public String vypisKlientov(int klientId)
	{
		if(klientId < pocetPoistencov)
		{
			//return zoznamPoistencov[klientId].getMeno();
			return zoznamPoistencov.getObjektNaIndexe(klientId).getMeno();
		}
		else
		{
			return "Zamestnanec nepoistuje klienta s id " + klientId + "\n";
		}
	}
	//Poisti klienta a zavrie okno s vyberom poisteni
	/**
	 * Insures the client and closes the window
	 * @param clovekPreZmluvu Person to insure
	 * @param textField Textarea to write to
	 * @param i Insurance type indetifier
	 * @param stage Current stage 
	 */
	public void poisti(Poistenec clovekPreZmluvu, TextArea textField, int i, Stage stage)
	{
		
		clovekPreZmluvu.poistit(i,textField);
		stage.close();
	}
	
	/**
	 * Return the customer from id
	 * @param id Id of customer to return
	 * @return 
	 */
	public Poistenec getZoznamPoistencov(int id) {
		//return zoznamPoistencov[id];
		return zoznamPoistencov.getObjektNaIndexe(id);
	}
	
	public void update()
	{
		++pocetNevybavenychUdalosti;
	}
	
	public void updateDone()
	{
		--pocetNevybavenychUdalosti;
	}
	
	public int getpocetNevybavenychUdalosti() {
		return pocetNevybavenychUdalosti;
	}
	
	
	
}
