package poblacion;

import unidades.ArmaDeAsedio;
import unidades.Unidad;
import edificios.PlazaCentral;



public class NivelPoblacion {
	
	private int poblacion = 0;
	private int limitePoblacion = 50;
	
		
	public void crearUnidad() {
		poblacion += 1;
	}
	
	public void matarUnidad(Unidad unidad) {
		ArmaDeAsedio arma = new ArmaDeAsedio();
		arma.atacar(unidad);
		poblacion -= 1;
	}
	
	public int obtenerPoblacion() {
		return poblacion;
	}
	
	public boolean noSuperaLimitePoblacion( ) {
		return poblacion<limitePoblacion;
	}
	
}