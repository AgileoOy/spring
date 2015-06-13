
package fi.agileo.spring.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller (value="HomeController")
@RequestMapping("VIEW")
public class HomeController {

	@RenderMapping
	public String tervehdys(Model model) {

		String nimi = "maailma";
		model.addAttribute("kenelle", nimi);

		return "home";
	}
	
    @ActionMapping
    public void handleActionRequest(ActionRequest request, ActionResponse response)throws Exception {
        return;
    }

}
