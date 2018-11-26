package areaJuegTest;
import static org.junit.Assert.*;
import org.junit.Test;
import areaJuego.Posicion;

public class PosicionTest {

	@Test
	public void seCreaPosicionEnFila2Columna0DeberiaDevolverF2C0() {
		
		Posicion posicion = new Posicion(2,0);
		assertEquals(posicion.obtenerPosicionX(), 2);
		assertEquals(posicion.obtenerPosicionY(), 0);
		
	}
}
