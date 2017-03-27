package services;

import java.net.URL;
import java.util.List;

import model.Question;

public interface SurveyParser {

	List<Question> parse(URL url) throws Exception;
}
