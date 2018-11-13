package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.Castillo;
import unidades.ArmaDeAsedio;

public class CastilloTest {
	
	Castillo castillo = new Castillo();
	
	@Test
	public void elCastilloCreaUnArmaDeAsedio() {
		assert(castillo.crearUnArmaDeAsedio() instanceof ArmaDeAsedio);
	}
	
	@Test
	public void elCastilloSeCreaCon1000DeVida() {
		assertEquals(castillo.obtenerVida(), 1000);
	}
	
	@Test
	public void alRepararUnCastilloLaVidaAumentaEn15() {
		Castillo nuevoCasti = new Castillo();
		nuevoCasti.reparar();
		assertEquals(nuevoCasti.obtenerVida(), 1015);
	}
}
