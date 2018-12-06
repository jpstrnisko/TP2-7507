package vistaAcciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;
import unidades.ArmaDeAsedio;

public class BotonMontarArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {
	
	ArmaDeAsedio seleccionada;

	public BotonMontarArmaDeAsedioEventHandler(Juego modelo, ArmaDeAsedio seleccionada) {
		this.seleccionada = seleccionada;
	}

	@Override
	public void handle(ActionEvent event) {
		seleccionada.montar();
	}

}