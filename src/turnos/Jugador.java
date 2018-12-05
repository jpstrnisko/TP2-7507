package turnos;

import turnos.TurnoMovimientoHabilitado;
import poblacion.NivelPoblacion;


public class Jugador {
	
	protected String nombre;
	protected int oro = 100;
	private TurnoMovimientoHabilitado turno;
		
	public Jugador(String nombre) {
		this.nombre = nombre;
		
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
	
		
}
