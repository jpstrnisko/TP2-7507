package edificiosTest;

import static org.junit.Assert.fail;
import org.junit.Test;

import edificios.Cuartel;
import unidades.Arquero;
import unidades.Espadachin;

import org.junit.Assert;

public class CuartelTest {
	
	public static final Cuartel cuartel = new Cuartel();
	
	@Test
	public void elCuartelCreaUnEspadachin() {
		Assert.assertTrue(cuartel.crearUnEspadachin() instanceof Espadachin);
	}
	
	@Test
	public void elCuartelCreaUnArquero() {
		Assert.assertTrue(cuartel.crearUnArquero() instanceof Arquero);
	}
	
	@Test
	public void elCuartelSeCreaCon250DeVida() {
		Assert.assertEquals(cuartel.obtenerVida(), 250);
	}
	
	@Test
	public void alRepararUnCuartelLaVidaAumentaEn50() {
		cuartel.quitarVida(50);
		cuartel.reparar();
		Assert.assertEquals(cuartel.obtenerVida(),250);
	}
	
}
