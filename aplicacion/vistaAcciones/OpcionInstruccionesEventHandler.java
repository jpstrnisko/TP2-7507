package vistaAcciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import juego.Juego;

public class OpcionInstruccionesEventHandler implements EventHandler<ActionEvent> {
	
	Stage stage;
	
	public OpcionInstruccionesEventHandler(Stage stage) {
		this.stage = stage;
				
	}

	@Override
	public void handle(ActionEvent event) {
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.initOwner(this.stage);
		alerta.setTitle("Ayuda");
		alerta.setHeaderText("Instrucciones sobre AlgoEmpires II.");
		alerta.setContentText("* Objetivo principal: Destruir el castillo enemigo.\n" +
		"*Al iniciar el juego, se le otorga a cada jugador:\n" + 
				"-Una plaza central;\n -Un castillo;\n -3 aldeanos;\n -100 de oro.\n"+
		"*Los aldeanos solo construyen cuarteles y plazas centrales.\n" + 
		"*Los cuarteles pueden crear espadachines y arqueros.\n" +
		"*Las plazas centrales solo pueden crear aldeanos.\n" +
		"*PARA MOVER UNA UNIDAD (UNA VEZ POR TURNO):\n" +
				"-Seleccionar con click derecho la unidad, y con click izquierdo la posicion a mover.\n");
		alerta.show();
	}

}
