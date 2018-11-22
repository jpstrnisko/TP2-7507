package edificiosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.PlazaCentral;
import unidades.Aldeano;

public class PlazaCentralTest {
	
	PlazaCentral plazaCentral = new PlazaCentral();
	
	@Test
	public void laPlazaCentralCreaUnAldeano() {
		assert(plazaCentral.crearUnAldeano() instanceof Aldeano);
	}
	
	@Test
	public void alRepararUnaPlazaSuVidaAumentaEn25() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.quitarVida(25);
		plaza.reparar();
		assertEquals(plaza.obtenerVida(), 450);
	}
}
