package edificios;
import interfaces.Atacable;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected VidaEdificio vida;
	protected int costo;
	protected int tamanio;
	
	
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
	
	public int celdasAOcupar() {
		return ((this.tamanio/2)-1);
		
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
