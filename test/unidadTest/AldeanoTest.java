package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Celda;
import unidades.Aldeano;
import unidades.AldeanoNoPuedeAtacarError;
import edificios.PlazaCentral;
import interfaces.Atacable;
import edificios.Cuartel;

public class AldeanoTest {

	private static final Atacable atacable = null;
	private static final Aldeano aldeano = new Aldeano();

	@Test
	public void aldeanoSeCreaCon50DeVida() {
		assertEquals(50, aldeano.obtenerVida());
	}
	@Test
	public void aldeanoSeCreaConUnCostoDe25() {
		assertEquals(25, aldeano.obtenerCosto());
	}
	
	@Test
	public void aldeanoConstruyePlazaCentral() {
		assert(aldeano.construirPlaza() instanceof PlazaCentral);
	}
	
	@Test
	public void aldeanoConstruyeCuartel() {
		assert(aldeano.construirCuartel() instanceof Cuartel);
	}
	
	/*@Test
	public void elAldeanoRecolecta25OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.recolectarOro());
		assertEquals(0, aldeano.recolectarOro());
	}
	
	@Test
	public void elAldeanoPuedeRepararEdificioPorTurno() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.estaReparando());
	}
	
	@Test
	public void elAldeanoPuedeMoverLaPosicionUnaVezPorTurno() {
		Aldeano aldeano = new Aldeano();
		Celda celda = new Celda();
		assert(aldeano.moverA(celda));
		assertFalse(aldeano.moverA(new Celda()));
	}
	
	@Test
	public void elAldeanoDeberiaNoRecolectarOroMientrasConstruye() {
		Aldeano aldeano = new Aldeano();
		assertTrue(aldeano.construirCuartel() instanceof Cuartel);
		assertEquals(0, aldeano.recolectarOro());
	}*/
}

