package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Arquero;

public class ArqueroTest {

	@Test
	public void test01ArqueroSeCreaCon75DeVida() {
		Arquero arquero = new Arquero();
		assertEquals(75, arquero.obtenerVida());
	}
	
	@Test
	public void test02ArqueroSeCreaConUnCostoDe75() {
		Arquero arquero = new Arquero();
		assertEquals(75, arquero.obtenerCosto());
	}

}
