package vistaAcciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;
import unidades.ArmaDeAsedio;

public class BotonDesmontarArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {
	
	ArmaDeAsedio seleccionada;

	public BotonDesmontarArmaDeAsedioEventHandler(Juego modelo, ArmaDeAsedio seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.desmontar();
	}

}