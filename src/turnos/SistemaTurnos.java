package turnos;

import java.util.List;

import juego.FaltanJugadoresError;

public class SistemaTurnos {
	private ListaJugadores jugadores = new ListaJugadores();
	private int cantidadMaximaJugadores = 2;
	
	public void agregarJugador(Jugador jugador) throws MaximoJugadoresError {
		int cantidadJugadores = jugadores.obtenerCantidadJugadores();
		if (cantidadJugadores >= cantidadMaximaJugadores) {
			throw new MaximoJugadoresError();
		}
		jugadores.agregar(jugador);
		if (cantidadJugadores == cantidadMaximaJugadores) {
			jugadores.comenzarTurnos();
		}
	}
	
	public Jugador obtenerJugadorActual() {
		return jugadores.obtenerActual();
	}

	public void avanzarTurno() {
		jugadores.avanzarSiguiente();
	}
	
	public int obtenerCantidadJugadores() {
		return jugadores.obtenerCantidadJugadores();
	}

	public List<Jugador> obtenerJugadores() {
		return jugadores.obtenerJugadores();
	}

}
