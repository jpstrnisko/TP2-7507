package unidades;
import edificios.Edificio;

public abstract class Unidad {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;


	public int obtenerVida() {
		return this.vida;
	}

	public int obtenerCosto() {
		return this.costo;
	}
	
	public void atacarEdificio(Edificio edificio) {
		//Aca habria que tener una interface Atacable que implemente
		//edificios y unidades para no romper encapsulamiento y que cada
		//unidad sepa a quien atacar.
		//Tambien ver tema de distancias de ataque;
	}
}
