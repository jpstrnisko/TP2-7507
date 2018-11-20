package poblacion;

import edificios.PlazaCentral;
import unidades.Unidad;
import unidades.ArmaDeAsedio;


public class NivelPoblacion {
	
	private int poblacion = 0;
	private int limitePoblacion = 50;
	
	
	
	public void crearUnidad() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.crearUnidad();
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
		return limitePoblacion<50;
	}
	
}