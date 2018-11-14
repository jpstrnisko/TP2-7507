package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import areaJuego.Mapa;


public class MapaTest {
	
	private Mapa mapa = new Mapa();
	
	@Test	
	public void seCreaMapaConTamanio20x50() {
		
		mapa.asignarTamanio(20,50);
		
		assertEquals(1000, mapa.obtenerTamanio());
	}
	
	
}