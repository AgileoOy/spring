package fi.agileo.spring.e09.dao;

public class DAOPoikkeus extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOPoikkeus() {
		super("Tietokantapoikkeus");
	}

	public DAOPoikkeus(String viesti) {
		super(viesti);
	}

	public DAOPoikkeus(Throwable aiheuttaja) {
		super(aiheuttaja);
	}

	public DAOPoikkeus(String viesti, Throwable aiheuttaja) {
		super(viesti, aiheuttaja);
	}

}
