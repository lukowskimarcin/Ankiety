package tests.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.crawler.IWebCrawler;
import org.crawler.imp.CrawlTask;
import org.crawler.imp.WebCrawler;
import org.junit.Test;

import model.Question;
import model.enums.QuestionType;
import services.GoogleFormsCrawlTask;
import services.SurveyParserImpl;

public class SurveyParserTest {
	 
	private SurveyParserImpl service = new SurveyParserImpl();
	
	private IWebCrawler crawlerMock;
	
	
	class TestCrawler extends WebCrawler {
		public TestCrawler() {
			super(10);
		}
		
		@Override
		public BlockingQueue<CrawlTask> getCompletePages() 
		{
			List<Question> list = new ArrayList<>();
			Question question = new Question();
			question.setQuestion("Pytanie 1");
			question.setType(QuestionType.CHECKBOXES);
			List<String>  options = new ArrayList<>();
			options.add("Opcja 1");
			options.add("Opcja 2");			  
			
			question.setOptions(new ArrayList<String>());
			
			list.add(question);
			
			GoogleFormsCrawlTask t = new GoogleFormsCrawlTask("test");
			t.setData(list);
			
			BlockingQueue<CrawlTask> queue =  new LinkedBlockingQueue<CrawlTask>();
			queue.add(t);
			
			return queue;
		}
		
	}

	@Test 
	public void testParseNotNullResult()   {
		crawlerMock = new TestCrawler();
		service.setCrawler(crawlerMock);
		
		List<Question> result = service.parse("http://test");
		assertNotNull(result);
		
		assertEquals("Pytanie 1", result.get(0).getQuestion());
		
	}

}
