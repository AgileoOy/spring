package fi.agileo.spring.e12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aloittaja {

	final static Logger logger = LoggerFactory.getLogger(Aloittaja.class);
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		logger.info("Aloitellaan ohjelmaa.");
		
		
		logger.debug("ladataan application context");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");
		
		System.out.println(context.getBean("auto"));
		System.out.println(context.getBean("auto"));
		
		logger.debug("suljetaan application context");
		context.close();
		
		
		logger.info("Ohjelman suoritus päättyi.");
	}

}
