package controlers;

import org.springframework.context.annotation.Scope;

import fxbase.AbstractSeparateView;
import fxbase.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Scope("prototype")
@FXMLView(value="/fxml/About.fxml", bundle="/bundle/messages")
public class AboutControler extends AbstractSeparateView {
	@FXML
    private Button bOk;

    @FXML
    void onAction(ActionEvent event) {
    	 close();
    }
}
