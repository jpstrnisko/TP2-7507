package vistaAcciones;

import edificios.Cuartel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonCrearEspadachinHandler implements EventHandler<ActionEvent> {
	
	Cuartel seleccionado;

	public BotonCrearEspadachinHandler(Juego modelo, Cuartel seleccionado) {
		this.seleccionado = seleccionado;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionado.comenzarProduccionEspadachin();
	}

}
