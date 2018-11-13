package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import unidades.Aldeano;
import edificios.PlazaCentral;
import fiuba.algo3.ejemplo1.Celda;
import edificios.Cuartel;

public class AldeanoTest {

	@Test
	public void test01AldeanoSeCreaCon50DeVida() {
		Aldeano aldeano = new Aldeano();
		assertEquals(50, aldeano.obtenerVida());
	}
	@Test
	public void test02AldeanoSeCreaConUnCostoDe25() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.obtenerCosto());
	}
	
	@Test
	public void test03AldeanoConstruyePlazaCentral() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirPlaza() instanceof PlazaCentral);
	}
	
	@Test
	public void test04AldeanoConstruyeCuartel() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirCuartel() instanceof Cuartel);
	}
	
	@Test
	public void test05ElAldeanoRecolecta25OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.recolectarOro());
		assertEquals(0, aldeano.recolectarOro());
	}
	
	@Test
	public void test06ElAldeanoPuedeRepararEdificioPorTurno() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.estaReparando());
	}
	
	@Test
	public void test05ElAldeanoPuedeMoverLaPosicionUnaVezPorTurno() {
		Aldeano aldeano = new Aldeano();
		Celda celda = new Celda();
		assert(aldeano.moverA(celda));
		assertFalse(aldeano.moverA(new Celda()));
	}
	
	@Test
	public void test08ElAldeanoDeberiaNoRecolectarOroMientrasConstruye() {
		Aldeano aldeano = new Aldeano();
		assertTrue(aldeano.construirCuartel() instanceof Cuartel);
		assertEquals(0, aldeano.recolectarOro());
	}
}
