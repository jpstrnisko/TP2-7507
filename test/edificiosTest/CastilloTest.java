package edificiosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;

public class CastilloTest {
	
	
	@Test
	public void elCastilloCreaUnArmaDeAsedio() {
		Castillo castillo = new Castillo();
		assert(castillo.crearUnArmaDeAsedio() instanceof ArmaDeAsedio);
	}
	
	@Test
	public void elCastilloSeCreaCon1000DeVida() {
		Castillo castillo = new Castillo();
		assertEquals(castillo.obtenerVida(), 1000);
	}
	
	@Test
	public void alRepararUnCastilloLaVidaAumentaEn15() {
		Castillo castillo = new Castillo();
		castillo.quitarVida(15);
		castillo.reparar();
		assertEquals(castillo.obtenerVida(), 1000);
	}
	
	@Test
	public void noSeDeberiaPoderRepararUnCastilloMasAllaDe1000DeVida() {
		Castillo castillo = new Castillo();
		castillo.quitarVida(5);
		castillo.reparar();
		castillo.reparar();
		assertEquals(castillo.obtenerVida(), 1000);
	}
	
	@Test 
	public void alAtacarAcualquierUnidadDentroDelRangoLeResta20DeVida() {
		Castillo castillo = new Castillo();
		Aldeano aldeano = new Aldeano();
		aldeano.establecerPosicion(new Posicion(7, 7));
		castillo.establecerPosicion(new Posicion(1, 1));
		int vidaActual = aldeano.obtenerVida();
		castillo.atacar(aldeano);
		assertEquals(vidaActual - 20, aldeano.obtenerVida());
	}
	
	@Test
	public void alAtacarACualquierEdificioLeResta20DeVida() {
		Castillo castillo = new Castillo();
		Cuartel cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(1, 1));
		castillo.establecerPosicion(new Posicion(4, 4));
		int vidaActual = cuartel.obtenerVida();
		castillo.atacar(cuartel);
		assertEquals(vidaActual - 20, cuartel.obtenerVida());
	}
	
	@Test
	public void elCastilloNoDeberiaPoderAtacarAUnEdificioFueraDeSuRango() {
		Castillo castillo = new Castillo();
		Cuartel cuartel = new Cuartel();
		cuartel.establecerPosicion(new Posicion(1, 1));
		castillo.establecerPosicion(new Posicion(4, 4));
		int vidaActual = cuartel.obtenerVida();
		castillo.atacar(cuartel);
		assertEquals(vidaActual - 20, cuartel.obtenerVida());
	}
	
	@Test
	public void elCastilloNoDeberiaPoderAtacarUnidadesFueraDeSuRango() {
		Castillo castillo = new Castillo();
		Aldeano aldeano1 = new Aldeano();
		Aldeano aldeano2 = new Aldeano();
		aldeano1.establecerPosicion(new Posicion(1, 8));
		aldeano2.establecerPosicion(new Posicion(8, 8));
		castillo.establecerPosicion(new Posicion(1, 1));
		int vidaActual1 = aldeano1.obtenerVida();
		int vidaActual2 = aldeano2.obtenerVida();
		
		castillo.atacar(aldeano1);
		castillo.atacar(aldeano2);
		assertEquals(vidaActual1, aldeano1.obtenerVida());
		assertEquals(vidaActual2, aldeano2.obtenerVida());
	}
	
	
	
	
}
