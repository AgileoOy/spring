package fi.agileo.spring.e11.kello;

import org.junit.Before;
import org.junit.Test;

import fi.agileo.spring.e11.kello.KelloLahde;
import fi.agileo.spring.e11.kello.SuomiKello;
import static org.junit.Assert.*;

public class SuomiKelloTest {

	private SuomiKello kello;
	
	@Before
	public void createKello() {
		KelloLahde mockLahde = new MockKelloLahde();
		this.kello = new SuomiKello(mockLahde);
	}

	@Test
	public void testGetAika() {
		String actual  = this.kello.getAika();
		String expected = "13:22"; //EASTERN EUROPEAN TIME (GMT + 2 HOURS)
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetPvm() {
		String actual  = this.kello.getPvm();
		String expected = "02.01.1970";
		assertEquals(expected, actual);
	}
}
