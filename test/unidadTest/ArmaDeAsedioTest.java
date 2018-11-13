package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import unidades.ArmaDeAsedio;

public class ArmaDeAsedioTest {

	@Test
	public void test01ArmaDeAsedioSeCreaCon150DeVida() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		assertEquals(150, miArma.obtenerVida());
	}
	
	@Test
	public void test02ArmaDeAsedioSeCreaConUnCostoDe200() {
		ArmaDeAsedio miArma = new ArmaDeAsedio();
		assertEquals(200, miArma.obtenerCosto());
	}

}
