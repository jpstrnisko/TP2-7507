package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

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
	public void test01EspadachinSeCreaCon100DeVida() {
		assertEquals(100, espadachin.obtenerVida());
	}
	
	@Test
	public void test02EspadachinSeCreaConUnCostoDe50() {
		assertEquals(50, espadachin.obtenerCosto());
	}
	
	@Test
	public void test03EspadachinDeberiaSacar25DeDanioAlAtacarOtraUnidad() {
		Espadachin espadachin = new Espadachin();
		Atacable arquero = new Arquero();
		espadachin.atacar(arquero);
		assertEquals(50, ((Unidad) arquero).obtenerVida());
	}
	
	public void test04EspadachinDeberiaSacar15DeDanioAlAtacarUnEdificio() {
		Espadachin espadachin = new Espadachin();
		Atacable cuartel = new Cuartel();
		espadachin.atacar(cuartel);
		assertEquals(235, ((Edificio) cuartel).obtenerVida());
	}

}