package uI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *  A class that represents a stage in the GUI, used when logging in
 * @author vidaf
 *
 */
public class loginStage extends Stage {
Pane pane = new Pane();

public loginStage(){
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("ERROR");
	alert.setHeaderText("Zle meno alebo heslo");
	
	Button buttonLogin = new Button("Login");
	buttonLogin.setLayoutX(0);
	buttonLogin.setLayoutY(100);
	pane.getChildren().addAll(buttonLogin);
	
	Button buttonSave = new Button("Save");
	buttonSave.setLayoutX(0);
	buttonSave.setLayoutY(140);
	pane.getChildren().addAll(buttonSave); 
	
	Button buttonVytvorZamestnanecStage = new Button("Vytvor ucet pre zamestnanca");
	buttonVytvorZamestnanecStage.setLayoutX(60);
	buttonVytvorZamestnanecStage.setLayoutY(100);
	pane.getChildren().addAll(buttonVytvorZamestnanecStage); 
	
	TextField loginTextField = new TextField(); 
	loginTextField.setLayoutX(70);
	loginTextField.setLayoutY(0);
	pane.getChildren().add(loginTextField);
	
	PasswordField passwdTextField = new PasswordField(); 
	passwdTextField.setLayoutX(70);
	passwdTextField.setLayoutY(50);
	pane.getChildren().add(passwdTextField);
	
	Label labelLogin = new Label("Username");
	labelLogin.setLayoutX(0);
	labelLogin.setLayoutY(0);
	pane.getChildren().add(labelLogin);
	
	Label labelPassword = new Label("Password");
	labelPassword.setLayoutX(0);
	labelPassword.setLayoutY(50);
	pane.getChildren().add(labelPassword);
	
	/*class actionOnbuttonLogin implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
				UIController.getInstance().login(loginTextField.getText(), passwdTextField.getText(), alert);
		}
	}*/
	
	buttonLogin.setOnAction(actionEvent -> UIController.getInstance().login(loginTextField.getText(), passwdTextField.getText(), alert, this));
	
	class actionOnbuttonSave implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
				UIController.getInstance().buttonUlozUzivatelov();
		}
	}
	class actionOnbuttonVytvorZamestnanecStage implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
				UIController.getInstance().buttonVytvorZamestnancaStage();
		}
	}
	buttonSave.setOnAction(new actionOnbuttonSave());
	//buttonLogin.setOnAction(new actionOnbuttonLogin());
	buttonVytvorZamestnanecStage.setOnAction(new actionOnbuttonVytvorZamestnanecStage());
	
	
	
    this.setScene(new Scene(pane, 300, 200));
    this.show();
   }    
}
