package turnoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import turnos.TurnoFinalizado;

public class TurnoFinalizadoTest {
	
	@Test
	public void test01ElTurnoSeCreaYNoPuedeRealizarAcciones() {
		TurnoFinalizado turno = new TurnoFinalizado();
		assertEquals(0, turno.recolectarOro());
	}

}
