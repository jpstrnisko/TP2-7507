package turnoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edificios.Cuartel;
import turnos.TurnoRepararHabilitado;
import unidades.Aldeano;

public class TurnoRepararHabilitadoTest {
	
	@Test
	public void test01ElTurnoSeCreaYPuedeReparar() {
		TurnoRepararHabilitado turno = new TurnoRepararHabilitado();
		Cuartel cuartel = new Cuartel();
		cuartel.quitarVida(100);
		assertEquals(true, turno.repararEdificio(cuartel, new Aldeano()));
	}

}
