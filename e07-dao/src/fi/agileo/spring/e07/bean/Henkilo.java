package fi.agileo.spring.e07.bean;

public class Henkilo {
	
	private int id;
	private String etunimi;
	private String sukunimi;
	
	public Henkilo(int id, String etunimi, String sukunimi) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
	}
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
	@Override
	public String toString() {
		return "Henkilo [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + "]";
	}

	
}