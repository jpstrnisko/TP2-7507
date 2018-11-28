package acciones;

import interfaces.Accion;
import unidades.Unidad;

public class RecolectarOro implements Accion {
	private static int cantidadDeOro = 20;
	
	public void hacer(Unidad unidad) {
		unidad.obtenerJugador().aumentarOro(cantidadDeOro);
	}

}
