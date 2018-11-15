package turnos;

public class SistemaTurnos {
	private ListaJugadores jugadores = new ListaJugadores();
	protected int cantidadJugadores = 0;
	private int cantidadMaximaJugadores = 2;
	
	public void agregarJugador(Jugador jugador) {
		if (cantidadJugadores >= cantidadMaximaJugadores) {
			return; //Se puede agregar una excepcion
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

}
