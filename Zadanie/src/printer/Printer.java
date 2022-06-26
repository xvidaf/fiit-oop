package printer;

import javafx.scene.control.TextArea;
import osoba.Poistenec;
import poistovna.Zamestnanec;


/**
 * A class which represents a printer, used to print information about customers to a textArea
 * @author vidaf
 *
 */
public class Printer extends Thread{
	int i = 0;
	Zamestnanec poistovnik;
	TextArea textField;
	int type;
	
	public interface Print {
		void printInformacie(Poistenec poistenec); 
	}
	
	public Printer(Zamestnanec poistovnik, TextArea textField, int i , int type) {
		this.i = i;
		this.poistovnik = poistovnik;
		this.textField = textField;
		this.type = type;
	}
	
	Print implementedInterface = (Poistenec poistenec) -> {
		textField.appendText(poistenec.getInformacie());
	};
	
	public void run() {
		if(type == 1) // Vypis Jedneho
		{
			implementedInterface.printInformacie(poistovnik.getZoznamPoistencov(i));
			if(poistovnik.getZoznamPoistencov(i).isPoisteny())
			{
				textField.appendText("Typ uzatvorenej zmluvy je " + poistovnik.getZoznamPoistencov(i).getZmluva().getTypPoistenia() + " mesacny poplatok je " + poistovnik.getZoznamPoistencov(i).getZmluva().getMesacnaPlatba() + "\n");
			}
		}
		else if(type == 2) // Každý poistenec pod zamestnancom
		{
			for(int l = 0; l < poistovnik.getPocetPoistencov(); ++l)
			{
				implementedInterface.printInformacie(poistovnik.getZoznamPoistencov(l));
				if(poistovnik.getZoznamPoistencov(l).isPoisteny())
				{
					textField.appendText("Typ uzatvorenej zmluvy je " + poistovnik.getZoznamPoistencov(l).getZmluva().getTypPoistenia() + " mesacny poplatok je " + poistovnik.getZoznamPoistencov(l).getZmluva().getMesacnaPlatba() + "\n");
				}
			}
		}
		
	}

	
	

}
