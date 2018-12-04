package vistaAcciones;

import edificios.PlazaCentral;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonCrearAldeanoHandler implements EventHandler<ActionEvent> {
	
	PlazaCentral seleccionada;

	public BotonCrearAldeanoHandler(Juego modelo, PlazaCentral seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.comenzarProduccionAldeano();
	}

}