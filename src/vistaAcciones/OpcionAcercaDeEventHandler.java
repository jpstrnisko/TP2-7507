package vistaAcciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Acerca de...");
		alerta.setHeaderText("Ejmplo");
		alerta.setContentText("TP2 AlgoEmpires Algoritmos y Programacion III.");
		alerta.show();
	}

}
