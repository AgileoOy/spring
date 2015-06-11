package fi.agileo.spring.e14.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.agileo.spring.e14.bean.Henkilo;

public class HenkiloRowMapper implements RowMapper<Henkilo> {

	public Henkilo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Henkilo h = new Henkilo();
		h.setEtunimi(rs.getString("etunimi"));
		h.setSukunimi(rs.getString("sukunimi"));
		h.setId(rs.getInt("id"));
		
		return h;
	}

}
