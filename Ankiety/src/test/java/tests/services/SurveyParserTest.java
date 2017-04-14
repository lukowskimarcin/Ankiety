package tests.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.crawler.IWebCrawler;
import org.crawler.imp.CrawlTask;
import org.crawler.imp.WebCrawler;
import org.junit.Test;

import model.Question;
import services.GoogleFormsCrawlTask;
import services.SurveyParserImpl;

public class SurveyParserTest {
	 
	private SurveyParserImpl service = new SurveyParserImpl();
	private IWebCrawler crawlerMock;
 
	
	private class GoogleFormsCrawlTaskStub extends GoogleFormsCrawlTask {
		private static final long serialVersionUID = 1L;

		public GoogleFormsCrawlTaskStub(String url, List<Question> result) {
			super(url, result);
		}
		
		@Override
		public void parse() throws Exception {
			Question question = new Question();
			question.setQuestion("Pytanie 1");
			
			getQuestions().add(question);
		}
	}
	
	private class WebCrawlerStub extends WebCrawler {
		public WebCrawlerStub() {
			super(1);
		}
		
		@Override
		public void addTask(CrawlTask task) {
			GoogleFormsCrawlTask tmp = (GoogleFormsCrawlTask)task;
			super.addTask(new GoogleFormsCrawlTaskStub(task.getUrl(), tmp.getQuestions()));
		}
	}
	

	@Test 
	public void testParseNotNullResult()   {
		crawlerMock = new WebCrawlerStub();
		service.setCrawler(crawlerMock);

		List<Question> result = service.parse("http://test");
		
		assertNotNull(result);
		assertEquals("Pytanie 1", result.get(0).getQuestion());
	}

}
