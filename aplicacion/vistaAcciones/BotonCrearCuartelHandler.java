package vistaAcciones;

import edificios.Cuartel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;
import vista.VistaModelo;
import areaJuego.Posicion;


public class BotonCrearCuartelHandler implements EventHandler<ActionEvent> {
	
	Juego modelo;
	Posicion posicion;
	VistaModelo ventanaAActualizar;

	public BotonCrearCuartelHandler(VistaModelo ventanaAActualizar,Juego modelo, Posicion posicion) {
		this.modelo = modelo;
		this.posicion = posicion;
		this.ventanaAActualizar = ventanaAActualizar;
	}

	@Override
	public void handle(ActionEvent event) {
		Cuartel nuevoCuartel = new Cuartel();
		modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadorActual()).add(nuevoCuartel);
		nuevoCuartel.establecerPosicion(posicion);
		ventanaAActualizar.dibujar();
	}

}