package uI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import array.GenericArray;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import osoba.Clovek;
import osoba.FyzickaOsoba;
import osoba.Poistenec;
import osoba.PravnickaOsoba;
import poistovna.Zamestnanec;
import printer.Printer;

/**
 *  A class that is used to store and control most UI elements, used for separating UI and Logic
 * @author vidaf
 *
 */
public class UIController implements Serializable{
	
	//private Clovek[] zoznamRegistrovanych = new Clovek[100];
	GenericArray<Clovek> zoznamRegistrovanych = new GenericArray(100);
	private int pocetRegistrovanych = 0;
	private static UIController instance = new UIController();
	
	
	private UIController() {
		UIController e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("zoznamZamestnancov.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (UIController) in.readObject();
	         //zoznamRegistrovanych = e.zoznamRegistrovanych;
	         zoznamRegistrovanych = e.zoznamRegistrovanych;
		     pocetRegistrovanych = e.pocetRegistrovanych;
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	    	 System.out.println("Subor serializacie nenajdeny, vytvarame zakladne login data"); 
	    	 zoznamRegistrovanych.setObjektNaIndexe(0, new Zamestnanec("Filip"));
	    	 zoznamRegistrovanych.setObjektNaIndexe(1, new Zamestnanec("Dusan"));
	 		 ++pocetRegistrovanych;
	 		 ++pocetRegistrovanych;
	         //i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return;
	      }
	      
	      //System.out.println(e.getEntry(0).getMeno());
	    //Stare bez serializacie
	      
		  
		  
		
		
	}
	
	public static UIController getInstance(){
        return instance;
    }
	
	public int getPocet(){
        return pocetRegistrovanych;
    }
	// Metody pre rozne elementy javafx, volaju sa z event handlerov elementov
	/**
	 * Method use when button Login is pressed
	 * @param login
	 * @param passwd
	 * @param alert
	 * @param loginStage
	 */
	void login(String login, String passwd, Alert alert, Stage loginStage)
	{
		for(int i = 0; i < pocetRegistrovanych; ++i)
		{
			/*
			if(zoznamRegistrovanych[i].getLogin().equals(login) && zoznamRegistrovanych[i].getPasswd().equals(passwd))
			{
				zoznamRegistrovanych[i].login();
				return;
			}
			*/
			if(zoznamRegistrovanych.getObjektNaIndexe(i).getLogin().equals(login) && zoznamRegistrovanych.getObjektNaIndexe(i).getPasswd().equals(passwd))
			{
				zoznamRegistrovanych.getObjektNaIndexe(i).login(loginStage);
				return;
			}
		}
		alert.showAndWait();
	}
	public void addToZoznam(Clovek registrovany)
	{
		//zoznamRegistrovanych[pocetRegistrovanych] = registrovany;
		zoznamRegistrovanych.setObjektNaIndexe(pocetRegistrovanych, registrovany);
		++pocetRegistrovanych;
	}
	public Clovek getEntry(int i)
	{
		//return zoznamRegistrovanych[i];
		return zoznamRegistrovanych.getObjektNaIndexe(i);
	}
	
