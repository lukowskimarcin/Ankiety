package model;


import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Czy wymagane
	 */
	private BooleanProperty required = new SimpleBooleanProperty();
	
	
	/**
	 * Opcje mozliwe do wybrania
	 */
	private List<StringProperty> options = new ArrayList<>();
	
	
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
	
	
	public List<StringProperty> optionsProperty() {
		return options;
	}

	public final List<String> getOptions() {
		List<String> tmp = new ArrayList<>();
		for(StringProperty sp : options) {
			tmp.add(sp.get());
		}
		
		return tmp;
	}

	public final void setOptions(List<String> list) {
		options.clear();
		for(String s : list) {
			options.add(new SimpleStringProperty(s));
		}
	}
	
	
	@Override
	public Question clone() throws CloneNotSupportedException {
		Question copy = new Question();
		
		if(getQuestion()!=null)
			copy.setQuestion(new String(getQuestion()));
		
		copy.setType(getType());
		
		if(getRequired()!=null)
			copy.setRequired(new Boolean(getRequired()));
		
		
		if(getOptions()!=null) {
			List<String> tmp = new ArrayList<>();
			for(String s : getOptions()){
				tmp.add(new String(s));
			}
			copy.setOptions(tmp);
		}
		
		return copy;
	}

	
}
