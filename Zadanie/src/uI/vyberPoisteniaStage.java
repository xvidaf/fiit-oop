package uI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osoba.Clovek;
import osoba.Poistenec;
import poistovna.Zamestnanec;

/**
 *  A class that represents a stage in the GUI, used when choosing which insurance to use
 * @author vidaf
 *
 */
public class vyberPoisteniaStage extends Stage{
	Pane pane = new Pane();
	public vyberPoisteniaStage(Poistenec poistenec, TextArea originalnytextfield, int i, Zamestnanec poistovnik) {
	
		Label labelLogin = new Label("Vyberte typ poistenia");
		labelLogin.setLayoutX(0);
		labelLogin.setLayoutY(0);
		pane.getChildren().add(labelLogin);
	
		Button buttonMajetkove = new Button("Majetkove");
		buttonMajetkove.setLayoutX(0);
		buttonMajetkove.setLayoutY(30);
		pane.getChildren().addAll(buttonMajetkove); 
		buttonMajetkove.setVisible(false);
		
		Button buttonZdravotne = new Button("Zdravotne");
		buttonZdravotne.setLayoutX(90);
		buttonZdravotne.setLayoutY(30);
		pane.getChildren().addAll(buttonZdravotne); 
		buttonZdravotne.setVisible(false);
		
		Button buttonSocialne = new Button("Socialne");
		buttonSocialne.setLayoutX(180);
		buttonSocialne.setLayoutY(30);
		pane.getChildren().addAll(buttonSocialne); 
		buttonSocialne.setVisible(false);
		
		UIController.getInstance().checkAvailableButtons(poistenec, buttonMajetkove, buttonZdravotne, buttonSocialne);
		
		buttonMajetkove.setOnAction(actionEvent -> poistovnik.poisti(poistovnik.getZoznamPoistencov(i),originalnytextfield, 1, this));
		
		buttonZdravotne.setOnAction(actionEvent -> poistovnik.poisti(poistovnik.getZoznamPoistencov(i),originalnytextfield, 2, this));
		
		buttonSocialne.setOnAction(actionEvent -> poistovnik.poisti(poistovnik.getZoznamPoistencov(i),originalnytextfield, 3, this));
		
		
		
		this.setScene(new Scene(pane, 300, 70));
	    this.show();
		
	}
	

}
