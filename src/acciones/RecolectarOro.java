package acciones;

import interfaces.Accion;
import unidades.Aldeano;

public class RecolectarOro implements Accion {
	private static int cantidadDeOro = 20;
	private Aldeano aldeano;
	
	public RecolectarOro(Aldeano aldeano) {
		this.aldeano = aldeano;
	}
	
	
	public void hacer() {
		this.aldeano.obtenerJugador().aumentarOro(cantidadDeOro);
	}

}
