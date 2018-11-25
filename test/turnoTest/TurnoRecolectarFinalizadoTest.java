package turnoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import turnos.TurnoRecolectarFinalizado;
import unidades.Aldeano;

public class TurnoRecolectarFinalizadoTest{
	
	@Test
	public void test01ElTurnoSeCreaYNoPuedeRecolectar() {
		TurnoRecolectarFinalizado turno = new TurnoRecolectarFinalizado();
		assertEquals(0, turno.recolectarOro(new Aldeano()));
	}

}
