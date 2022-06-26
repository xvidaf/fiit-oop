package uI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import osoba.FyzickaOsoba;
import osoba.PravnickaOsoba;
import poistovna.Zamestnanec;

/**
 *  A class that represents a stage in the GUI, used when a employee logs in
 * @author vidaf
 *
 */
public class zamestnanecStage extends Stage {
	
	//private Poistenec[] ludia = new Poistenec[10];
	//private Zamestnanec poistovnik = new Zamestnanec("Jano");
	
	//private int counterPreLudi = 0;
	public zamestnanecStage(Zamestnanec poistovnik, Stage loginStage) {
		Button[] buttonPoistenci = new Button[10];
		RadioButton[] radioButton = new RadioButton[10];
	    //btn.setOnAction((e) -> System.out.println("Hello World !"));
		//StackPane root = new StackPane();
		ToggleGroup group2 = new ToggleGroup();
		Pane pane = new Pane(); 
		for( int i=0; i < 9; i = i + 2){	    
			buttonPoistenci[i] = new Button();
			if(poistovnik.getPocetPoistencov() > i)
			{
				buttonPoistenci[i].setText(poistovnik.getZoznamPoistencov(i).getMeno());   
				if(poistovnik.getZoznamPoistencov(i).isUdalost())
				{
					buttonPoistenci[i].setStyle("-fx-border-color: #ff0000; -fx-border-width: 3px;");
				}
			}
			else {
				buttonPoistenci[i].setText("BLANK");   
			}
			buttonPoistenci[i].setLayoutX(40);
			buttonPoistenci[i].setLayoutY(i*20);
		    radioButton[i] = new RadioButton();
		    radioButton[i].setText(Integer.toString(i+1));
		    radioButton[i].setLayoutX(0);
		    radioButton[i].setLayoutY(i*20);
			
			buttonPoistenci[i + 1] = new Button();     
			if(poistovnik.getPocetPoistencov() > i + 1)
			{
				buttonPoistenci[i+1].setText(poistovnik.getZoznamPoistencov(i+1).getMeno());  
				if(poistovnik.getZoznamPoistencov(i+1).isUdalost())
				{
					buttonPoistenci[i+1].setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
				}
			}
			else {
				buttonPoistenci[i+1].setText("BLANK");   
			}
			buttonPoistenci[i + 1].setLayoutX(180);
			buttonPoistenci[i + 1].setLayoutY(i*20);
			radioButton[i+1] = new RadioButton();
		    radioButton[i+1].setText(Integer.toString(i+2));
		    radioButton[i+1].setLayoutX(140);
		    radioButton[i+1].setLayoutY(i*20);

		    radioButton[i].setToggleGroup(group2);
		    radioButton[i+1].setToggleGroup(group2);
		    pane.getChildren().addAll(buttonPoistenci[i]); 
		    pane.getChildren().addAll(buttonPoistenci[i + 1]);
		    pane.getChildren().addAll(radioButton[i]); 
		    pane.getChildren().addAll(radioButton[i+1]); 

		}
		Button buttonDalsiMesiac = new Button("Dalsi mesiac");
		buttonDalsiMesiac.setLayoutX(500);
		buttonDalsiMesiac.setLayoutY(560);
		pane.getChildren().addAll(buttonDalsiMesiac); 
		
		Button buttonPoisti = new Button("Poisti");
		buttonPoisti.setLayoutX(0);
		buttonPoisti.setLayoutY(200);
		pane.getChildren().addAll(buttonPoisti); 
		
		Button buttonInformacie = new Button("Informacie");
		buttonInformacie.setLayoutX(100);
		buttonInformacie.setLayoutY(200);
		pane.getChildren().addAll(buttonInformacie); 
		
		Button buttonZoznam = new Button("ZoznamPoistencov");
		buttonZoznam.setLayoutX(200);
		buttonZoznam.setLayoutY(200);
		pane.getChildren().addAll(buttonZoznam); 
		
		//Cast pre vytvaranie cloveka
		TextField menoTextField = new TextField(); 
		menoTextField.setLayoutX(500);
		menoTextField.setLayoutY(20);
		pane.getChildren().add(menoTextField);
		
		Button buttonLogout = new Button("Odhlasit");
		buttonLogout.setLayoutX(610);
		buttonLogout.setLayoutY(600);
		pane.getChildren().addAll(buttonLogout);
		
		Button buttonVyriesUdalost = new Button("Vyries Udalost");
		buttonVyriesUdalost.setLayoutX(380);
		buttonVyriesUdalost.setLayoutY(200);
		pane.getChildren().addAll(buttonVyriesUdalost); 
		
		ToggleButton fyzickaToggle = new ToggleButton("Fyzicka Osoba");
		ToggleButton pravnickaToggle = new ToggleButton("Pravnicka Osoba");
		ToggleGroup group = new ToggleGroup();
		fyzickaToggle.setToggleGroup(group);
		pravnickaToggle.setToggleGroup(group);
		fyzickaToggle.setLayoutX(500);
		fyzickaToggle.setLayoutY(50);
		pravnickaToggle.setLayoutX(620);
		pravnickaToggle.setLayoutY(50);
		pane.getChildren().add(pravnickaToggle);
		pane.getChildren().add(fyzickaToggle);
		
		Button buttonPridajCloveka = new Button("Pridaj");
		buttonPridajCloveka.setLayoutX(500);
		buttonPridajCloveka.setLayoutY(80);
		pane.getChildren().add(buttonPridajCloveka); 
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("Mate este nevybavene udalosti");
		
		Button buttonZmenHeslo = new Button("Zmen Heslo");
		buttonZmenHeslo.setLayoutX(500);
		buttonZmenHeslo.setLayoutY(600);
		pane.getChildren().addAll(buttonZmenHeslo); 
		
		buttonLogout.setOnAction(actionEvent -> UIController.getInstance().buttonOdhlasit(poistovnik, alert, this));/*this.close());*/
		
	
		//Textfield
		TextArea textField = new TextArea();
		textField.setLayoutX(0);
		textField.setLayoutY(400);
		textField.setPrefWidth(500);
		pane.getChildren().add(textField);

		//Metody
		class actionOnbuttonPridajCloveka implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				String meno = menoTextField.getText();
				/*if (!menoTextField.getText().isEmpty())
				{
					
					if(fyzickaToggle.isSelected())
					{
						if(FyzickaOsoba.getPocet() + PravnickaOsoba.getPocet() <10)
						{
							textField.appendText("Fyzicka osoba " + meno + " bola pridana do zoznamu zamestnanca" + poistovnik.getMeno() +"\n");
							poistovnik.pridajDoZoznamu(new FyzickaOsoba(meno));
							buttonPoistenci[poistovnik.getPocetPoistencov() - 1].setText(poistovnik.getZoznamPoistencov(poistovnik.getPocetPoistencov() - 1).getMeno());
						}
					}
					else if(pravnickaToggle.isSelected())
					{
						if(FyzickaOsoba.getPocet() + PravnickaOsoba.getPocet() <10)
						{
							textField.appendText("Pravnicka osoba " + meno + " bola pridana do zoznamu zamestnanca" + poistovnik.getMeno() +"\n");
							poistovnik.pridajDoZoznamu(new PravnickaOsoba(meno));
							buttonPoistenci[poistovnik.getPocetPoistencov() - 1].setText(poistovnik.getZoznamPoistencov(poistovnik.getPocetPoistencov() - 1).getMeno());
						}
					}
				}*/
				UIController.getInstance().buttonPridajClovekaMetoda(menoTextField, fyzickaToggle, pravnickaToggle, poistovnik, textField, buttonPoistenci);
			}
		}
		buttonPridajCloveka.setOnAction(new actionOnbuttonPridajCloveka());
		
		class actionOnbuttonPoisti implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				/*for(int i = 0; i < 10; ++i)
				{
					if(radioButton[i].isSelected())
					{
						//System.out.println(radioButton[i].getText());
						if(buttonPoistenci[i].getText()!="BLANK" && !(poistovnik.getZoznamPoistencov(i).isPoisteny()))
						{
							poistovnik.poisti(poistovnik.getZoznamPoistencov(i), 100, 100, 10);
						}
						break;
					}
				}*/
				UIController.getInstance().buttonPoistiMetoda(radioButton, poistovnik, buttonPoistenci, textField);
			}
		}
		buttonPoisti.setOnAction(new actionOnbuttonPoisti());
		
		class actionOnbuttonInformacie implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				/*for(int i = 0; i < 10; ++i)
				{
					if(radioButton[i].isSelected())
					{
						//System.out.println(radioButton[i].getText());
						if(buttonPoistenci[i].getText()!="BLANK" )
						{
							textField.appendText(poistovnik.getZoznamPoistencov(i).getInformacie());
						}
						break;
					}
				}*/
				UIController.getInstance().buttonInformacieMetoda(radioButton, poistovnik, buttonPoistenci, textField);
			}
		}
		buttonInformacie.setOnAction(new actionOnbuttonInformacie());
		
		class actionOnbuttonDalsiMesiac implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				UIController.getInstance().buttonDalsiMesiacMetoda(poistovnik, textField);
			}
		}
		buttonDalsiMesiac.setOnAction(new actionOnbuttonDalsiMesiac());
		
		class actionOnbuttonZoznam implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				UIController.getInstance().buttonZoznamMetoda(poistovnik, textField);
			}
		}
		buttonZoznam.setOnAction(new actionOnbuttonZoznam());
		
		this.setOnCloseRequest(window -> {
			UIController.getInstance().closeStagePoistenec(poistovnik,window, alert);

	    });
		
		class actionOnbuttonVyries implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				UIController.getInstance().buttonVyriesMetoda(radioButton, poistovnik, buttonPoistenci, textField);
			}
		}
		buttonVyriesUdalost.setOnAction(new actionOnbuttonVyries());
		
		class actionOnbuttonZmenHeslo implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {		
				UIController.getInstance().buttonZmenHeslo(poistovnik, textField);
			}
		}
		buttonZmenHeslo.setOnAction(new actionOnbuttonZmenHeslo());
		
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(loginStage);
		
	    //Scene scene = new Scene(root, 300, 300);
		Scene scene = new Scene(pane, 750, 700); 
	    this.setTitle("Poistovna");
	    this.setScene(scene);
	    this.show();
	  }
	

}
