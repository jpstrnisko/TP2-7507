package pruebas;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import org.junit.Test;

import edificios.Cuartel;
import unidades.Arquero;
import unidades.Espadachin;

import org.junit.Assert;

public class CuartelTest {

	Cuartel cuartel = new Cuartel();
			
	@Test
	public void elCuartelCreaUnEspadachin() {
		Assert.assertTrue(cuartel.crearUnEspadachin() instanceof Espadachin);
	}
	
	public void elCuartelCreaUnArquero() {
		Assert.assertTrue(cuartel.crearUnArquero() instanceof Arquero);
	}

}
