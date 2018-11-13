package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Aldeano;

public class AldeanoTest {

	@Test
	public void test01AldeanoSeCreaCon50DeVida() {
		Aldeano aldeano = new Aldeano();
		assertEquals(50, aldeano.obtenerVida());
	}
	@Test
	public void test02AldeanoSeCreaConUnCostoDe25() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.obtenerCosto());
	}
}
