package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonAvanzarTurnoHandler implements EventHandler<ActionEvent> {
	
	Juego modelo;
	VistaModelo ventanaAActualizar;

	public BotonAvanzarTurnoHandler(VistaModelo vistaModelo, Juego modelo) {
		ventanaAActualizar = vistaModelo;
		this.modelo = modelo;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			modelo.avanzarTurno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ventanaAActualizar.dibujar();
	}

}
