package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edificios.Cuartel;
import areaJuego.Mapa;


public class MapaTest {
	
private Mapa mapa = new Mapa();
	
	@Test	
	public void seCreaMapaConTamanio20x50() {
		
		mapa.asignarTamanio(20,50);
		assertEquals(1000, mapa.obtenerTamanio());
	}
	
	@Test	
	public void sePosicionaUnaUnidad() {
		
		mapa.asignarTamanio(20,50);
		mapa.posicionar(2,2);
		assertEquals(false, mapa.estaLibre(2,2));
	}
	
	@Test
	public void sePosicionaUnEdificio() {
		
		Cuartel cuartel = new Cuartel();
		
		mapa.asignarTamanio(20,50);
		mapa.posicionarEdificio(cuartel,2,2);
		assertEquals(false, mapa.estaLibre(2,2));
	}
	
}