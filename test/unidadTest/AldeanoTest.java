package unidadTest;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import areaJuego.Mapa;
import areaJuego.Posicion;
import unidades.Aldeano;
import edificios.PlazaCentral;
import juego.Juego;
import turnos.Jugador;
import edificios.Cuartel;
import edificios.Edificio;

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
	
	/*@Test
	public void elAldeanoNoDeberiaConstruirDosEdificios() {
		Aldeano aldeano = new Aldeano();
		aldeano.construirCuartel(new Posicion(1,1));
		aldeano.construirPlazaCentral(new Posicion(1,1));
	}*/
	
	
}

