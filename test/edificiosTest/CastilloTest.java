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
	
	
	
	
}
