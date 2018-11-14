package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import areaJuego.Celda;

public class CeldaTest {
	
	private Celda celda = new Celda();
	
	@Test
	public void celdaSeCreaLibre() {
	
		assertEquals(true, celda.estaLibre());
	}
	
	@Test
	public void celdaOcupadaCuandoSeColocaUnaUnidad() {
		
		celda.colocarUnidad(2,2);
		assertEquals(false, celda.estaLibre());
	}

	
	
}