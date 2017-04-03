package services;

import java.util.ArrayList;
import java.util.List;

import org.crawler.IWebCrawler;
import org.crawler.imp.CrawlTask;
import org.springframework.beans.factory.annotation.Autowired;

import model.Question;

public class SurveyParserImpl implements SurveyParser {
	
	@Autowired 
	private IWebCrawler crawler;
	
	public IWebCrawler getCrawler() {
		return crawler;
	}

	public void setCrawler(IWebCrawler crawler) {
		this.crawler = crawler;
	}
	
	public List<Question> parse(String url) {
		List<Question> result = new ArrayList<>();
		CrawlTask task = new GoogleFormsCrawlTask(url, result);
		
		crawler.addTask(task);
		crawler.waitUntilFinish();
		
		for(CrawlTask t : crawler.getCompletePages()) {
			t.process();
		}
		
		return result;
	}


}
