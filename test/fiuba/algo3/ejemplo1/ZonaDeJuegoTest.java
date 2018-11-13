package fiuba.algo3.ejemplo1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ZonaDeJuegoTest {
	
	private ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	
	@Test
	public void celdaNollegoAlFinalDeLaZonaDeJuego() {
		
		zonaDeJuego.cantidadFilas = 10;
		zonaDeJuego.cantidadColumnas = 10;
		
		assertEquals(true, zonaDeJuego.nollegoAlFinal(3,3));
	}
	
	
}