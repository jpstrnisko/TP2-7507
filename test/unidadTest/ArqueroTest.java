package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import edificios.Cuartel;
import unidades.Arquero;
import unidades.Espadachin;

public class ArqueroTest {
	
	public static final Arquero arquero = new Arquero();
	
	@Test
	public void test01ArqueroSeCreaCon75DeVida() {
		assertEquals(75, arquero.obtenerVida());
	}
	
	@Test
	public void test02ArqueroSeCreaConUnCostoDe75() {
		assertEquals(75, arquero.obtenerCosto());
	}
	
	@Test
	public void arqueroAtacaACualquierUnidadYLeResta15DeVida() { //Pruebo con espadachin
		Espadachin espadachin = new Espadachin();
		int vidaActual = espadachin.obtenerVida();
		arquero.atacar(espadachin);
		assertEquals(vidaActual-15, espadachin.obtenerVida());
	}
	
	@Test
	public void arqueroAtacaACualquierEdificioYLeResta10DeVida() { //Pruebo con cuartel
		Cuartel cuartel = new Cuartel();
		int vidaActual = cuartel.obtenerVida();
		arquero.atacar(cuartel);
		assertEquals(vidaActual-10, cuartel.obtenerVida());
	}

}