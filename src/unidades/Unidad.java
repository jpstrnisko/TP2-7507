package unidades;
import interfaces.Atacable;

public abstract class Unidad implements Atacable {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
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
	
	public void atacar(Atacable atacable) {
		//como se hace para que este metodo lo implemente cada Unidad a su manera?
	}
}
