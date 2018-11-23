package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import edificios.PlazaCentral;
import unidades.Aldeano;
import unidades.Espadachin;

public class EspadachinTest {
	
	public static final Espadachin espadachin = new Espadachin();
	
	@Test
	public void test01EspadachinSeCreaCon100DeVida() {
		assertEquals(100, espadachin.obtenerVida());
	}
	
	@Test
	public void test02EspadachinSeCreaConUnCostoDe50() {
		assertEquals(50, espadachin.obtenerCosto());
	}
	
	@Test
	public void espadachinAtacaACualquierUnidadYLeResta25DeVida() { //Pruebo con aldeano
		Aldeano aldeano = new Aldeano();
		int vidaActual = aldeano.obtenerVida();
		espadachin.atacar(aldeano);
		assertEquals(vidaActual-25, aldeano.obtenerVida());
	}
	
	@Test
	public void espadachinAtacaACualquierEdificioYLeResta15DeVida() {
		PlazaCentral plaza = new PlazaCentral();
		int vidaActual = plaza.obtenerVida();
		espadachin.atacar(plaza);
		assertEquals(vidaActual-15, plaza.obtenerVida());
	}
	
	@Test
	public void espadachinSeCreaEnPosicion00DevuelvePosicionCorrecta() {
		espadachin.establecerPosicion(new Posicion(0,0));
		assertEquals(espadachin.obtenerPosicion().obtenerPosicionX(), 0);
		assertEquals(espadachin.obtenerPosicion().obtenerPosicionY(), 0);
	}
	
	@Test
	public void espadachinSeCreaEnPosicion00YLuegoSeMueveA11() {
		espadachin.establecerPosicion(new Posicion(0,0));
		espadachin.cambiarPosicion(new Posicion(1,1));
		assertEquals(espadachin.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(espadachin.obtenerPosicion().obtenerPosicionX(), 1);
	}
	

}