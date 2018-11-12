package pruebas;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import org.junit.Test;

import edificios.Cuartel;
import unidades.Arquero;
import unidades.Espadachin;

import org.junit.Assert;

public class CuartelTest {
	@Test
	public void elCuartelCreaUnEspadachin() {
		Cuartel cuartel = new Cuartel();
		Assert.assertTrue(cuartel.crearUnEspadachin() instanceof Espadachin);
	}
	
	@Test
	public void elCuartelCreaUnArquero() {
		Cuartel cuartel = new Cuartel();
		Assert.assertTrue(cuartel.crearUnArquero() instanceof Arquero);
	}
	
	@Test
	public void elCuartelSeCreaCon250DeVida() {
		Cuartel cuartel = new Cuartel();
		Assert.assertEquals(cuartel.obtenerVida(), 250);
	}
}
