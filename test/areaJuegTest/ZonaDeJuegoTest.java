package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import areaJuego.ZonaDeJuego;

public class ZonaDeJuegoTest {
	
	private ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	
	@Test
	public void crearUnaZonaDeJuego() {
		
		Integer[][] tamanio = new Integer[10][20];
		
		zonaDeJuego.crearZonaDeJuego(tamanio, 10, 20);
		
		assertEquals(true, zonaDeJuego.nollegoAlFinal(3,3));
		assertEquals(false, zonaDeJuego.nollegoAlFinal(11,1));
			
	}
	
	
	
}