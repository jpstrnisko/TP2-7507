package vistaAcciones;

import edificios.Castillo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonCrearArmaDeAsedioHandler implements EventHandler<ActionEvent> {
	
	Castillo seleccionada;

	public BotonCrearArmaDeAsedioHandler(Juego modelo, Castillo seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.comenzarProduccionArmaDeAsedio();
	}

}