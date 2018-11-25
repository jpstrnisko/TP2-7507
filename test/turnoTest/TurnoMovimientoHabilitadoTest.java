package turnoTest;

import org.junit.Test;

import areaJuego.Posicion;
import turnos.TurnoMovimientoHabilitado;
import unidades.Aldeano;

public class TurnoMovimientoHabilitadoTest {
	
	@Test
	public void test01ElTurnoSeCreaYPuedeMoverseAUnaPosicionValida() {
		TurnoMovimientoHabilitado turno = new TurnoMovimientoHabilitado();
		assert(turno.moverUnidad(new Posicion(1,1), new Aldeano()));
	}
	/*
	@Test
	public void test01ElTurnoSeCreaYNoPuedeMoverseAUnaPosicionInvalida() {
		TurnoMovimientoHabilitado turno = new TurnoMovimientoHabilitado();
		assert(turno.moverUnidad(new Posicion(100,100), new Aldeano()));
	}
	 */

}
