package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;
import unidades.Aldeano;
import edificios.PlazaCentral;
import edificios.Cuartel;

public class AldeanoTest {

	@Test
	public void aldeanoSeCreaCon50DeVida() {
		Aldeano aldeano = new Aldeano();
		assertEquals(50, aldeano.obtenerVida());
	}
	@Test
	public void aldeanoSeCreaConUnCostoDe25() {
		Aldeano aldeano = new Aldeano();
		assertEquals(25, aldeano.obtenerCosto());
	}
	
	@Test
	public void aldeanoConstruyePlazaCentral() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirPlaza() instanceof PlazaCentral);
	}
	
	@Test
	public void aldeanoConstruyeCuartel() {
		Aldeano aldeano = new Aldeano();
		assert(aldeano.construirCuartel() instanceof Cuartel);
	}
}
