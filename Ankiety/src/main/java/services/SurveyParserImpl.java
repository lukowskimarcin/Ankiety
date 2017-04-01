package services;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.crawler.consumer.IConsumer;
import org.crawler.imp.WebCrawler;
import org.springframework.beans.factory.annotation.Autowired;

import model.Question;

public class SurveyParserImpl implements SurveyParser {
	
	@Autowired 
	private WebCrawler crawler;
	
	@Autowired 
	private IConsumer consumer;
	

	public List<Question> parse(URL url) throws Exception {
		List<Question> result = new ArrayList<Question>();
		
		return result;
	}

}
