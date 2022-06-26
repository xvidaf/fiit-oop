package uI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osoba.Clovek;

/**
 *  A class that represents a stage in the GUI, used for registering a new employee
 * @author vidaf
 *
 */
public class NewZamestnanecStage extends Stage{
	Pane pane = new Pane();
	public NewZamestnanecStage() {
		

		TextField passwordTextField = new PasswordField(); 
		passwordTextField.setLayoutX(100);
		passwordTextField.setLayoutY(50);
		pane.getChildren().add(passwordTextField);
		
		Label labelHeslo = new Label("Zadajte heslo:");
		labelHeslo.setLayoutX(0);
		labelHeslo.setLayoutY(50);
		pane.getChildren().add(labelHeslo);
		
		Button buttonPotvrditHeslo = new Button("Potvrdit");
		buttonPotvrditHeslo.setLayoutX(0);
		buttonPotvrditHeslo.setLayoutY(80);
		pane.getChildren().addAll(buttonPotvrditHeslo); 
		
		Label labelLogin = new Label("Zadajte meno:");
		labelLogin.setLayoutX(0);
		labelLogin.setLayoutY(5);
		pane.getChildren().add(labelLogin);
		
		TextField loginTextField = new TextField(); 
		loginTextField.setLayoutX(100);
		loginTextField.setLayoutY(0);
		pane.getChildren().add(loginTextField);
		
		
		buttonPotvrditHeslo.setOnAction(actionEvent -> UIController.getInstance().buttonVytvorZamestnanca(passwordTextField,loginTextField,this));
		
		
		this.setScene(new Scene(pane, 360, 120));
	    this.show();
		
	}

}
