package fi.agileo.spring.e11.kello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Tämä luokka hoitaa aikapalvelinasetusten lukemisen properties-tiedostosta
 */
public class NTPProperties {

	public static final String FILE_NAME = "ntp.properties";
	private static NTPProperties instance;
	private Properties properties;

	private NTPProperties() throws IOException {
		// ladataan arvot properties-tiedostosta
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(FILE_NAME);
		properties = new Properties();
		properties.load(inputStream);
	}

	public String getProperty(String nimi) {
		return this.properties.getProperty(nimi);
	}

	public static NTPProperties getInstance() throws IOException {
		if (instance == null) {
			instance = new NTPProperties();
		}
		return instance;
	}

}
