package com.iut.clientverbesmaven.controleurs;


import com.iut.clientverbesmaven.models.Connexion;
import com.iut.clientverbesmaven.outils.Outils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrincipalControleur {

	@FXML
	private TextField temps;
	@FXML
	private TextField verbe;
	@FXML
	private TextArea reponse;
	
	public void onClickEnvoiRequete(ActionEvent event) {
		String verbe = this.verbe.getText().trim();
		String temps = this.temps.getText().trim();
		Connexion connexion = new Connexion();
		this.reponse.setText(Outils.convertChaine(connexion.envoiRequete(verbe,temps)));
	}
}
