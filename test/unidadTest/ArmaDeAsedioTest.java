package unidadTest;

import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import unidades.ArmaDeAsedio;
import unidades.Espadachin;
import unidades.Unidad;


public class ArmaDeAsedioTest {
	
	public static final ArmaDeAsedio miArma = new ArmaDeAsedio();
	
	@Test
	public void armaDeAsedioSeCreaCon150DeVida() {
		assertEquals(150, miArma.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioSeCreaConUnCostoDe200() {
		assertEquals(200, miArma.obtenerCosto());
	}
	
	@Test
	public void armaDeAsedioSeDeberiaCrearDesmontada() {
		Castillo castillo = new Castillo();
		ArmaDeAsedio miArma = castillo.crearUnArmaDeAsedio();
		assertFalse(miArma.estaMontada());
	}
	
	@Test
	public void armaDeAsedioDeberiaEstarMontadaAlMontarla() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		assertTrue(miArma.estaMontada());
	}
	
	@Test
	public void armaDeAsedioDeberiaEstarDesmontadaAlDesmontarla() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		miArma.desmontar();
		assertFalse(miArma.estaMontada());
	}
	
	@Test
	public void armaDeAsedioNoDeberiaSacarDanioAlAtacarDesmontada() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		Edificio cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(250, cuartel.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioDeberiaSacar75DeDanioAlAtacarUnEdificioEstandoMontada() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.establecerPosicion(new Posicion(0,0));
		miArma.montar();
		Edificio cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(3,3));
		miArma.atacar(cuartel);
		assertEquals(175, cuartel.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioNoDeberiaSacarDanioAlAtacarUnaUnidad() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.establecerPosicion(new Posicion(0,0));
		miArma.montar();
		Unidad espadachin = new Espadachin();
		espadachin.establecerPosicion(new Posicion(1, 1));
		miArma.atacar(espadachin);
		assertEquals(100, espadachin.obtenerVida());
	}
	
	@Test
	public void ASDSeCreaEnPosicion00DevuelvePosicionCorrecta() {
		miArma.establecerPosicion(new Posicion(0,0));
		assertEquals(miArma.obtenerPosicion().obtenerPosicionX(), 0);
		assertEquals(miArma.obtenerPosicion().obtenerPosicionY(), 0);
	}
	
	@Test
	public void ASDSeCreaEnPosicion00YLuegoSeMueveA11() {
		miArma.establecerPosicion(new Posicion(0,0));
		miArma.cambiarPosicion(new Posicion(1,1));
		assertEquals(miArma.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(miArma.obtenerPosicion().obtenerPosicionX(), 1);
	}

	@Test
	public void armaDeAsedioNoDeberiaAtacarUnEdificioFueraDelRangoDeAtaque() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.establecerPosicion(new Posicion(0,0));
		miArma.montar();
		Edificio cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(6,6));
		miArma.atacar(cuartel);
		assertEquals(250, cuartel.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioDeberiaAtacarUnEdificioDentroDelRangoDeAtaque() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.establecerPosicion(new Posicion(7,7));
		miArma.montar();
		Edificio cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(1,1));
		miArma.atacar(cuartel);
		assertEquals(175, cuartel.obtenerVida());
	}
}