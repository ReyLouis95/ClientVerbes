package com.iut.clientverbesmaven.controleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.iut.clientverbesmaven.ChangeScene;
import com.iut.clientverbesmaven.models.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccueilControleur implements Initializable {
    
	private static final String MESSAGE_ERREUR = "La connexion au serveur a échouée";
    @FXML
    private TextField ip;
    @FXML
    private TextField port;
    //Message d'erreur si les informations rentrées sont fausses
    @FXML
    private Label erreur;
    
    @FXML
    private void onClickConnexion(ActionEvent event) throws Exception {
        String ipText = ip.getText().trim();
        String port = this.port.getText().trim();
        Connexion connexion = new Connexion();
        if(!connexion.Connect(ipText, port)) {
        	erreur.setText(MESSAGE_ERREUR);
        }
        else {
			ChangeScene changeScene = new ChangeScene();
			changeScene.change("vuePrincipale");
			closeActualScene();
		}
    }
    
    private void closeActualScene() {
    	Stage actualStage = (Stage) ip.getScene().getWindow();
		actualStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
