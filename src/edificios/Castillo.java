package edificios;

import juego.Juego;
import unidades.Aldeano;
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
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion, this);
		this.atacante = new EdificioAtacante(this, danioAEdificiosYUnidades, rango);
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}
	
	public void comenzarProduccionArmaDeAsedio() {
		this.estadoEdificio.producir(new ArmaDeAsedio(), this);
	}
	
	@Override
	public void realizarAccion() throws Exception {
		for(Unidad unidad: Juego.obtenerInstancia().obtenerUnidades()) 
			this.atacante.atacar(unidad);
		
		for(Edificio edificio: Juego.obtenerInstancia().obtenerEdificios())
			this.atacante.atacar(edificio);
		
		this.productorUnidades.avanzar();
	}
	
	public void atacar(Edificio edificio) {
		this.atacante.atacar(edificio);
	}
	
	public void atacar(Unidad unidad) {
		this.atacante.atacar(unidad);
	}
	
	@Override
	public void destruir() {
		Juego.obtenerInstancia().obtenerMapa().removerAtacable(this);
		Juego juego = Juego.obtenerInstancia();
		juego.esDerrotado(this.obtenerJugador());
	}

}

