package turnos;

public class Jugador {

	protected String nombre;
	protected int oro = 100;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public int obtenerOro() {
		return oro;
	}

	public void aumentarOro(int cantidadDeOro) {
		if(cantidadDeOro > 0)
			this.oro += cantidadDeOro;	
	}

	public boolean quitarOro(int cantidad) {
		if (oro < cantidad)
			return false;
		oro -= cantidad;
		return true;
	}
	
	

}
