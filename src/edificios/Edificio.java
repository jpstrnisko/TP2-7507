package edificios;
import java.util.ArrayList;
import java.util.List;

import areaJuego.Posicion;
import interfaces.Atacable;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected VidaEdificio vida;
	protected int costo;
	protected int tamanio;
	protected List<Posicion> posiciones = new ArrayList<Posicion>();

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
		for(int i = 0; i < Math.sqrt(tamanio); i++) {
			for(int j = 0; j < Math.sqrt(tamanio); j++) {
				posiciones.add(posicion.obtenerNuevaPosicionVariadaEn(i, j));
			}
		}
	}
	
	public List<Posicion> obtenerPosiciones() {
		return this.posiciones;
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
