package unidades;
import areaJuego.Posicion;
import interfaces.Atacable;

public abstract class Unidad implements Atacable {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
	protected Posicion posicion;

	public int obtenerVida() {
		return this.vida;
	}

	public int obtenerCosto() {
		return this.costo;
	}
	
	public void quitarVida(int danio) {
		this.vida -= danio;
	}
	
	public int obtenerDistanciaAtaque() {
		return this.distanciaMaximaAtaque;
	}
	
	public void establecerPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Posicion obtenerPosicion() {
		return this.posicion;
	}
	
	public void cambiarPosicion(Posicion destino) {
		this.posicion =  destino;
	}
}
