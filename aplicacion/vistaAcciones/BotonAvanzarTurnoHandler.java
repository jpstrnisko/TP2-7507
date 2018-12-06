package vistaAcciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import juego.Juego;
import vista.VentanaInicial;
import vista.VistaModelo;

public class BotonAvanzarTurnoHandler extends Button implements EventHandler<ActionEvent> {
	
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
