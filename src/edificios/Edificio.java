package edificios;
import areaJuego.Posicion;
import interfaces.Atacable;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected VidaEdificio vida;
	protected int costo;
	protected int tamanio;
	protected Posicion posicion;
	
	
	public int obtenerVida() {
		return vida.obtenerVida();
	}
	
	public int obtenerCosto() {
		return this.costo;
	}
	
	public boolean reparar() {
		return vida.Reparar();
	}
	
	public void quitarVida(int danio) {
		vida.Daniar(danio);
	}
	
	public int obtenerTamanio() {
		return this.tamanio;
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
	public void esAtacadoPor(ArmaDeAsedio armaDeAsedio) {
		this.quitarVida(75);
	}
	
	public void esAtacadoPor(Espadachin espadachin) {
		this.quitarVida(15);
	}
	
	public void esAtacadoPor(Arquero arquero) {
		this.quitarVida(10);
	}
		
}
