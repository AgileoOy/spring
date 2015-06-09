package fi.agileo.spring.e13.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.agileo.spring.e13.bean.Henkilo;


public class HenkiloDAOSpringJdbcImpl implements HenkiloDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Henkilo h) {
		String sql = "insert into henkilo(etunimi, sukunimi) values(?,?)";
		Object[] parametrit = new Object[] { h.getEtunimi(), h.getSukunimi() };

		jdbcTemplate.update(sql, parametrit);

	}

	public Henkilo etsi(int id) {
		String sql = "select etunimi, sukunimi, id from henkilo where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();

		Henkilo h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return h;

	}

	public List<Henkilo> haeKaikki() {

		String sql = "select id, etunimi, sukunimi from henkilo";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
	}
}
