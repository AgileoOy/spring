package fi.agileo.spring.e13.dao;

import java.util.List;

import fi.agileo.spring.e13.bean.Henkilo;

public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);

	public abstract Henkilo etsi(int id);

	public abstract List<Henkilo> haeKaikki();

}