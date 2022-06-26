package main;







import javafx.application.Application;
import javafx.stage.Stage;
import uI.loginStage;


public class Main extends Application {
	//private Poistenec[] ludia = new Poistenec[10];
	
	//private int counterPreLudi = 0;
	public void start(Stage primaryStage) throws Exception {
		 new loginStage();
	}
	
	 
	//Borderpane Experiment
	//Instantiating the BorderPane class  
		/*
    BorderPane bPane = new BorderPane();   
    bPane.setTop(new Label("Poistovna")); 
    bPane.setBottom(new TextField("Bottom")); 
    bPane.setLeft(new TextField("Left")); 
    bPane.setRight(new TextField("Right")); 
    bPane.setCenter(new TextField("Center")); 
  
    Scene scene = new Scene(bPane,700,700);  
    
    primaryStage.setTitle("Poistovna");       
    primaryStage.setScene(scene);          
    primaryStage.show(); 
   
	}
	*/
	  public static void main(String[] args) {
	    launch(args);
	  }
}
