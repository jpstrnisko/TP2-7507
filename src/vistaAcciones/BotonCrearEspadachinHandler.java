package vistaAcciones;

import edificios.Cuartel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonCrearEspadachinHandler implements EventHandler<ActionEvent> {
	
	Cuartel seleccionada;

	public BotonCrearEspadachinHandler(Juego modelo, Cuartel seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.comenzarProduccionEspadachin();
	}

}