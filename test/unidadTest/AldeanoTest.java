package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import areaJuego.ZonaDeJuego;
import unidades.Aldeano;
import unidades.AldeanoNoPuedeAtacarError;
import unidades.Unidad;
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
	public void elAldeanoRecolecta20OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(20, aldeano.recolectarOro());
		assertEquals(0, aldeano.recolectarOro());
	}
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
	
	@Test
	public void elAldeanoSeMueveCorrectamenteHaciaLaDerecha() {
		Unidad aldeano = new Aldeano();
		Posicion posicionInicial = new Posicion(20, 20);
		
		aldeano.moverA(posicionInicial);
		aldeano.moverDerecha();
		
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionFila(), 20);
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionColumna(), 21);
	}
	
	@Test
	public void elAldeanoDeberiaMantenerSuPosicionAlIntentarMoverseAUnaPosicionOcupada() {
		Unidad aldeano1 = new Aldeano();
		Unidad aldeano2 = new Aldeano();
		Posicion posicion1 = new Posicion(20, 20);
		Posicion posicion2 = new Posicion(20, 21);
		
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		
		zonaDeJuego.agregarUnidad(aldeano1);
		zonaDeJuego.agregarUnidad(aldeano2);
		
		aldeano1.moverA(posicion1);
		aldeano2.moverA(posicion2);
		
		aldeano1.moverDerecha();
		
		assertEquals(aldeano1.obtenerPosicion().obtenerPosicionFila(), 20);
		assertEquals(aldeano1.obtenerPosicion().obtenerPosicionColumna(), 20);
	}
	
}

