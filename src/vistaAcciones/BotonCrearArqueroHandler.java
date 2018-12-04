package vistaAcciones;

import edificios.Cuartel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonCrearArqueroHandler implements EventHandler<ActionEvent> {
	
	Cuartel seleccionada;

	public BotonCrearArqueroHandler(Juego modelo, Cuartel seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.comenzarProduccionArquero();
	}

}