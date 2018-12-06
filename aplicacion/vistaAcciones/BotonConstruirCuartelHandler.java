package vistaAcciones;

import edificios.Cuartel;
import interfaces.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import juego.Juego;
import unidades.Aldeano;
import vista.VentanaInicial;
import areaJuego.Posicion;

public class BotonConstruirCuartelHandler implements EventHandler<ActionEvent> {

	VentanaInicial ventanaInicial;
	Aldeano constructor;
	Juego modelo;
	
	
	public BotonConstruirCuartelHandler(VentanaInicial ventanaInicial, Juego modelo, Aldeano seleccionado) {
		this.ventanaInicial = ventanaInicial;
		constructor = seleccionado;
		this.modelo = modelo;
		
	}

	@Override
	public void handle(ActionEvent event) {
		ventanaInicial.setEdificioConstruir(new Cuartel());
	}

}
