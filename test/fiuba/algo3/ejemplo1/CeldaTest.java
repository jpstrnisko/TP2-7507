package fiuba.algo3.ejemplo1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CeldaTest {
	
	private Celda celda = new Celda(2,2);
	
	@Test
	public void celdaSeCreaLibre() {
	
		assertEquals(true, celda.estaLibre());
	}
	
	@Test
	public void celdaOcupadaCuandoSeColocaUnaUnidad() {
		
		celda.posicionar();
		
		assertEquals(false, celda.estaLibre());
	}
	
	

	
	
}