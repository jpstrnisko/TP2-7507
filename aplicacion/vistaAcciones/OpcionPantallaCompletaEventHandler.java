package vistaAcciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {
	
	Stage stage;
	MenuItem opcionPantallaCompleta;
	
	public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta) {
		this.stage = stage;
		this.opcionPantallaCompleta = opcionPantallaCompleta;
		
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		if(!stage.isFullScreen()) {
			stage.hide();
			stage.setFullScreen(true);
			opcionPantallaCompleta.setDisable(true);
			stage.show();
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.initOwner(this.stage);
			alerta.setTitle("Pantalla Completa");
			alerta.setHeaderText("");
			alerta.setContentText("Para salir del modo pantalla completa presione la tecla Esc.");
			alerta.show();
		}
	}
	
}
