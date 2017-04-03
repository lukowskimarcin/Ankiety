package services;
import java.util.List;

import org.crawler.imp.CrawlTask;

import model.Question;


public class GoogleFormsCrawlTask extends CrawlTask {
	private static final long serialVersionUID = 1L;
	
	public GoogleFormsCrawlTask(String url, List<Question> result) {
		super(url);
	}

	@Override
	public void process() {

	}

	@Override
	public void parse() throws Exception {
		// TODO Auto-generated method stub

	}

}
