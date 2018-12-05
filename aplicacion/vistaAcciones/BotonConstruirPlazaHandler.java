package vistaAcciones;

import edificios.Cuartel;
import edificios.PlazaCentral;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;
import unidades.Aldeano;
import vista.VentanaInicial;

public class BotonConstruirPlazaHandler implements EventHandler<ActionEvent> {
	
	VentanaInicial ventanaInicial;
	Aldeano constructor;
	Juego modelo;

	public BotonConstruirPlazaHandler(VentanaInicial ventanaInicial, Juego modelo, Aldeano seleccionado) {
		this.ventanaInicial = ventanaInicial;
		constructor = seleccionado;
		this.modelo = modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		ventanaInicial.setEdificioConstruir(new PlazaCentral());
	}
}
