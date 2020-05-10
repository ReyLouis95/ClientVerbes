package com.iut.clientverbesmaven;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeScene {

	
	public void change(String nomScene) throws Exception {
		Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/"+ nomScene + ".fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}
