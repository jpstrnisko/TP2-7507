package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.Castillo;
import edificios.Cuartel;
import unidades.Aldeano;
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
		castillo.reparar();
		assertEquals(castillo.obtenerVida(), 1015);
	}
	
	@Test 
	public void alAtacarAcualquierUnidadLeResta20DeVida() {
		Aldeano aldeano = new Aldeano();
		int vidaActual = aldeano.obtenerVida();
		castillo.atacar(aldeano);
		assertEquals(vidaActual-20, aldeano.obtenerVida());
	}
	@Test
	public void alAtacarACualquierEdificioLeResta20DeVida() {
		Cuartel cuartel = new Cuartel();
		int vidaActual = cuartel.obtenerVida();
		castillo.atacar(cuartel);
		assertEquals(vidaActual-20, cuartel.obtenerVida());
	}
}
