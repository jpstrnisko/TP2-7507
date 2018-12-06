package turnos;

import poblacion.NivelPoblacion;


public class Jugador {
	
	protected String nombre;
	protected int oro = 100;
	protected NivelPoblacion poblacion;
	
		
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.poblacion = new NivelPoblacion();
	}

	public String obtenerNombre() {
		return nombre;
	}
	
	public int obtenerOro() {
		return oro;
	}

	public void aumentarOro(int cantidadDeOro) {
		if(cantidadDeOro > 0)
			this.oro += cantidadDeOro;	
	}

	public void cambiarNombre(String nombreJug) {
		nombre = nombreJug;
	}

	public boolean quitarOro(int cantidad) {
		if (oro < cantidad)
			return false;
		oro -= cantidad;
		return true;

	}
	
	public void agregarUnidad() {
		this.poblacion.agregarUnidad();
	}
	
	public void restarUnidad() {
		this.poblacion.seEliminoUnaUnidad();
	}
	
	public int obtenerPoblacion() {
		return this.poblacion.obtenerPoblacion();
	}
		
	public boolean llegoAlLimiteDePoblacion() {
		return this.poblacion.llegoAlLimiteDePoblacion();
	}
		
}
