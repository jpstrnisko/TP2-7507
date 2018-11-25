package turnoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import turnos.Jugador;
import turnos.SistemaTurnos;

public class SistemaTurnosTest {

	@Test
	public void seAlternanCorrectamenteLosTurnosDeLosJugadores() {
		SistemaTurnos sistemaTurnos = new SistemaTurnos();
		Jugador jugador1 = new Jugador("Jugador Rojo");
		Jugador jugador2 = new Jugador("Jugador Azul");
		
		sistemaTurnos.agregarJugador(jugador1);
		sistemaTurnos.agregarJugador(jugador2);
		
		Jugador jugadorActual = sistemaTurnos.obtenerJugadorActual();
		Jugador jugadorSiguiente;
		
		if (jugadorActual == jugador1) {
			jugadorSiguiente = jugador2;
		}
		else {
			jugadorSiguiente = jugador1;
		}
		
		sistemaTurnos.avanzarTurno();
		assertEquals(sistemaTurnos.obtenerJugadorActual(), jugadorSiguiente);
		
		sistemaTurnos.avanzarTurno();
		assertEquals(sistemaTurnos.obtenerJugadorActual(), jugadorActual);
		
		sistemaTurnos.avanzarTurno();
		assertEquals(sistemaTurnos.obtenerJugadorActual(), jugadorSiguiente);
	}

}
