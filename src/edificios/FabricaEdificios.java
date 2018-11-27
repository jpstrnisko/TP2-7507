package edificios;

import areaJuego.Posicion;
import juego.Juego;
import turnos.Jugador;

public class FabricaEdificios {
	public Edificio crearEdificio(Class clase, Posicion posicion, Jugador jugador) throws Exception {
		Juego juego = Juego.obtenerInstancia();
		Edificio edificio = (Edificio) clase.newInstance();
		edificio.establecerPosicion(posicion);
		edificio.cambiarJugador(jugador);
		juego.obtenerMapa().colocarAtacable(edificio.obtenerPosicionInicial(), edificio);
		return edificio;
	}
}
