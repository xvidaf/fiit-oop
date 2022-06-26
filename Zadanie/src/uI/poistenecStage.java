package uI;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import osoba.Poistenec;

/** A class that represents a stage in the GUI, used when a customer logs in
 * @author vidaf
 *
 */
public class poistenecStage extends Stage{
	Pane pane = new Pane();
	public poistenecStage(Poistenec poistenec, Stage loginStage){
		Button buttonLogout = new Button("Odhlasit");
		buttonLogout.setLayoutX(600);
		buttonLogout.setLayoutY(600);
		pane.getChildren().addAll(buttonLogout); 
		
		Button buttonUdalost = new Button("Nahlasit Poistnu Udalost");
		buttonUdalost.setLayoutX(0);
		buttonUdalost.setLayoutY(300);
		pane.getChildren().addAll(buttonUdalost); 
		
		Button buttonZrusitPoistenie = new Button("Zrusit Poistenie");
		buttonZrusitPoistenie.setLayoutX(190);
		buttonZrusitPoistenie.setLayoutY(300);
		pane.getChildren().addAll(buttonZrusitPoistenie); 
		
		Button buttonZmenHeslo = new Button("Zmen Heslo");
		buttonZmenHeslo.setLayoutX(500);
		buttonZmenHeslo.setLayoutY(600);
		pane.getChildren().addAll(buttonZmenHeslo); 
		
		TextArea textField = new TextArea();
		textField.setLayoutX(0);
		textField.setLayoutY(400);
		textField.setPrefWidth(500);
		pane.getChildren().add(textField);
		
		Label labelMenoPoistenca = new Label("Meno poistenca: " + poistenec.getMeno());
		labelMenoPoistenca.setLayoutX(0);
		labelMenoPoistenca.setLayoutY(0);
		pane.getChildren().add(labelMenoPoistenca);
		
		Label labelStavUctu = new Label("Stav uctu: " + poistenec.getPeniaze());
		labelStavUctu.setLayoutX(600);
		labelStavUctu.setLayoutY(0);
		pane.getChildren().add(labelStavUctu);
		
		Button buttonPridajPeniaze = new Button("Pridaj 100 na ucet");
		buttonPridajPeniaze.setLayoutX(600);
		buttonPridajPeniaze.setLayoutY(40);
		pane.getChildren().addAll(buttonPridajPeniaze); 
		
		Label labelMenoZamestnanca = new Label("Meno zodpovedného zamestnanca: " + poistenec.getObserver().getMeno());
		labelMenoZamestnanca.setLayoutX(0);
		labelMenoZamestnanca.setLayoutY(20);
		pane.getChildren().add(labelMenoZamestnanca);
		
		Label labelZmluva = new Label("Nieje uzavtreta zmluva");
		labelZmluva.setLayoutX(0);
		labelZmluva.setLayoutY(40);
		pane.getChildren().add(labelZmluva);
		
		Label labelZmluvaTyp = new Label("Typ Zmluvy");
		labelZmluvaTyp.setLayoutX(0);
		labelZmluvaTyp.setLayoutY(60);
		pane.getChildren().add(labelZmluvaTyp);
		labelZmluvaTyp.setVisible(false);
		
		Label labelZmluvaPoplatok = new Label("Poplatok");
		labelZmluvaPoplatok.setLayoutX(0);
		labelZmluvaPoplatok.setLayoutY(80);
		pane.getChildren().add(labelZmluvaPoplatok);
		labelZmluvaPoplatok.setVisible(false);
		
		UIController.getInstance().checkZmluva(labelZmluva, poistenec, labelZmluvaTyp, labelZmluvaPoplatok);
		
		
		class actionOnbuttonUdalost implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {		
				UIController.getInstance().buttonUdalostMetoda(poistenec, textField);
			}
		}
		buttonUdalost.setOnAction(new actionOnbuttonUdalost());
		
		class actionOnbuttonZmenHeslo implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {		
				UIController.getInstance().buttonZmenHeslo(poistenec, textField);
			}
		}
		buttonZmenHeslo.setOnAction(new actionOnbuttonZmenHeslo());
		
		class actionOnbuttonZrusPoistenie implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {		
				UIController.getInstance().buttonZrusitPoistenieMetoda(poistenec, textField, labelZmluva, labelZmluvaTyp, labelZmluvaPoplatok);
			}
		}
		buttonZrusitPoistenie.setOnAction(new actionOnbuttonZrusPoistenie());
		
		class actionOnbuttonPridajPeniaze implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {		
				UIController.getInstance().buttonPridajPeniazeMetoda(poistenec, labelStavUctu);
			}
		}
		buttonPridajPeniaze.setOnAction(new actionOnbuttonPridajPeniaze());
		
		
		
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(loginStage);
		buttonLogout.setOnAction(actionEvent -> this.close());
	    this.setScene(new Scene(pane, 750, 700));
	    this.show();
	   }    
}

