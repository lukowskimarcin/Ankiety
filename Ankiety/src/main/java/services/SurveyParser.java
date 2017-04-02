package services;

import java.util.List;

import model.Question;

public interface SurveyParser {

	List<Question> parse(String url);
}
