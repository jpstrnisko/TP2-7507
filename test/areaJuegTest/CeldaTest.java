package areaJuegTest;
import areaJuego.Posicion;
import interfaces.Atacable;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import areaJuego.Celda;

public class CeldaTest {
		
	@Test
	public void celdaSeCreaLibre() {
		
		Posicion posicion = new Posicion(0,0);
		Celda celda = new Celda(posicion);
		assertEquals(true, celda.estaLibre());
	}
	
	@Test
	public void celdaOcupadaCuandoSeColocaUnaUnidadEnPosicion00() {
		
		Posicion posicion = new Posicion(0,0);
		Celda celda = new Celda(posicion);
		celda.colocarAtacable(null, posicion);
		assertEquals(false, celda.estaLibre());
	}

	
	
}