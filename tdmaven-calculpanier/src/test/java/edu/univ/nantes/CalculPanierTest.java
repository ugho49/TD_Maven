package edu.univ.nantes.tdMaven;

import static org.junit.Assert.*;
import edu.univ.nantes.tdMaven.CalculPanier;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CalculPanierTest {

	CalculPanier calcul;
		
	@Before
	public void setUp() {
		calcul = new CalculPanier();
	}
		
	@Test
	public void testCalcul() {
		assertEquals(15.0d, calcul.calcul("3", "5"), 0);
		assertEquals(15.0d, calcul.calcul(3, 5), 0);
	}
	
	@Test
	public void testCalculAvecParametreInvalide() {
		try {
			assertNull(calcul.calcul("XXX", "5"));
			fail("Une exception aurait du être levée");
		} catch (NumberFormatException e) {
		}
		
		try {
			assertNull(calcul.calcul("2", "XXX"));
			fail("Une exception aurait du être levée");
		} catch (NumberFormatException e) {
		}
	}

}
