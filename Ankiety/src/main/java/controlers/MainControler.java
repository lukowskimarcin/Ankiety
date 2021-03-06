package controlers;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import fxbase.AbstractView;
import fxbase.FXMLView;
import javafx.scene.layout.BorderPane;

@FXMLView(fxml="/fxml/Main.fxml", bundle="/bundle/messages")
public class MainControler extends AbstractView {
	
	@Autowired
	private MenuControler menu;
	
	@PostConstruct
	private void init(){
		setTitle(bundle.getString("title"));
		BorderPane pane = (BorderPane)getView();
		pane.setTop(menu.getView());
	}
	
	
	public void setCenter(AbstractView node){
		BorderPane pane = (BorderPane)getView();
		pane.setCenter(node.getView());
		
	}

}
