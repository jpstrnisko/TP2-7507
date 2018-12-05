package vistaAcciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {
	Stage stage;
	
	public OpcionAcercaDeEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.initOwner(this.stage);
		alerta.setTitle("Acerca de...");
		alerta.setHeaderText("TP2 AlgoEmpires Algoritmos y Programacion III.");
		alerta.setContentText("Grupo formado por:\n" + 
				"\n" + 
				"Norese, Florencia; Strnisko, Juan Pablo; Stroia, Lautaro; Suarez, Martin.");
		alerta.show();
	}

}
