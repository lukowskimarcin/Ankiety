package services;
import java.util.List;

import org.crawler.imp.CrawlTask;

import model.Question;

/**
 * Zadanie do parsowanie ankiety
 * @author Marcin
 *
 */
public class GoogleFormsCrawlTask extends CrawlTask {
	private static final long serialVersionUID = 1L;
	private List<Question> questions;

	/**
	 * 
	 * @param url:	adres ankiety
	 * @param questions:	lista do której zostaną zapisane znalezione pytania
	 */
	public GoogleFormsCrawlTask(String url, List<Question> questions) {
		super(url);
		this.questions = questions;
	}
	 

	@Override
	public void parse() throws Exception {

	}
	
	public final List<Question> getQuestions(){
		return questions;
	}
	

}
