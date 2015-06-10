package fi.agileo.spring.e16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String paasivu(Model model) {
		return "secure/main";
	}

}
