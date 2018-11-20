package edificios;
import interfaces.Atacable;
import unidades.ArmaDeAsedio;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected int vida;
	protected int costo;
	protected int velocidadReparacion;
	protected int tamanio;
	
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
	
	public int obtenerTamanio() {
		return this.tamanio;
	}
	
	public void atacar(Atacable atacable) {
		//Como se hace para que cada Edificio implemente este mensaje a su manera?
	}
	
	public void esAtacadoPor(ArmaDeAsedio armaDeAsedio) {
		this.quitarVida(75);
	}
	
	public void esAtacadoPor(Espadachin espadachin) {
		this.quitarVida(15);
	}
		
}
