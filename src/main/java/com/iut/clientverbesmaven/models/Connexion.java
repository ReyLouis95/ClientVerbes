package com.iut.clientverbesmaven.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connexion {

	private static Socket socket;
	
	public Socket getInstance() {
		if(socket == null) {
			socket = new Socket();
		}
		return socket;
	}
	/**
	 * ouvre la connexion avec le serveur
	 * @param adresseIPServeur
	 * @param port
	 * @return true si la connexion est ouverte, sinon false
	 */
	public boolean Connect(String adresseIPServeur, String port) {
		//portServeur sert a faire la conversion en int
		int portServeur;
		try {
	    portServeur = Integer.parseInt(port.trim());
		}catch (NumberFormatException e) {
			System.out.println(e.getClass().getSimpleName());
			return false;
		}
	    InetAddress adresse = null;
		try {
			adresse = InetAddress.getByName(adresseIPServeur);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	    try {
			socket = new Socket( adresse, portServeur);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} // rï¿½alise la connexion et ouvre un socket bidirectionnel
	    return true;
	}
	
	public String envoiRequete(String verbe, String temps) {
		String requete = verbe + "/" + temps;
		BufferedReader fluxEntrant = null;
		PrintStream fluxSortant = null;
		String reponse = null;
		try {
		fluxEntrant = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		fluxSortant = new PrintStream(socket.getOutputStream());
	}catch (IOException e) {
		e.printStackTrace();
	}
		fluxSortant.println(requete); // envoi de la requï¿½te au serveur
        System.out.println("Envoi au serveur");
        try {
			reponse = fluxEntrant.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // rï¿½ception de la rï¿½ponse
        return reponse;
	}
}
