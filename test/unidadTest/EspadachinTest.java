package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import interfaces.Atacable;
import unidades.Arquero;
import edificios.PlazaCentral;
import unidades.Aldeano;
import unidades.Espadachin;
import unidades.Unidad;

public class EspadachinTest {
	
	public static final Espadachin espadachin = new Espadachin();
	
	@Test
	public void espadachinSeCreaCon100DeVida() {
		assertEquals(100, espadachin.obtenerVida());
	}
	
	@Test
	public void espadachinSeCreaConUnCostoDe50() {
		assertEquals(50, espadachin.obtenerCosto());
	}
	
	@Test
	public void espadachinDeberiaSacar25DeDanioAlAtacarOtraUnidad() {
		Espadachin espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(0,0));
		Unidad arquero = new Arquero();
		arquero.establecerPosicion(new Posicion(1,1));
		espadachin.atacar(arquero);
		assertEquals(50, arquero.obtenerVida());
	}
	@Test
	public void espadachinDeberiaSacar15DeDanioAlAtacarUnEdificio() {
		Espadachin espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(0,0));
		Edificio cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(1,0));
		espadachin.atacar(cuartel);
		assertEquals(235, cuartel.obtenerVida());
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
	
	@Test
	public void espadachinNoDeberiaAtacarUnidadFueraDelRangoDeAtaque() {
		Espadachin espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(0,0));
		Unidad arquero = new Arquero();
		arquero.establecerPosicion(new Posicion(3,4));
		espadachin.atacar(arquero);
		assertEquals(75, arquero.obtenerVida());
	}
	@Test
	public void espadachinNoDeberiaAtacarEdificioFueraDelRangoDeAtaque() {
		Espadachin espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(0,0));
		Edificio cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(2,6));
		espadachin.atacar(cuartel);
		assertEquals(250, cuartel.obtenerVida());
	}
	
	@Test
	public void espadachinDeberiaAtacarEdificioDentroDelRangoDeAtaque() {
		Espadachin espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(5, 5));
		Edificio castillo = new Castillo();
		castillo.establecerPosicion(new Posicion(1, 1));
		espadachin.atacar(castillo);
		assertEquals(985, castillo.obtenerVida());
	}

}