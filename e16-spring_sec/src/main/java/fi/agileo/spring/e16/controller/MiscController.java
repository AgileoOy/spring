package fi.agileo.spring.e16.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.agileo.spring.e16.service.MiscService;

@Controller
@RequestMapping (value="misc")
public class MiscController {

	@Inject
	private MiscService miscService;
	
	public MiscService getMiscService() {
		return miscService;
	}

	public void setMiscService(MiscService miscService) {
		this.miscService = miscService;
	}
	

	@RequestMapping(value = "/admineille", method = RequestMethod.GET)
	public String vainAdmineille(Model model) {
		miscService.palveluAdmineille();
		model.addAttribute("viesti", "Lisäsivu admineille");
		return "misc";
	}
	
	@RequestMapping(value = "/sisaankirjautuneille", method = RequestMethod.GET)
	public String vainSisaankirjautuneille(Model model) {
		miscService.palveluSisaankirjautuneille();
		model.addAttribute("viesti", "Lisäsivu sisäänkirjautuneille");
		return "misc";
	}
	
	@RequestMapping(value = "/kaikille", method = RequestMethod.GET)
	public String kaikille(Model model) {
		miscService.palveluKaikille();
		model.addAttribute("viesti", "Lisäsivu kaikille");
		return "misc";
	}
	
	
}
