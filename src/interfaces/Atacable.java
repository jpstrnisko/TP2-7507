package interfaces;
import areaJuego.Posicion;
import edificios.Edificio;
import turnos.Jugador;
import unidades.Unidad;

public interface Atacable {
	void quitarVida(int danio);
	int obtenerTamanio();
	boolean estaEnRangoDe(int rangoDeAtaque, IAtacante atacante);
	boolean estaOcupando(Posicion posicion);
	Jugador obtenerJugador();
	int obtenerVida();
	int obtenerVidaMaxima();

}
