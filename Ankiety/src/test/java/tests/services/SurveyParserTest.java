package tests.services;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import model.Question;
import services.SurveyParser;
import services.SurveyParserImpl;

public class SurveyParserTest {
	 
	private SurveyParser service = new SurveyParserImpl();
	

	@Test 
	public void testParseNotNullResult() throws MalformedURLException, Exception {
		List<Question> result = service.parse(new URL("http://test"));
		assertNotNull(result);
	}

}
