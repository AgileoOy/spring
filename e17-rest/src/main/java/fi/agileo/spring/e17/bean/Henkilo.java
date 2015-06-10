package fi.agileo.spring.e17.bean;


public class Henkilo {

	private int id;
	private String etunimi;
	private String sukunimi;
	private String sahkoposti;
	private String lahiosoite;
	private String postinumero;
	private String postitoimipaikka;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}

	public String getLahiosoite() {
		return lahiosoite;
	}

	public void setLahiosoite(String lahiosoite) {
		this.lahiosoite = lahiosoite;
	}

	public String getPostinumero() {
		return postinumero;
	}

	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}

	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}

	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}

	@Override
	public String toString() {
		return "HenkiloImpl [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", sahkoposti=" + sahkoposti + ", lahiosoite="
				+ lahiosoite + ", postinumero=" + postinumero
				+ ", postitoimipaikka=" + postitoimipaikka + "]";
	}

}
