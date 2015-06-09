package fi.agileo.spring.e11.laskin;

import org.junit.Test;

import fi.agileo.spring.e11.laskin.Laskin;
import static org.junit.Assert.*;

public class LaskinTest {

	@Test
	public void testSummaaPerustilanne() {
		Laskin laskin = new Laskin();
		int tulos = laskin.summaa(3, 8);
		assertEquals(11, tulos);
	}
	
	@Test
	public void testSummaaNollat() {
		Laskin laskin = new Laskin();
		int tulos = laskin.summaa(0, 0);
		assertEquals(0, tulos);
	}
	
	@Test
	public void testSummaaNegatiiviset() {
		Laskin laskin = new Laskin();
		int tulos = laskin.summaa(-5, -9);
		assertEquals(-14, tulos);
	}
	

	@Test
	public void testKertolaskuPerustilanne() {
		Laskin laskin = new Laskin();
		int tulos = laskin.kertolasku(4, 9);
		assertEquals(36, tulos);
	}
	
	@Test
	public void testKertolaskuNolla() {
		Laskin laskin = new Laskin();
		int tulos = laskin.kertolasku(0, 98);
		assertEquals(0, tulos);
	}
	
	@Test
	public void testKertolaskuNegatiivinen() {
		Laskin laskin = new Laskin();
		int tulos = laskin.kertolasku(1, -1);
		assertEquals(-1, tulos);
	}
}
