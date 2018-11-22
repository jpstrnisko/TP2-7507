package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import areaJuego.ZonaDeJuego;

public class ZonaDeJuegoTest {
	
	private ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	
	@Test
	public void crearUnaZonaDeJuego() {
		
		zonaDeJuego.crearZonaDeJuego(10,20);
		assertEquals(true, zonaDeJuego.nollegoAlFinal(3,3));
	}
	
	@Test
	public void posicionarUnidad() {
		
		zonaDeJuego.crearZonaDeJuego(5,10);
		zonaDeJuego.posicionar(2,4);
		assertEquals(false, zonaDeJuego.estaLibre(2,4));
	}
	
	@Test
	public void posicionarEdificioIzquierdaArriba() {
		
		zonaDeJuego.crearZonaDeJuego(5,10);
		zonaDeJuego.posicionarEdificioIzquierdaArriba(2,4,1); //por ejemplo el cuartel que ocupa 4 celdas y ocupo una celda a la izquierda y una hacia arriba
		
		assertEquals(false, zonaDeJuego.estaLibre(2,4));
		assertEquals(false, zonaDeJuego.estaLibre(2,3));
		assertEquals(false, zonaDeJuego.estaLibre(1,3));
		assertEquals(false, zonaDeJuego.estaLibre(1,4));
	}
	
	@Test
	public void posicionarEdificioDerechaArriba() {
		
		zonaDeJuego.crearZonaDeJuego(5,10);
		zonaDeJuego.posicionarEdificioDerechaArriba(2,4,1); //por ejemplo el cuartel que ocupa 4 celdas
		
		assertEquals(false, zonaDeJuego.estaLibre(2,4));
		assertEquals(false, zonaDeJuego.estaLibre(2,5));
		assertEquals(false, zonaDeJuego.estaLibre(1,4));
		assertEquals(false, zonaDeJuego.estaLibre(1,5));
	}
	
	@Test
	public void posicionarEdificioIzquierdaAbajo() {
		
		zonaDeJuego.crearZonaDeJuego(5,10);
		zonaDeJuego.posicionarEdificioIzquierdaAbajo(2,4,1); //por ejemplo el cuartel que ocupa 4 celdas
		
		assertEquals(false, zonaDeJuego.estaLibre(2,4));
		assertEquals(false, zonaDeJuego.estaLibre(2,3));
		assertEquals(false, zonaDeJuego.estaLibre(3,4));
		assertEquals(false, zonaDeJuego.estaLibre(3,3));
	}
	
	@Test
	public void posicionarEdificioDerechaAbajo() {
		
		zonaDeJuego.crearZonaDeJuego(5,10);
		zonaDeJuego.posicionarEdificioDerechaAbajo(2,4,1); //por ejemplo el cuartel que ocupa 4 celdas
		
		assertEquals(false, zonaDeJuego.estaLibre(2,4));
		assertEquals(false, zonaDeJuego.estaLibre(2,5));
		assertEquals(false, zonaDeJuego.estaLibre(3,4));
		assertEquals(false, zonaDeJuego.estaLibre(3,5));
	}
	
}