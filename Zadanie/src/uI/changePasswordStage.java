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
 * A class that represents a stage in the GUI, used when a customer requests a password change
 * @author vidaf
 *
 */
public class changePasswordStage extends Stage{
	Pane pane = new Pane();
	public changePasswordStage(Clovek clovek, TextArea originalnytextfield) {
		

		TextField passwordTextField = new PasswordField(); 
		passwordTextField.setLayoutX(140);
		passwordTextField.setLayoutY(0);
		pane.getChildren().add(passwordTextField);
		
		Label labelLogin = new Label("Zadajte heslo: ");
		labelLogin.setLayoutX(5);
		labelLogin.setLayoutY(0);
		pane.getChildren().add(labelLogin);
		
		Button buttonPotvrditHeslo = new Button("Potvrdit");
		buttonPotvrditHeslo.setLayoutX(0);
		buttonPotvrditHeslo.setLayoutY(30);
		pane.getChildren().addAll(buttonPotvrditHeslo); 
		
		
		buttonPotvrditHeslo.setOnAction(actionEvent -> UIController.getInstance().buttonPotvrdHeslo(clovek,passwordTextField,this,originalnytextfield));
		
		this.setOnCloseRequest(window -> {
			UIController.getInstance().closeStageZmenHeslo(this,originalnytextfield);

	    });
		
		
		this.setScene(new Scene(pane, 360, 70));
	    this.show();
		
	}
}
