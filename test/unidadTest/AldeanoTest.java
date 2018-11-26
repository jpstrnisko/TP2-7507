package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import unidades.Aldeano;
import edificios.PlazaCentral;
import edificios.Cuartel;

public class AldeanoTest {

	@Test
	public void aldeanoSeCreaCon50DeVida() {
		Aldeano aldeano = new Aldeano();
		assertEquals(50, aldeano.obtenerVida());
	}
	@Test
	public void aldeanoSeCreaConUnCostoDe25() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.obtenerCosto());
	}
	
	@Test
	public void aldeanoConstruyePlazaCentral() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirPlaza() instanceof PlazaCentral);
	}
	
	@Test
	public void aldeanoConstruyeCuartel() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirCuartel() instanceof Cuartel);
	}
	
	@Test
	public void elAldeanoRecolecta20OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(20, aldeano.recolectarOro());
		assertEquals(0, aldeano.recolectarOro());
	}
	
	@Test
	public void elAldeanoDeberiaPoderRepararEdificio() {
		Aldeano aldeano = new Aldeano();
		Cuartel edificio = new Cuartel();
		edificio.quitarVida(50);
		assert(aldeano.repararEdificio(edificio));
	}
	
	
	@Test
	public void aldeanoSeCreaEnPosicion00DevuelvePosicionCorrecta() {
		Aldeano aldeano = new Aldeano();
		aldeano.establecerPosicion(new Posicion(0,0));
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionX(), 0);
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionY(), 0);
	}
	
	@Test
	public void aldeanoSeCreaEnPosicion00YLuegoSeMueveA11() {
		Aldeano aldeano =  new Aldeano();
		
		aldeano.establecerPosicion(new Posicion(0,0));
		aldeano.cambiarPosicion(new Posicion(1,1));
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(aldeano.obtenerPosicion().obtenerPosicionX(), 1);
	}
	
	
	@Test
	public void elAldeanoNoDeberiaRecolectarOroMientrasConstruye() {
		Aldeano aldeano = new Aldeano();
		assertTrue(aldeano.construirCuartel() instanceof Cuartel);
		assertEquals(0, aldeano.recolectarOro());
	}
	
	@Test
	public void elAldeanoNoDeberiaConstruirDosEdificios() {
		Aldeano aldeano = new Aldeano();
		assertTrue(aldeano.construirCuartel() instanceof Cuartel);
		assertEquals(aldeano.construirPlaza(), null);
	}
	
}

