package controlers;

import org.springframework.beans.factory.annotation.Autowired;

import fxbase.AbstractView;
import fxbase.FXMLView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;

@FXMLView(value = "/fxml/Menu.fxml", bundle = "/bundle/messages")
public class MenuControler extends AbstractView {
	@Autowired
	private App app;

	@Autowired
	private AboutControler aboutView;

	@FXML
	private MenuItem mClose;

	@FXML
	private MenuItem mAbout;

	@FXML
	void onAbout(ActionEvent event) {
		// AboutControler aboutView = this.loadView(AboutControler.class);

		aboutView.setTitle(bundle.getString("title"));
		aboutView.initOwner(app.getStage()).initModality(Modality.WINDOW_MODAL).center().showAndWait();
	}

	@FXML
	void onClose(ActionEvent event) {
		Platform.exit();
	}
}
