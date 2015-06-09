package fi.agileo.spring.e11.kello;

import java.util.Date;

/**
 * KelloLahde-rajapinnan toteuttavan luokan täytyy kyetä selvittämään nykyinen
 * ajanhetki jostain.
 */
public interface KelloLahde {

	public Date haeAjanhetki();

}
