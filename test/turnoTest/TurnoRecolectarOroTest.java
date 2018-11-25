package turnoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import turnos.TurnoRecolectarOro;
import unidades.Aldeano;

public class TurnoRecolectarOroTest {
	
	@Test
	public void test01ElTurnoSeCreaYPuedeRecolectarOro() {
		TurnoRecolectarOro turno = new TurnoRecolectarOro();
		assertEquals(20, turno.recolectarOro(new Aldeano()));
	}

}
