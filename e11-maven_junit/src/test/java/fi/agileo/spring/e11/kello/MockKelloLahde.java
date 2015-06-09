package fi.agileo.spring.e11.kello;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fi.agileo.spring.e11.kello.KelloLahde;

/**
 * Jotta Kellojen testaus olisi helpompaa, tätä luokkaa voidaan käyttää apuna.
 * Riippumatta kellonajasta, jolloin testi suoritetaan, tämä luokka näyttelee,
 * että ajanhetki olisi seuraavanlainen:
 * Vuosi: 1970
 * Kuukausi: Tammikuu
 * Päivä: 1
 * Tunnit: 11
 * Minuutit: 22
 * Sekunnit: 33
 */
public class MockKelloLahde implements KelloLahde {

	public Date haeAjanhetki() {
		Calendar kalenteri = new GregorianCalendar();
		kalenteri.setTime(new Date(0)); //change calendar position to epoch
		kalenteri.add(Calendar.DAY_OF_MONTH, 1);
		kalenteri.add(Calendar.HOUR_OF_DAY, 11);
		kalenteri.add(Calendar.MINUTE, 22);
		kalenteri.add(Calendar.SECOND, 33);
		return kalenteri.getTime();
	}
	
}
