package poblacionTest;

import poblacion.NivelPoblacion;
import unidades.Aldeano;
import unidades.Espadachin;
import unidades.Arquero;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class NivelPoblacionTest {
	
	NivelPoblacion poblacion = new NivelPoblacion();
	
	@Test
	public void crearUnidadesAumentaPoblacion() {
		poblacion.agregarUnidad();
		assertEquals(1,poblacion.obtenerPoblacion());
		
	}
	
	@Test
	public void matarUnidadesBajaPoblacion() {
		poblacion.agregarUnidad();
		poblacion.agregarUnidad();
		poblacion.agregarUnidad();
		poblacion.seEliminoUnaUnidad();
		assertEquals(2,poblacion.obtenerPoblacion());
		
		
	}
	
	@Test
	public void matarAldeanosBajaPoblacionYProduccionOro() {
		poblacion.agregarUnidad();
		poblacion.agregarUnidad();
		poblacion.seEliminoUnaUnidad();
		assertEquals(1,poblacion.obtenerPoblacion());
			
	}
	
	@Test
	public void noSePuedePasarElMaximoDePoblacion() {
		for(int cantidad = 1; cantidad <= 50; cantidad++)
			poblacion.agregarUnidad();
		assertEquals(50,poblacion.obtenerPoblacion());
		poblacion.agregarUnidad();	
		assertEquals(50,poblacion.obtenerPoblacion());
	}
	
}