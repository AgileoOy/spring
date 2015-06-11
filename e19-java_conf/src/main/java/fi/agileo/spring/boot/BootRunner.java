package fi.agileo.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"fi.agileo.spring"})
public class BootRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootRunner.class, args);
	}
}