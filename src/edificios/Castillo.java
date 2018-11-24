package edificios;
import interfaces.IAtacante;
import unidades.ArmaDeAsedio;
import unidades.Unidad;

public class Castillo extends Edificio implements IAtacante {
	
	protected int danioGenerado = 20; //Tanto a unidades como a otros edificios.
	
	public Castillo() {
		this.costo = -1;
		this.tamanio = 16;
		int velocidadReparacion = 15;
		int vidaInicial = 1000;
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion);
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}
	
	@Override
	public void atacar(Edificio edificio) {
		edificio.quitarVida(this.danioGenerado);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		unidad.quitarVida(this.danioGenerado);
	}

}

