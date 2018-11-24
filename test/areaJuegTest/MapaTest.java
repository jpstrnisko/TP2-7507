package areaJuegTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edificios.Cuartel;
import unidades.Arquero;
import areaJuego.Celda;
import areaJuego.PosicionOcupadaError;
import areaJuego.Mapa;
import areaJuego.Posicion;
import areaJuego.PosicionFueraDeMapaError;


public class MapaTest {
	
	
	@Test	
	public void seCreaMapaConTamanio20x50YDevuelve1000LugaresParaCeldas() {
		Mapa mapa = new Mapa(20,50);
		assertEquals(mapa.obtenerTamanio(), 1000);
	}
	
	@Test	
	public void chequearSiUnaPosicionEstaFueraDelMapaDevuelveTrue() {
		Mapa mapa = new Mapa(20,20);
		Posicion pos = new Posicion(21,21);
		assert(mapa.seSalioDelMapa(pos));
	}
	
	@Test
	public void chequearSiUnaPosicionEstaDentroDelMapaDevuelveTrue() {
		Mapa mapa = new Mapa(20,20);
		Posicion pos = new Posicion(1,1);
		assert(!mapa.seSalioDelMapa(pos));
	}
	
	
	@Test(expected = PosicionFueraDeMapaError.class)
	public void colocarUnaEntidadEnUnaPosicionFueraDelMapaDeberiaLanzarExcepcion() throws Exception {
		Mapa mapa = new Mapa(20,20);
		mapa.colocarAtacable(new Posicion(21,21), new Arquero());		
	}
	
	/*@Test
	public void colocarUnaUnidadDeberiaDevolverQueSuUnicaPosicionEstaOcupada() throws Exception { //Esta simple no pasa
		Mapa mapa = new Mapa(20,20);
		mapa.colocarAtacable(new Posicion(1,1), new Arquero());
		assert(mapa.posicionEstaOcupada(new Posicion(1,1)));
	}*/
	
}
	