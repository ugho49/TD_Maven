package edu.univ.nantes.tdMaven;

import static org.junit.Assert.*;
import edu.univ.nantes.tdMaven.CalculServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;

public class CalculServletTest {

	CalculServlet servlet;
		
	@Before
	public void setUp() {
		servlet = new CalculServlet();
	}
	
	@Test
	public void testAfficherReponse() throws IOException {
		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		servlet.afficherReponse(out, 2.0d, 2, 4.0d);
		assertTrue(writer.toString().contains("<HTML>"));
	}

}
