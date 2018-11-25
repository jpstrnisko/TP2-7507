package turnoTest;

import org.junit.Test;

import edificios.Cuartel;
import edificios.PlazaCentral;
import turnos.TurnoConstruirHabilitado;
import unidades.Aldeano;

public class TurnoConstruirHabilitadoTest {
	
	@Test
	public void test01ElTurnoPuedeConstruirUnCuartel() {
		TurnoConstruirHabilitado turno = new TurnoConstruirHabilitado();
		Aldeano aldeano = new Aldeano();
		assert(turno.construirCuartel(aldeano) instanceof Cuartel);
	}

	@Test
	public void test01ElTurnoPuedeConstruirUnaPlazaCentral() {
		TurnoConstruirHabilitado turno = new TurnoConstruirHabilitado();
		Aldeano aldeano = new Aldeano();
		assert(turno.construirPlazaCentral(aldeano) instanceof PlazaCentral);
	}
}
