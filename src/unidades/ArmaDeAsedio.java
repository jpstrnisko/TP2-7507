package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


public class ArmaDeAsedio extends Unidad{
	
	protected EstadoArmaAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
		this.estado = new EstadoDesmontada();
	}

	@Override
	public void atacar(Edificio edificio) {
		this.estado.atacar(edificio); //Solo puede atacar edificios
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


	public void montar() {
		this.estado = new EstadoMontada();
	}


	public void desmontar() {
		this.estado = new EstadoDesmontada();		
	}


	public boolean estaMontada() {
		return this.estado.estaMontada();
	}

	@Override
	public void atacar(Atacable atacable) {
		// TODO Auto-generated method stub
		
	}

}
