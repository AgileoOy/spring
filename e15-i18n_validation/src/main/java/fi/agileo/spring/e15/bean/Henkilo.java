package fi.agileo.spring.e15.bean;

//standardeja jsr303-annotaatioita
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//hibernatevalidaattorin oma annotaatio
import org.hibernate.validator.constraints.Email;
//itse tehty validaattoriannotaatio

import fi.agileo.spring.e15.bean.validation.Paakaupunkiseutu;

public class Henkilo {

	private int id;

	@Size(min = 1, max = 255)
	private String etunimi;

	@Size(min = 1, max = 255)
	private String sukunimi;

	@Size(min = 1, max = 255)
	@Email
	private String sahkoposti;

	@Size(min = 1, max = 255)
	private String lahiosoite;

	@Pattern(regexp = "\\d{5}")
	private String postinumero;

	@Size(min = 1, max = 255)
	@Paakaupunkiseutu
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
		return "Henkilo [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", sahkoposti=" + sahkoposti + ", lahiosoite="
				+ lahiosoite + ", postinumero=" + postinumero
				+ ", postitoimipaikka=" + postitoimipaikka + "]";
	}

}
