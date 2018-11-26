package unidades;

import areaJuego.Posicion;
import turnos.Jugador;

public class FabricaAldeanos {

	public Aldeano crearAldeano(Posicion posicion, Jugador jugador) {
		Aldeano aldeano = new Aldeano();
		aldeano.cambiarPosicion(posicion);
		aldeano.cambiarJugador(jugador);
		return aldeano;
	}

}
