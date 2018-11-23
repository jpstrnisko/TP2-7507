package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Celda;
import areaJuego.Posicion;
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
	
	@Test
	public void aldeanoSeCreaEnPosicion00DevuelvePosicionCorrecta() {
		aldeano.establecerPosicion(new Posicion(0,0));
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionX(), 0);
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionY(), 0);
	}
	
	@Test
	public void aldeanoSeCreaEnPosicion00YLuegoSeMueveA11() {
		aldeano.establecerPosicion(new Posicion(0,0));
		aldeano.cambiarPosicion(new Posicion(1,1));
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionX(), 1);
	}
	/*@Test
	public void elAldeanoRecolecta20OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(20, aldeano.recolectarOro());
		assertEquals(0, aldeano.recolectarOro());
	}*/
	/*
	@Test
	public void elAldeanoPuedeRepararEdificioPorTurno() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.estaReparando());
	}
	*/
	
	
	/*@Test
	public void elAldeanoPuedeMoverLaPosicionUnaVezPorTurno() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.moverA(new Posicion(1,1)));
		assert(aldeano.moverA(new Posicion(2,2)));
	}*/
	
	
	/*
	@Test
	public void elAldeanoDeberiaNoRecolectarOroMientrasConstruye() {
		Aldeano aldeano = new Aldeano();
		assertTrue(aldeano.construirCuartel() instanceof Cuartel);
		assertEquals(0, aldeano.recolectarOro());
	}*/
	
}

