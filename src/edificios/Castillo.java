package edificios;

import unidades.ArmaDeAsedio;
import unidades.Unidad;

public class Castillo extends Edificio {
	
	protected int velocidadReparacion = 15;
	protected int vidaInicial = 1000;
	protected int danioAEdificiosYUnidades = 20;
	protected EdificioAtacante atacante;
	protected int rango = 3;
	
	public Castillo() {
		this.costo = -1; //no se puede construir
		this.tamanio = 16;
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion);
		this.atacante = new EdificioAtacante(this, danioAEdificiosYUnidades, rango);
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}
	
	public void atacar(Edificio edificio) {
		this.atacante.atacar(edificio);
	}
	
	public void atacar(Unidad unidad) {
		this.atacante.atacar(unidad);
	}

}

