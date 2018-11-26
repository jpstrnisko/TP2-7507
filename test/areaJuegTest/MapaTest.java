package areaJuegTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import edificios.Castillo;
import edificios.Cuartel;
import unidades.Aldeano;
import unidades.Arquero;
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
	
	@Test
	public void colocarUnaUnidadDeberiaDevolverQueSuUnicaPosicionEstaOcupada() throws Exception { 
		Mapa mapa = new Mapa(20,20);
		mapa.colocarAtacable(new Posicion(1,1), new Arquero());
		assert(mapa.posicionEstaOcupada(new Posicion(1,1)));
	}
	
	@Test
	public void colocarUnCastilloImplica16PosicionesOcupadas() throws Exception { //SE OCUPAN DESDE LA POS (2,2) HASTA LA (5,5)
		Mapa mapa = new Mapa(20,20);
		Castillo casti = new Castillo();
		mapa.colocarAtacable(new Posicion(2,2), casti);
		boolean estado = false;
		for(int i = 0; i < Math.sqrt(casti.obtenerTamanio()); i++) {
			for(int j = 0; j < Math.sqrt(casti.obtenerTamanio()); j++) {
				estado = mapa.posicionEstaOcupada(new Posicion(2+i, 2+j));
				if(!estado) fail();
			}
		}
		assert(estado);
	
	}
	
	@Test
	public void colocarUnCuartelImplica4PosicionesOcupadas() throws Exception { //SE OCUPAN DESDE LA POS (1,1) HASTA LA (2,2)
		Mapa mapa = new Mapa(20,20);
		Cuartel cuartel = new Cuartel();
		mapa.colocarAtacable(new Posicion(1,1), cuartel);
		boolean estado = false;
		for(int i = 0; i < Math.sqrt(cuartel.obtenerTamanio()); i++) {
			for(int j = 0; j< Math.sqrt(cuartel.obtenerTamanio()); j++) {
				estado = mapa.posicionEstaOcupada(new Posicion(1+i, 1+j));
				if (!estado) fail();
			}
		}
		assert(estado);
	}
	
	@Test(expected = PosicionOcupadaError.class)
	public void alColocarUnaUnidadEnUnaPosicionOcupadaDeberiaLanzarExcepcion() throws Exception {
		Mapa mapa = new Mapa(20,20);
		mapa.colocarAtacable(new Posicion(2,2), new Cuartel());
		mapa.colocarAtacable(new Posicion(3,3), new Arquero());
	}
	
	@Test(expected = PosicionOcupadaError.class)
	public void seColocaUnCastilloYSeQuiereColocarUnAldeanoEnPosicionOcupadaLanzaExcepcion() throws Exception {
		Mapa mapa = new Mapa(20,20);
		mapa.colocarAtacable(new Posicion(2,2), new Castillo()); //Se que desde (2,2) hasta (5,5) estan ocupadas.
		mapa.colocarAtacable(new Posicion(4,3), new Aldeano());
	}
	
	
	
	
}
	