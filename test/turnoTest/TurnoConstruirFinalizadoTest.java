package turnoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import turnos.TurnoConstruirFinalizado;
import unidades.Aldeano;

public class TurnoConstruirFinalizadoTest {
	
	@Test
	public void test01ElTurnoPuedeConstruirUnCuartel() {
		TurnoConstruirFinalizado turno = new TurnoConstruirFinalizado();
		Aldeano aldeano = new Aldeano();
		assertEquals(turno.construirCuartel(aldeano), null);
	}

	@Test
	public void test01ElTurnoPuedeConstruirUnaPlazaCentral() {
		TurnoConstruirFinalizado turno = new TurnoConstruirFinalizado();
		Aldeano aldeano = new Aldeano();
		assertEquals(turno.construirPlazaCentral(aldeano), null);
	}
}
