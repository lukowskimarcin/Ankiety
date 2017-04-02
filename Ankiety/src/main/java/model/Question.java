package model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
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
	private ObservableList<String> options = FXCollections.observableList(new ArrayList<>());

	/**
	 * Kolor przypisany do pytania
	 */
	private ObjectProperty<Color> color = new SimpleObjectProperty<>();

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

	public final ObservableList<String> getOptions() {
		return options;
	}

	public final void setOptions(List<String> list) {
		options.clear();
		options.addAll(list);
	}

	public ObjectProperty<Color> colorProperty() {
		return color;
	}

	public final Color getColor() {
		return color.get();
	}

	public final void setColor(Color color) {
		this.color.set(color);
	}

	@Override
	public Question clone() throws CloneNotSupportedException {
		Question copy = new Question();

		if (getQuestion() != null)
			copy.setQuestion(getQuestion());

		copy.setType(getType());

		if (getRequired() != null)
			copy.setRequired(getRequired());

		List<String> copyList = new ArrayList<>();
		for (String s : getOptions()) {
			copyList.add(s);
		}

		copy.setOptions(copyList);

		if (getColor() != null)
			copy.setColor(getColor());

		return copy;
	}
}
