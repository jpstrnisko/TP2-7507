package interfaces;
import areaJuego.Posicion;
import edificios.Edificio;
import unidades.Unidad;

public interface Atacable {
	void quitarVida(int danio);
	int obtenerTamanio();
//PATRON DOUBLE DISPATCH
	boolean estaEnRangoDe(int rangoDeAtaque, IAtacante atacante);
	boolean estaOcupando(Posicion posicion);
}
