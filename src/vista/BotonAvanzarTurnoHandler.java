package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import juego.Juego;

public class BotonAvanzarTurnoHandler implements EventHandler<ActionEvent> {
	
	Juego modelo;
	VistaModelo ventanaAActualizar;
	VentanaInicial ventana;

	public BotonAvanzarTurnoHandler(VistaModelo vistaModelo, VentanaInicial ventana, Juego modelo) {
		ventanaAActualizar = vistaModelo;
		this.modelo = modelo;
		this.ventana = ventana;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			modelo.avanzarTurno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ventana.seleccionado = null;
		ventana.seleccionadoSecundario = null;
		ventana.posicionPrimaria = null;
		ventana.posicionSecundaria = null;
		try {
			ventana.setControles(modelo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ventanaAActualizar.dibujar();
	}

}
