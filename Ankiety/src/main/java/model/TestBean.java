package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestBean implements Cloneable {
	private String name;	
	private StringProperty question = new SimpleStringProperty();
	
	
	public TestBean() {}

	public TestBean(TestBean src) {
		name = src.getName();
		question.set(src.getName());
	}
	 
	
	
	public StringProperty questionProperty() {
		return question;
	}

	public final String getQuestion() {
		return question.get();
	}

	public final void setQuestion(String question) {
		this.question.set(question);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public TestBean clone() throws CloneNotSupportedException {
		TestBean copy = (TestBean)super.clone();		
		copy.setQuestion( new String(copy.getQuestion()) );
		
		return  copy;
	}
}