	/**
	 * Method use when button PoistiMetoda is pressed
	 * @param radioButton
	 * @param poistovnik
	 * @param buttonPoistenci
	 * @param textField
	 */
	public void buttonPoistiMetoda(RadioButton[] radioButton, Zamestnanec poistovnik, Button[] buttonPoistenci, TextArea textField )
	{
		for(int i = 0; i < 10; ++i)
		{
			if(radioButton[i].isSelected())
			{
				//System.out.println(radioButton[i].getText());
				if(buttonPoistenci[i].getText()!="BLANK" && !(poistovnik.getZoznamPoistencov(i).isPoisteny()))
				{
					//poistovnik.poisti(poistovnik.getZoznamPoistencov(i), 100, 100, 10, textField);
					new vyberPoisteniaStage(poistovnik.getZoznamPoistencov(i), textField, i, poistovnik);
					break;
				}
				break;
			}
		}
	}
	/**
	 * Method use when button InformacieMetoda is pressed
	 * @param radioButton
	 * @param poistovnik
	 * @param buttonPoistenci
	 * @param textField
	 */
	public void buttonInformacieMetoda(RadioButton[] radioButton, Zamestnanec poistovnik, Button[] buttonPoistenci, TextArea textField )
	{
		for(int i = 0; i < 10; ++i)
		{
			if(radioButton[i].isSelected())
			{
				//System.out.println(radioButton[i].getText());
				if(buttonPoistenci[i].getText()!="BLANK" )
				{
					(new Printer(poistovnik,textField,i,1)).start();
					//textField.appendText(poistovnik.getZoznamPoistencov(i).getInformacie());
				}
				break;
			}
		}
	}
	/**
	 * Method use when button DalsiMesiac is pressed
	 * @param poistovnik
	 * @param zamestnanecArea
	 */
	public void buttonDalsiMesiacMetoda(Zamestnanec poistovnik, TextArea zamestnanecArea )
	{
		for(int i = 0; i < poistovnik.getPocetPoistencov(); ++i)
		{
			if(poistovnik.getZoznamPoistencov(i).isPoisteny())
			{
				poistovnik.getZoznamPoistencov(i).koniecMesiaca(zamestnanecArea);
			}
			else {
				zamestnanecArea.appendText("Poistenec " + poistovnik.getZoznamPoistencov(i).getMeno() + " nieje poisteni\n");
			}
		}
	}
	public void buttonZoznamMetoda( Zamestnanec poistovnik, TextArea textField )
	{
		(new Printer(poistovnik,textField,0,2)).start();
	}
	/**
	 * Method use when button PridajCloveka is pressed
	 * @param menoTextField
	 * @param fyzickaToggle
	 * @param pravnickaToggle
	 * @param poistovnik
	 * @param textField
	 * @param buttonPoistenci
	 */
	public void buttonPridajClovekaMetoda(TextField menoTextField, ToggleButton fyzickaToggle, ToggleButton pravnickaToggle, Zamestnanec poistovnik, TextArea textField, Button[] buttonPoistenci)
	{
		String meno = menoTextField.getText();
		if (!menoTextField.getText().isEmpty())
		{
			if(fyzickaToggle.isSelected())
			{
				if(FyzickaOsoba.getPocet() + PravnickaOsoba.getPocet() <10)
				{
					//System.out.println("Stlacili sme buttonPridajCloveka, mame vybrate Fyzicke" + meno);
					textField.appendText("Fyzicka osoba " + meno + " bola pridana do zoznamu zamestnanca" + poistovnik.getMeno() +"\n");
					poistovnik.pridajDoZoznamu(new FyzickaOsoba(meno, poistovnik));
					//System.out.println(ludia[0].getMeno());
					buttonPoistenci[poistovnik.getPocetPoistencov() - 1].setText(poistovnik.getZoznamPoistencov(poistovnik.getPocetPoistencov() - 1).getMeno());
				}
			}
			else if(pravnickaToggle.isSelected())
			{
				if(FyzickaOsoba.getPocet() + PravnickaOsoba.getPocet() <10)
				{
					textField.appendText("Pravnicka osoba " + meno + " bola pridana do zoznamu zamestnanca" + poistovnik.getMeno() +"\n");
					//System.out.println("Stlacili sme buttonPridajCloveka, mame vybrate Pravnicke" + meno);
					//ludia[FyzickaOsoba.getPocet() + PravnickaOsoba.getPocet()] = new PravnickaOsoba(meno);
					poistovnik.pridajDoZoznamu(new PravnickaOsoba(meno, poistovnik));
					buttonPoistenci[poistovnik.getPocetPoistencov() - 1].setText(poistovnik.getZoznamPoistencov(poistovnik.getPocetPoistencov() - 1).getMeno());
				}
			}
		}
	}
	/**
	 * Method use when button UlozUzivatelov is pressed
	 */
	public void buttonUlozUzivatelov()
	{
		try {
		FileOutputStream fileOut = new FileOutputStream("zoznamZamestnancov.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		out.close();
		fileOut.close();
		}catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public void closeStagePoistenec(Zamestnanec poistovnik, WindowEvent window, Alert alert)
	{
		if(poistovnik.getpocetNevybavenychUdalosti() > 0)
		{
			window.consume();
			alert.showAndWait();
		}
	}
	
	/**
	 * Method use when button Odhlasit is pressed
	 * @param poistovnik
	 * @param alert
	 * @param stage
	 */
	public void buttonOdhlasit(Zamestnanec poistovnik, Alert alert, Stage stage)
	{
		if(poistovnik.getpocetNevybavenychUdalosti() == 0)
		{
			stage.close();
		}
		else {
			alert.showAndWait();
		}
	}
	
	/**
	 * Method use when button Udalost is pressed
	 * @param poistovnik
	 * @param loginTextArea
	 */
	public void buttonUdalostMetoda(Poistenec poistovnik,TextArea loginTextArea) {
		if(poistovnik.isUdalost() == false && poistovnik.isPoisteny() == true)
		{
			poistovnik.nahlasPoistnuUdalost(loginTextArea);
		}
		else if(poistovnik.isPoisteny() == false)
		{
			loginTextArea.appendText("Nemozem nahlasit poistnu udalost, niesom poisteny\n");
		}
		else if(poistovnik.isUdalost() == true)
		{
			loginTextArea.appendText("Udalost uz bola nahlasena\n");
		}
	}
	
	/**
	 * Method use when button VyriesMetoda is pressed
	 * @param radioButton
	 * @param poistovnik
	 * @param buttonPoistenci
	 * @param textField
	 */
	public void buttonVyriesMetoda(RadioButton[] radioButton, Zamestnanec poistovnik, Button[] buttonPoistenci, TextArea textField) {
		for(int i = 0; i < 10; ++i)
		{
			if(radioButton[i].isSelected())
			{
				//System.out.println(radioButton[i].getText());
				if(buttonPoistenci[i].getText()!="BLANK" )
				{
					if(poistovnik.getZoznamPoistencov(i).isUdalost())
					{
						poistovnik.getZoznamPoistencov(i).removeUdalost();
						buttonPoistenci[i].setStyle(null);
						poistovnik.getZoznamPoistencov(i).addToPeniaze(poistovnik.getZoznamPoistencov(i).getUdalost().getHodnota());
						textField.appendText("Udalost poistenca " + poistovnik.getZoznamPoistencov(i).getMeno() + " bola vyriesena\n");
					}
					else {
						textField.appendText("Ziadna udalost sa nestala\n");
					}
					//textField.appendText(poistovnik.getZoznamPoistencov(i).getInformacie());
				}
				break;
			}
		}
	}
	/**
	 * Method use when button ZmenHeslo is pressed
	 * @param clovek
	 * @param originalyField
	 */
	public void buttonZmenHeslo(Clovek clovek, TextArea originalyField)
	{
		new changePasswordStage(clovek, originalyField);
	}
	
	/**
	 * Method use when button potvrdHeslo is pressed
	 * @param clovek
	 * @param hesloField
	 * @param stage
	 * @param origoArea
	 */
	public void buttonPotvrdHeslo(Clovek clovek, TextField hesloField, Stage stage, TextArea origoArea)
	{
		origoArea.appendText("Heslo bolo zmenene\n");
		String noveHeslo = hesloField.getText();
		clovek.setPasswd(noveHeslo);
		stage.close();
	}
	
	public void closeStageZmenHeslo(Stage stage, TextArea OrigoTextField)
	{
		OrigoTextField.appendText("Heslo nebolo zmenene\n");
		stage.close();
	}
	
	/**
	 *  Checks which elements to display in poistenecStage
	 * @param label
	 * @param poistenec
	 * @param typ
	 * @param poplatok
	 */
	public void checkZmluva(Label label, Poistenec poistenec, Label typ, Label poplatok)
	{
		if(poistenec.isPoisteny())
		{
			label.setText("Zmluva je uzavreta");
			poplatok.setText("Mesacny poplatok:" + poistenec.getZmluva().getMesacnaPlatba());
			poplatok.setVisible(true);
			typ.setText("Typ poistenia: " + poistenec.getZmluva().getTypPoistenia());
			typ.setVisible(true);
		}
		else
		{
			label.setText("Nieje uzavtreta zmluva");
			poplatok.setVisible(false);
			typ.setVisible(false);
		}
	}
	
	/**
	 * Method use when button ZrusitPoistenie is pressed
	 * @param poistenec
	 * @param origoArea
	 * @param label
	 * @param typ
	 * @param poplatok
	 */
	public void buttonZrusitPoistenieMetoda(Poistenec poistenec, TextArea origoArea, Label label,Label typ, Label poplatok)
	{
		if(poistenec.isPoisteny())
		{
			poistenec.zrusPoisteny();
			origoArea.appendText("Poistenie bolo zrusene\n");
			checkZmluva(label,poistenec,typ,poplatok);
		}
		else {
			origoArea.appendText("Poistenie este nebolo uzavrete\n");
		}
		
	}
	
	/**
	 *  Method use when button VytvorZamestnanca is pressed
	 * @param heslo
	 * @param meno
	 * @param stage
	 */
	public void buttonVytvorZamestnanca (TextField heslo, TextField meno, Stage stage)
	{
		if(heslo.getText().isEmpty() || meno.getText().isEmpty())
		{
			stage.close();
		}
		else {
			Zamestnanec newZamestnanec = new Zamestnanec(meno.getText());
			newZamestnanec.setPasswd(heslo.getText());
			addToZoznam(newZamestnanec);
			stage.close();
		}
		
	}
	
	/**
	 * Creates NewZamestnanecStage
	 */
	public void buttonVytvorZamestnancaStage()
	{
		new NewZamestnanecStage();
	}
	
	/** 
	 * Method used when button PridajPeniaze is used
	 * @param poistenec
	 * @param labelPeniaze
	 */
	public void buttonPridajPeniazeMetoda(Poistenec poistenec, Label labelPeniaze)
	{
		poistenec.addToPeniaze(100, labelPeniaze);
	}
	
	public void checkAvailableButtons (Poistenec poistenec , Button button1, Button button2, Button button3)
	{
		poistenec.checkButtons(button1, button2, button3);
	}


		
}
