package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import interfaces.Atacable;
import unidades.ArmaDeAsedio;
import unidades.Espadachin;
import unidades.Unidad;
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
	public void test03ArmaDeAsedioSeDeberiaCrearDesmontada() {
		Castillo castillo = new Castillo();
		ArmaDeAsedio miArma = castillo.crearUnArmaDeAsedio();
		assertFalse(miArma.estaMontada());
	}
	
	@Test
	public void test04ArmaDeAsedioDeberiaEstarMontadaAlMontarla() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		assertTrue(miArma.estaMontada());
	}
	
	@Test
	public void test05ArmaDeAsedioDeberiaEstarDesmontadaAlDesmontarla() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		miArma.desmontar();
		assertFalse(miArma.estaMontada());
	}
	
	@Test
	public void test06ArmaDeAsedioNoDeberiaSacarDanioAlAtacarDesmontada() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		Atacable cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(250, ((Edificio) cuartel).obtenerVida());
	}
	
	@Test
	public void test07ArmaDeAsedioDeberiaSacar75DeDanioAlAtacarUnEdificioEstandoMontada() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		Atacable cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(175, ((Edificio) cuartel).obtenerVida());
	}
	
	@Test
	public void test07ArmaDeAsedioNoDeberiaSacarDanioAlAtacarUnaUnidad() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		miArma.montar();
		Atacable espadachin = new Espadachin();
		miArma.atacar(espadachin);
		assertEquals(100, ((Unidad) espadachin).obtenerVida());
	}

}