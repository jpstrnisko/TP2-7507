package poblacion;



public class NivelPoblacion {
	
	private int poblacion = 0;
	private int limitePoblacion = 50;
	
		
	public void agregarUnidad() {
		if(!llegoAlLimiteDePoblacion())
			poblacion += 1;
	}
	
	public void seEliminoUnaUnidad() {
		if(poblacion > 0)
			poblacion -= 1;
	}
	
	public int obtenerPoblacion() {
		return poblacion;
	}
	
	public boolean llegoAlLimiteDePoblacion( ) {
		return poblacion == limitePoblacion;
	}
	
}