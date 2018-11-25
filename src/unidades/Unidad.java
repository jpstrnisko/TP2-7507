package unidades;
import interfaces.Atacable;
import areaJuego.Posicion;

public abstract class Unidad implements Atacable {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
	protected Posicion posicion;
	protected int tamanio = 1; //1 casillero
	//protected TurnoMovimiento turnoMovimiento;

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
	
	public int obtenerTamanio() {
		return this.tamanio;
	}
	
	public void atacar(Atacable atacable) {
		//como se hace para que este metodo lo implemente cada Unidad a su manera?
	}
	
	public void esAtacadoPor(ArmaDeAsedio armaDeAsedio) {
		this.quitarVida(0);
	}
	
	public void esAtacadoPor(Espadachin espadachin) {
		this.quitarVida(25);
	}
}
