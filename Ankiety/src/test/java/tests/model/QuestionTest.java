package tests.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.scene.paint.Color;
import model.Question;
import model.QuestionType;

public class QuestionTest {

	@Test
	public void testClone() throws CloneNotSupportedException {
		Question q1 = new Question();
		q1.setType(QuestionType.MULTIPLE_CHOICE);
		q1.setRequired(true);
		q1.setQuestion("Pytanie");
		List<String> list = new ArrayList<>();
		list.add("opcja 1");
		list.add("opcja 2");
		q1.setOptions(list);
		q1.setColor(Color.WHITE);

		Question q2 = q1.clone();
		assertNotSame(q1, q2);

		assertEquals(q1.getQuestion(), q2.getQuestion());
		assertEquals(q1.getRequired(), q2.getRequired());
		assertEquals(q1.getType(), q2.getType());
		assertEquals(q1.getOptions(), q2.getOptions());
		
		assertEquals(q1.getColor(),	q2.getColor());
	}

	@Test
	public void testCloneEditQuestion() throws CloneNotSupportedException {
		Question q1 = new Question();
		q1.setQuestion("Pytanie 1");

		Question q2 = q1.clone();
		q2.setQuestion("Pytanie 2");

		assertNotEquals(q1.getQuestion(), q2.getQuestion());
		assertEquals("Pytanie 1", q1.getQuestion());
		assertEquals("Pytanie 2", q2.getQuestion());
	}

	@Test
	public void testCloneEditType() throws CloneNotSupportedException {
		Question q1 = new Question();
		q1.setType(QuestionType.MULTIPLE_CHOICE);

		Question q2 = q1.clone();
		q2.setType(QuestionType.CHECKBOXES);

		assertNotEquals(q1.getType(), q2.getType());
		assertEquals(QuestionType.MULTIPLE_CHOICE, q1.getType());
		assertEquals(QuestionType.CHECKBOXES, q2.getType());
	}

	@Test
	public void testCloneEditRequired() throws CloneNotSupportedException {
		Question q1 = new Question();
		q1.setRequired(false);

		Question q2 = q1.clone();
		q2.setRequired(true);

		assertNotEquals(q1.getRequired(), q2.getRequired());
	}
	
	@Test
	public void testCloneOptions() throws CloneNotSupportedException {
		Question q1 = new Question();
		List<String> list = new ArrayList<>();
		list.add("opcja 1");
		list.add("opcja 2");
		q1.setOptions(list);

		Question q2 = q1.clone();
		 
		assertEquals(q1.getOptions(), q2.getOptions());
	}
	
	@Test
	public void testCloneEditOptions() throws CloneNotSupportedException {
		Question q1 = new Question();
		List<String> list = new ArrayList<>();
		list.add("opcja 1");
		list.add("opcja 2");
		q1.setOptions(list);

		Question q2 = q1.clone();
		q2.getOptions().set(1, "opcja 3");
		
		assertEquals("opcja 1", q1.getOptions().get(0));
		assertEquals("opcja 2", q1.getOptions().get(1));
		
		assertEquals("opcja 1", q2.getOptions().get(0));
		assertEquals("opcja 3", q2.getOptions().get(1));
	}
	
	@Test
	public void testCloneAddOptions() throws CloneNotSupportedException {
		Question q1 = new Question();
		List<String> list = new ArrayList<>();
		list.add("opcja 1");
		list.add("opcja 2");
		q1.setOptions(list);

		Question q2 = q1.clone();
		q2.getOptions().add("opcja 3");
		
		assertEquals(2, q1.getOptions().size());
		assertEquals(3, q2.getOptions().size());
	}

	@Test
	public void testEditColor() throws CloneNotSupportedException {
		Question q1 = new Question();
		q1.setColor(Color.RED);

		Question q2 = q1.clone();
		q2.setColor(Color.GREEN); 
		
		assertEquals(Color.RED, q1.getColor());
		assertEquals(Color.GREEN, q2.getColor());
	}

}
