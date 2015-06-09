package fi.agileo.spring.e11;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fi.agileo.spring.e11.kello.InternetKelloLahdeTest;
import fi.agileo.spring.e11.kello.SuomiKelloTest;
import fi.agileo.spring.e11.laskin.LaskinTest;

@RunWith(Suite.class)
@SuiteClasses({
	LaskinTest.class,
	SuomiKelloTest.class,
	InternetKelloLahdeTest.class
	})
public class AllTests {
}