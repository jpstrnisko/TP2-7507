package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import unidades.Espadachin;

public class EspadachinTest {

	@Test
	public void test01EspadachinSeCreaCon100DeVida() {
		Espadachin espadachin = new Espadachin();
		assertEquals(100, espadachin.obtenerVida());
	}
	
	@Test
	public void test02EspadachinSeCreaConUnCostoDe50() {
		Espadachin espadachin = new Espadachin();
		assertEquals(50, espadachin.obtenerCosto());
	}

}