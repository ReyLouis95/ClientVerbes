package com.iut.clientverbesmaven.outils;

public class Outils {

	/**
	 * remplace les "," par des "\n"
	 * @param chaine: chaine a convertir
	 * @return la chaine convertie
	 */
	public static String convertChaine(String chaine) {
		chaine = chaine.replace(',', '\n');
		return chaine;
	}
}
