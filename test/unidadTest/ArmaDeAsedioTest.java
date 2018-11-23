package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import unidades.ArmaDeAsedio;
import unidades.Espadachin;

public class ArmaDeAsedioTest {
	
	public static final ArmaDeAsedio miArma = new ArmaDeAsedio();
	@Test
	public void test01ArmaDeAsedioSeCreaCon150DeVida() {
		assertEquals(150, miArma.obtenerVida());
	}
	
	@Test
	public void test02ArmaDeAsedioSeCreaConUnCostoDe200() {
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
		Cuartel cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(250, cuartel.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioDeberiaSacar75DeDanioAlAtacarUnEdificioEstandoMontada() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		Cuartel cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(175, cuartel.obtenerVida());
	}
	
	@Test
	public void armaDeAsedioNoDeberiaSacarDanioAlAtacarUnaUnidad() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		Espadachin espadachin = new Espadachin();
		miArma.atacar(espadachin);
		assertEquals(100, espadachin.obtenerVida());
	}
}