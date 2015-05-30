package fi.softala.jee.demo.d04.bean;

public class Henkilo {
	
	private String etunimi;
	private String sukunimi;
	
	public Henkilo(String etunimi, String sukunimi) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
	}
	
	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	@Override
	public String toString() {
		return "Henkilo [etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}
}
