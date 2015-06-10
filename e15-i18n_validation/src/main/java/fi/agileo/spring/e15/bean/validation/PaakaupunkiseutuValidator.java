package fi.agileo.spring.e15.bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaakaupunkiseutuValidator implements
		ConstraintValidator<Paakaupunkiseutu, String> {

	public void initialize(Paakaupunkiseutu paakaupunkiseutu) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return value.equalsIgnoreCase("Helsinki")
				|| value.equalsIgnoreCase("Espoo")
				|| value.equalsIgnoreCase("Vantaa")
				|| value.equalsIgnoreCase("Kauniainen");
	}
}