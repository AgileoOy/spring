package fi.agileo.spring.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		return "<!DOCTYPE html>\n<html><body>Hello World!</body></html>";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloWorldController.class, args);
	}
}