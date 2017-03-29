package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.enums.QuestionType;

/**
 * Klasa reprezentująca pojedyńcze pytanie z ankiety
 * 
 * @author Marcin
 *
 */
public class Question implements Cloneable {

	/**
	 * Treść pytania
	 */
	private StringProperty question = new SimpleStringProperty();

	/** 
	 * Typ pytania
	 */
	private QuestionType type;

	private BooleanProperty required = new SimpleBooleanProperty();
	
	
	public StringProperty questionProperty() {
		return question;
	}

	public final String getQuestion() {
		return question.get();
	}

	public final void setQuestion(String question) {
		this.question.set(question);
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}
	
	public BooleanProperty requiredProperty() {
		return required;
	}

	public final Boolean getRequired() {
		return required.get();
	}

	public final void setRequired(Boolean question) {
		this.required.set(question);
	}
	
	@Override
	public Question clone() throws CloneNotSupportedException {
		Question copy = new Question();
		
		if(getQuestion()!=null)
			copy.setQuestion(new String(getQuestion()));
		
		copy.setType(getType());
		
		if(getRequired()!=null)
			copy.setRequired(new Boolean(getRequired()));
		
		return copy;
	}

	
}
