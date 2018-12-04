package edificios;

import areaJuego.Posicion;
import juego.Juego;
import turnos.Jugador;

public class FabricaEdificios {
	
	public Edificio crearEdificio(Class clase, Posicion posicion, Jugador jugador) throws Exception {
		Juego juego = Juego.obtenerInstancia();
		Edificio edificio = (Edificio) clase.newInstance();
		edificio.establecerPosicion(posicion);
		edificio.establecerVida(0);
		edificio.cambiarJugador(jugador);
		try {
			juego.obtenerMapa().colocarAtacable(edificio.obtenerPosicionInicial(), edificio);
		} catch (Exception e) {
			juego.obtenerMapa().removerAtacable(edificio);		
		}
			
		return edificio;
	}
}
