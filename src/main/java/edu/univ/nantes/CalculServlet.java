package edu.univ.nantes.tdMaven;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CalculServlet extends HttpServlet {

	private static final long serialVersionUID = -4844181532031994804L;
	private static Logger log = Logger.getLogger(CalculServlet.class);
	private CalculPanier panier = new CalculPanier();
	
	public void init() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		log.info("Execution de la servlet HelloWorld");
		
		double prixUnitaire = Double.parseDouble(req.getParameter("prix"));
		int quantite = Integer.parseInt(req.getParameter("quantite"));
		
		double prixTotal = panier.calcul(prixUnitaire, quantite); 
		
		afficherReponse(res, prixUnitaire, quantite, prixTotal);
		
	}

	void afficherReponse(HttpServletResponse res, double prixUnitaire, int quantite, double prixTotal) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		afficherReponse(out,  prixUnitaire, quantite, prixTotal);
	}
	
	void afficherReponse(PrintWriter out, double prixUnitaire, int quantite, double prixTotal) throws IOException {
		out.println("<HTML>");
		out.println("<HEAD><TITLE>R&eacute;sultat</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H2>R&eacute;sultat</H2>");
		afficherDate(out);
		out.println("<hr/>");
		out.println("<br/>Prix unitaire:" + prixUnitaire);
		out.println("<br/>Quantit&eacute;:" + quantite);
		out.println("<br/>Prix total:<span id=\"prixTotal\">" + prixTotal + "</span>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
		
	}

	private void afficherDate(PrintWriter out) {
		try {
			Class clazzDateUtils = Class.forName("fr.iut.maven.DateUtils");
			Method methodeGetDate = clazzDateUtils.getMethod("getTexteAujourdhui");
			out.println("Nous sommes le " + methodeGetDate.invoke(null));
		} catch (Exception e) {
			out.println("La date n'est pas disponible. Ajouter la librairie DateUtils.");
		}
		
	}
	
	
}