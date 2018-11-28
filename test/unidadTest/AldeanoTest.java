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
		aldeano.construirPlazaCentral(new Posicion(1,1));
		assert(aldeano.construirPlaza() instanceof PlazaCentral);
	}
	
	@Test
	public void aldeanoConstruyeCuartelEn3Turnos() {
		Aldeano aldeano = new Aldeano();
		aldeano.construirCuartel(new Posicion(1,1));
		for(int turno = 1; turno < 3; turno++) {
			aldeano.realizarAccion();
			assert();
		}
		assert(aldeano.realizarAccion() instanceof Cuartel);
	}
	
	@Test
	public void elAldeanoRecolecta20OroPorTurno() {
		Aldeano aldeano = new Aldeano();
		assertEquals(20, aldeano.realizarAccion());
	}
	
	@Test
	public void elAldeanoDeberiaPoderRepararEdificio() {
		Aldeano aldeano = new Aldeano();
		Cuartel edificio = new Cuartel();
		int vidaInicial = edificio.obtenerVida();
		edificio.quitarVida(50);
		aldeano.repararEdificio(edificio);
		assertEquals(edificio.obtenerVida(), vidaInicial);
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
		aldeano.construirCuartel(new Posicion(1,1));
		assertEquals(0, aldeano.recolectarOro());
	}
	
	@Test
	public void elAldeanoNoDeberiaConstruirDosEdificios() {
		Aldeano aldeano = new Aldeano();
		aldeano.construirCuartel(new Posicion(1,1));
		aldeano.construirPlazaCentral(new Posicion(1,1));
	}
	
	
}

