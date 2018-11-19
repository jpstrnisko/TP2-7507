package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


public class ArmaDeAsedio extends Unidad{
	
	protected int danioAEdificios = 75;
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
	}

	
	@Override
	public void atacar(Edificio edificio) {
		edificio.quitarVida(this.danioAEdificios); //Solo puede atacar edificios
	}
	
	@Override
	public void atacar(Unidad unidad) {
		unidad.quitarVida(0);
	}

	@Override
	public boolean moverA(Posicion posicion) {
		// TODO Auto-generated method stub
		return false;
	}


}
