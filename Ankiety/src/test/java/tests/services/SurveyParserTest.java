package tests.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.stubbing.Answer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.crawler.IWebCrawler;
import org.crawler.imp.CrawlTask;
import org.crawler.imp.WebCrawler;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import model.Question;
import model.enums.QuestionType;
import services.GoogleFormsCrawlTask;
import services.SurveyParserImpl;

public class SurveyParserTest {
	 
	private SurveyParserImpl service = new SurveyParserImpl();
	
	private IWebCrawler crawlerMock;
 
	
	private class GoogleFormsCrawlTaskMock extends GoogleFormsCrawlTask {
		List<Question> list;
		
		public GoogleFormsCrawlTaskMock(String url, List<Question> result) {
			super(url, result);
			list = result;
		}

  	    @Override
		public void process() {
  			Question question = new Question();
  			question.setQuestion("Pytanie 1");
  			question.setType(QuestionType.CHECKBOXES);
  			List<String>  options = new ArrayList<>();
  			options.add("Opcja 1");
  			options.add("Opcja 2");			  
  			
  			question.setOptions(new ArrayList<String>());
  			list.add(question);
		}
	}
	 
	

	@Test 
	public void testParseNotNullResult()   {
		List<Question> test = new ArrayList<>();
		GoogleFormsCrawlTask taskStub = new GoogleFormsCrawlTaskMock("test", test);
		
		BlockingQueue<CrawlTask> queue =  new LinkedBlockingQueue<CrawlTask>();
		queue.add(taskStub);
		
		crawlerMock = mock(WebCrawler.class);
		when(crawlerMock.getCompletePages()).thenReturn(queue);
		service.setCrawler(crawlerMock);
		

		List<Question> result = service.parse("http://test");
		assertNotNull(result);
		assertEquals("Pytanie 1", result.get(0).getQuestion());
	}

}
