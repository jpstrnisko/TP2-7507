package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edificios.Cuartel;
import unidades.Arquero;
import areaJuego.Mapa;
import areaJuego.Posicion;


public class MapaTest {
	
	
	@Test	
	public void seCreaMapaConTamanio20x50YDevuelve1000CeldasCreados() {
		Mapa mapa = new Mapa(20,50);
		mapa.instalarCeldas();
		assertEquals(mapa.obtenerCantidadCeldas(), 1000);
	}
	
	/*@Test	
	public void seColocaUnaUnidadEnPosicionF2C2DevuelveEsaPosicionOcupada() {
		Mapa mapa = new Mapa(4,4);
		Posicion pos = new Posicion(2,2);
		mapa.colocarAtacable(pos, new Arquero());
		assertEquals(mapa.celdaOcupada(pos), false);
	}*/
}
	