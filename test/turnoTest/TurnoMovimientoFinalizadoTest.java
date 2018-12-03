package turnoTest;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import areaJuego.Posicion;
import turnos.TurnoMovimientoFinalizado;
import unidades.Aldeano;

public class TurnoMovimientoFinalizadoTest {
	
	@Test
	public void test01ElTurnoSeCreaYPuedeMoverseAUnaPosicionValida() {
		TurnoMovimientoFinalizado turno = new TurnoMovimientoFinalizado();
		assertFalse(turno.moverUnidad(new Posicion(1,1)));
	}

}
