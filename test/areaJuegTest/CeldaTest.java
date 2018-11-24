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
	public void seCreaCeldaEnPosicionF1C1DevuelveCorrectamente() {
		Celda celda = new Celda(new Posicion(1,1));
		assertEquals(celda.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(celda.obtenerPosicion().obtenerPosicionX(),1);
	}
	
	@Test
	public void ocupoUnaCeldaYDeberiaDevolverOcupada() {
		Celda celda = new Celda(new Posicion(1,1));
		celda.ocuparCelda();
		assert(!celda.estaLibre());
	}
}
	
