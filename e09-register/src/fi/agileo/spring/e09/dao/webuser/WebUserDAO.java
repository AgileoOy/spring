package fi.agileo.spring.e09.dao.webuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fi.agileo.spring.e09.bean.WebUser;
import fi.agileo.spring.e09.dao.DAO;
import fi.agileo.spring.e09.dao.DAOPoikkeus;

public class WebUserDAO extends DAO {

	public WebUserDAO() throws DAOPoikkeus {
		super();
	}

	/**
	 * Lisää uuden webuserin tietokantaan
	 * @param kayttaja uuden webuserin tiedot
	 * @throws UsernameVarattuPoikkeus Mikäli tietokannasta löytyy jo käyttäjä samalla usernamella
	 * @throws DAOPoikkeus Mikäli tietokantahaussa tapahtuu virhe
	 */
	public void lisaa(WebUser kayttaja) throws UsernameVarattuPoikkeus, DAOPoikkeus {
		Connection yhteys = avaaYhteys();
		
		try {
			
			//tarkistetaan, että usernamella ei jo löydy käyttäjää
			PreparedStatement usernameHaku = yhteys.prepareStatement("select id from webuser where username = ?");
			usernameHaku.setString(1, kayttaja.getUsername());
			ResultSet rs = usernameHaku.executeQuery();
			if(rs.next())
				throw new UsernameVarattuPoikkeus();
			
			//suoritetaan lisäys
			PreparedStatement insertLause = yhteys.prepareStatement("insert into webuser(username, password_hash, salt) values(?,?,?)");
			insertLause.setString(1, kayttaja.getUsername());
			insertLause.setString(2, kayttaja.getPasswordHash());
			insertLause.setString(3, kayttaja.getSalt());
			
			insertLause.executeUpdate();
			
		} catch(SQLException e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}
		
	}

}
