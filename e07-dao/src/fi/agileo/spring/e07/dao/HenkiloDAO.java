package fi.agileo.spring.e07.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.agileo.spring.e07.bean.Henkilo;

public class HenkiloDAO {
	
	public List<Henkilo> haeKaikki() {
		
		
		ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
		
		Connection yhteys = null;
		
		try {
			//YHTEYDEN AVAUS JA HAKU
			//ajurin lataus
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			//avataan yhteys
			yhteys = DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
			
			//suoritetaan haku
			String sql = "select id, etunimi, sukunimi from henkilo";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				int id = tulokset.getInt("id");
				String etunimi = tulokset.getString("etunimi");
				String sukunimi = tulokset.getString("sukunimi");
				
				//lisätään henkilö listaan
				Henkilo h = new Henkilo(id, etunimi, sukunimi);
				henkilot.add(h);
			}
		} catch(IOException e) {
			System.out.println("Tietokantayhteyden asetuksien hakeminen aiheutti virheen.");
			e.printStackTrace();
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
			e.printStackTrace();
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch(Exception e) {
				System.out.println("Tietokantayhteys ei jostain syystä suostu menemään kiinni.");
				e.printStackTrace();
			}
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA HENKILÖT: " +henkilot.toString());
		return henkilot;
	}

}
