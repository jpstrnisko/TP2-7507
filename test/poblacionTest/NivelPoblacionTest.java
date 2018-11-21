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
		poblacion.crearUnidad();
		assertEquals(1,poblacion.obtenerPoblacion());
		
	}
	
	@Test
	public void matarUnidadesBajaPoblacion() {
		Espadachin espadachin = new Espadachin();
		poblacion.crearUnidad();
		poblacion.crearUnidad();
		poblacion.crearUnidad();
		poblacion.matarUnidad(espadachin);
		assertEquals(2,poblacion.obtenerPoblacion());
		
		
	}
	
	@Test
	public void matarAldeanosBajaPoblacionYProduccionOro() {
		Aldeano aldeano = new Aldeano();
		poblacion.crearUnidad();
		poblacion.crearUnidad();
		poblacion.matarUnidad(aldeano);
		assertEquals(1,poblacion.obtenerPoblacion());
			
	}
	
}