package fi.agileo.spring.e11.kello;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/**
 * Hankkii aikatiedon internetistä palvelimelta time-a.nist.gov
 * Tämä koodi vaatii apache commons net -kirjaston.
 */
public class InternetKelloLahde implements KelloLahde {

	public Date haeAjanhetki() {
		String palvelin = null;
		try {
			palvelin = NTPProperties.getInstance().getProperty("server_domain");
		} catch(Exception e) {
			throw new InternetKelloLahdePoikkeus("aikapalvelimen osoitetta ei kyetty lukemaan properties-tiedostosta", e);
		}

        NTPUDPClient client = new NTPUDPClient();
        InetAddress osoite;
        TimeInfo aikatieto;
		try {
			osoite = InetAddress.getByName(palvelin);
			aikatieto = client.getTime(osoite);
		} catch (UnknownHostException e) {
			throw new InternetKelloLahdePoikkeus("aikapalvelimen osoitetta ei pystytty selvittämään",e);
		} catch (IOException e) {
			throw new InternetKelloLahdePoikkeus("aikatietoa ei kyetty noutamaan internetistä", e);
		}
        long millisekunnitEpochista = aikatieto.getReturnTime();
        Date ajanhetki = new Date(millisekunnitEpochista);
		return ajanhetki;
	}

}
