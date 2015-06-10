package fi.agileo.spring.e15.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.agileo.spring.e15.bean.Henkilo;
import fi.agileo.spring.e15.dao.HenkiloDAO;


@Controller
@RequestMapping (value="/henkilot")
public class HenkiloController {

	@Inject
	private HenkiloDAO dao;
	
	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
		this.dao = dao;
	}
	
	//FORMIN TEKEMINEN
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Henkilo tyhjaHenkilo = new Henkilo();
		tyhjaHenkilo.setEtunimi("oletusetunimi");
		
		model.addAttribute("henkilo", tyhjaHenkilo);
		return "henk/createForm";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="henkilo") @Valid Henkilo henkilo, BindingResult result) {
		if (result.hasErrors()) {
			return "henk/createForm";
		} else {
			dao.talleta(henkilo);
			return "redirect:/henkilot/" + henkilo.getId();
		}
	}
	
	//HENKILÖN TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);
		return "henk/view";
	}
	
}
