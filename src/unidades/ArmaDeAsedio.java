package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;
import interfaces.IAtacante;


public class ArmaDeAsedio extends Unidad implements IAtacante {
	
	protected int danioAEdificios = 75;
	protected EstadoArmaDeAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
		this.estado = new EstadoDesmontada(this);
	}
	
	public boolean estaMontada() {
		return estado.estaMontada();
	}

	public void montar() {
		this.estado = new EstadoMontada(this);
	}

	public void desmontar() {
		this.estado = new EstadoDesmontada(this);
	}

	public boolean estaEnRangoDeAtaqueEnX(Posicion posicion) {
		return this.posicion.obtenerPosicionX() + posicion.obtenerPosicionX() <= this.distanciaMaximaAtaque;
	}
	
	public boolean estaEnRangoDeAtaqueEnY(Posicion posicion) {
		return this.posicion.obtenerPosicionY() + posicion.obtenerPosicionY() <= this.distanciaMaximaAtaque;
	}
	
	@Override
	public void atacar(Edificio edificio) {
		if(this.estaMontada() && (this.estaEnRangoDeAtaqueEnX(edificio.obtenerPosicion()) || this.estaEnRangoDeAtaqueEnY(edificio.obtenerPosicion())))
			edificio.quitarVida(this.danioAEdificios); //Solo puede atacar edificios
	}
	
	@Override
	public void atacar(Unidad unidad) {
		unidad.quitarVida(0);
	}
}
