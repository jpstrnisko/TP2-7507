package unidades;

import areaJuego.Posicion;
import juego.Juego;
import turnos.Jugador;

public class FabricaAldeano {

	public Aldeano crearAldeano(Posicion posicion, Jugador jugador) throws Exception {
		Juego juego = Juego.obtenerInstancia();
		Aldeano aldeano = new Aldeano();
		aldeano.establecerPosicion(posicion);
		aldeano.cambiarJugador(jugador);
		juego.obtenerMapa().colocarAtacable(aldeano.obtenerPosicion(), aldeano);
		return aldeano;
	}

}
