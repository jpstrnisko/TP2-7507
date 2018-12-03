package interfaces;
import areaJuego.Posicion;
import edificios.Edificio;
import unidades.Unidad;

public interface IAtacante {
	
	public abstract void atacar(Unidad unidad);
	public abstract void atacar(Edificio edificio);
	public abstract void seleccionarObjetivo(Atacable objetivo);
	public abstract int obtenerRangoAtaque();
	public abstract Posicion obtenerPosicion();
	public abstract Object obtenerJugador();
}
