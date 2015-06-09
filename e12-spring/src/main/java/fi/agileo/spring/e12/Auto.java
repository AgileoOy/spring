package fi.agileo.spring.e12;

public class Auto {
	
	String nimi;
	Jalka[] jalat;

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setJalat(Jalka[] jalat) {
		this.jalat = jalat;
	}
	

	public String toString() {
		String out = this.nimi;
		for (Jalka j : jalat) {
			out+=j;
		}
		out +=" ("+super.toString()+")";
		return out;
	}
}
