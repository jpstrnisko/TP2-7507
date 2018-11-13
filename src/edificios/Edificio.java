package edificios;

public abstract class Edificio {
	
	protected int vida;
	protected int costo;
	protected int velocidadReparacion;
	
	public int obtenerVida() {
		return this.vida;
	}
	
	public int obtenerCosto() {
		return this.costo;
	}
	
	public void reparar() {
		this.vida += this.velocidadReparacion;
	}
	
	public void quitarVida(int danio) {
		this.vida -= danio;
	}
}
