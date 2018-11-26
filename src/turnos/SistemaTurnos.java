package turnos;

import java.util.List;

import juego.FaltanJugadoresError;

public class SistemaTurnos {
	private ListaJugadores jugadores = new ListaJugadores();
	protected int cantidadJugadores = 0;
	private int cantidadMaximaJugadores = 2;
	
	public void agregarJugador(Jugador jugador) throws MaximoJugadoresError {
		if (cantidadJugadores >= cantidadMaximaJugadores) {
			throw new MaximoJugadoresError();
		}
		jugadores.agregar(jugador);
		this.cantidadJugadores += 1;
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
