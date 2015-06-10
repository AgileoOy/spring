package fi.agileo.spring.e15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.agileo.spring.e15.bean.Henkilo;
@Repository
public class HenkiloDAOSpringJdbcImpl implements HenkiloDAO {
		
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan.
	 * Tietokannan generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Henkilo h) {
		final String sql = "insert into henkilo2(etunimi, sukunimi, sahkoposti, lahiosoite, postinumero, postitoimipaikka) values(?,?,?,?,?,?)";
		
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		final String etunimi = h.getEtunimi();
		final String sukunimi = h.getSukunimi();
		final String sahkoposti = h.getSahkoposti();
		final String lahiosoite = h.getLahiosoite();
		final String postinumero = h.getPostinumero();
		final String postitoimipaikka = h.getPostitoimipaikka();
		
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, etunimi);
	    	            ps.setString(2, sukunimi);
	    	            ps.setString(3, sahkoposti);
	    	            ps.setString(4, lahiosoite);
	    	            ps.setString(5, postinumero);
	    	            ps.setString(6, postitoimipaikka);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pitäisi olla viittaus samaiseen olioon
	    h.setId(idHolder.getKey().intValue());

	}
	

	public Henkilo etsi(int id) {
		String sql = "select etunimi, sukunimi, id, sahkoposti, lahiosoite, postinumero, postitoimipaikka from henkilo2 where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		
	    Henkilo h;
	    try { 
	    h = jdbcTemplate.queryForObject(sql , parametrit, mapper);
	    } catch(IncorrectResultSizeDataAccessException e) {
	    	throw new HenkiloaEiLoydyPoikkeus(e);
	    }
	    return h;
	                                  

	}
	

	public List<Henkilo> haeKaikki() {
		
		String sql = "select id, etunimi, sukunimi, sahkoposti, lahiosoite, postinumero, postitoimipaikka from henkilo2";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql,mapper);

		return henkilot;
	}
}
