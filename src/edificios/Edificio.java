package edificios;
import interfaces.Atacable;

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
		
}
