package fi.agileo.spring.e09.bean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import fi.agileo.security.Salaaja;

public class WebUser {

	private int id;
	private String username;
	private String salt;
	private String passwordHash;

	private static final String SALAUS_ALGORITMI = Salaaja.SHA512;
	private static final int SALAUS_KIERROKSIA = 100;

	/**
	 * Luo uuden webuser-olion usernamella ja passwordilla. Generoi suolan ja
	 * hashaa salasanan automaattisesti käyttäen Salaaja-luokkaa.
	 * 
	 * @param username
	 *            Käyttäjätunnus
	 * @param password
	 *            Selkokielinen salasana
	 * @param password2
	 *            Selkokielinen salasana uudestaan
	 * @throws NoSuchAlgorithmException
	 *             Mikäli salausalgoritmia ei löydy
	 * @throws UnsupportedEncodingException
	 *             Mikäli suolaa tai hashia ei voida enkoodata tekstiksi
	 * @throws InvalidWebUserPoikkeus
	 *             Mikäli tietojen validointi epäonnistui
	 */
	public WebUser(String username, String password, String password2)
			throws NoSuchAlgorithmException, UnsupportedEncodingException,
			InvalidWebUserPoikkeus {
		super();

		validoi(username, password, password2);

		this.username = username;

		// generoidaan suola
		String suola = Salaaja.generoiSuola();
		setSalt(suola);
		// kryptataan salasana
		String kryptattuSalasana = Salaaja.salaa(password, getSalt(),
				SALAUS_ALGORITMI, SALAUS_KIERROKSIA);
		setPasswordHash(kryptattuSalasana);
	}

	public WebUser(int id, String username, String salt, String passwordHash) {
		super();
		this.id = id;
		this.username = username;
		this.salt = salt;
		this.passwordHash = passwordHash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Override
	public String toString() {
		return "WebUser [id=" + id + ", username=" + username + ", salt="
				+ salt + ", passwordHash=" + passwordHash + "]";
	}

	private void validoi(String username, String password, String password2)
			throws InvalidWebUserPoikkeus {
		
		if (username == null || username.trim().length() < 3)
			throw new InvalidWebUserPoikkeus(
					"Käyttäjätunnuksen täytyy olla vähintään 3 merkkiä pitkä");
		else if (password == null || password.trim().length() < 6)
			throw new InvalidWebUserPoikkeus(
					"Salasanan täytyy olla vähintään 6 merkkiä pitkä");
		else if (!password.equals(password2))
			throw new InvalidWebUserPoikkeus("Salasanat eivät täsmää");
	}

	// kryptaa annetun salasanan tämän olion suolalla ja vertaa sitä tämän olion
	// salasanahashiin
	public boolean vertaaSalasanaa(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String kryptattuSalasana = Salaaja.salaa(password, getSalt(),
				SALAUS_ALGORITMI, SALAUS_KIERROKSIA);

		return kryptattuSalasana.equals(this.passwordHash);
	}

}
