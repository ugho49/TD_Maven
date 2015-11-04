package edu.univ.nantes.tdMaven;

import java.lang.NumberFormatException;

import org.apache.log4j.Logger;

public class CalculPanier {

	public static Logger log = Logger.getLogger(CalculPanier.class);

	public double calcul(double prix, int quantite) {
		double resultat = prix * quantite;
		log.debug(prix + "*" + quantite + "=" + resultat);
		return resultat;
	}
	
	public double calcul(String prixTexte, String quantiteTexte) {
		double prixUnitaire = Double.parseDouble(prixTexte);
		int quantite = Integer.parseInt(quantiteTexte);
		return calcul(prixUnitaire, quantite);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NumberFormatException {
		log.info("Calcul de prix");
		log.info("Prix:" + args[0]);
		log.info("Quantité:" + args[1]);
		CalculPanier calcul = new CalculPanier();
		log.info("Prix total:" + calcul.calcul(args[0], args[1]));
		
	}

}
