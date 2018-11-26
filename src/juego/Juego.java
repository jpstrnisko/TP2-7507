package juego;

import java.util.List;
import java.util.stream.Collectors;

import areaJuego.Mapa;
import areaJuego.Posicion;
import interfaces.Atacable;
import turnos.Jugador;
import turnos.MaximoJugadoresError;
import turnos.SistemaTurnos;
import unidades.Aldeano;
import unidades.FabricaAldeanos;
import unidades.Unidad;

public class Juego {
	protected SistemaTurnos sistemaTurnos = new SistemaTurnos();
	protected Mapa mapa = new Mapa(25, 25);

	public void comenzarJuego() throws Exception {
		if (sistemaTurnos.obtenerCantidadJugadores() < 2) {
			throw new FaltanJugadoresError();
		}
		this.agregarUnidadesIniciales();
	}
	
	private void agregarUnidadesIniciales() throws Exception {
		FabricaAldeanos fabricaAldeanos = new FabricaAldeanos();
		Aldeano aldeano1 = fabricaAldeanos.crearAldeano(new Posicion(6, 3), sistemaTurnos.obtenerJugadores().get(0));
		this.mapa.colocarAtacable(aldeano1.obtenerPosicion(), aldeano1);
		Aldeano aldeano2 = fabricaAldeanos.crearAldeano(new Posicion(9, 5), sistemaTurnos.obtenerJugadores().get(0));
		this.mapa.colocarAtacable(aldeano2.obtenerPosicion(), aldeano2);
		Aldeano aldeano3 = fabricaAldeanos.crearAldeano(new Posicion(11, 3), sistemaTurnos.obtenerJugadores().get(0));
		this.mapa.colocarAtacable(aldeano3.obtenerPosicion(), aldeano3);
		Aldeano aldeano4 = fabricaAldeanos.crearAldeano(new Posicion(15, 22), sistemaTurnos.obtenerJugadores().get(1));
		this.mapa.colocarAtacable(aldeano4.obtenerPosicion(), aldeano4);
		Aldeano aldeano5 = fabricaAldeanos.crearAldeano(new Posicion(17, 20), sistemaTurnos.obtenerJugadores().get(1));
		this.mapa.colocarAtacable(aldeano5.obtenerPosicion(), aldeano5);
		Aldeano aldeano6 = fabricaAldeanos.crearAldeano(new Posicion(20, 22), sistemaTurnos.obtenerJugadores().get(1));
		this.mapa.colocarAtacable(aldeano6.obtenerPosicion(), aldeano6);
	}

	public void agregegarJugador(Jugador jugador) throws MaximoJugadoresError {
		sistemaTurnos.agregarJugador(jugador);
	}

	public List<Jugador> obtenerJugadores() {
		return sistemaTurnos.obtenerJugadores();
	}

	public Mapa obtenerMapa() {
		return mapa;
	}

	public List<Unidad> obtenerUnidades() {
		return mapa.obtenerUnidades();
	}

	public List<Unidad> obtenerUnidadesDelJugador(Jugador jugador) {
		List<Unidad> unidadesDelJugador = mapa.obtenerUnidades().stream()
			    .filter(p -> p.obtenerJugador() == jugador).collect(Collectors.toList());
		return unidadesDelJugador;
	}

	public Object obtenerPoblacion(Jugador jugador) {
		return this.obtenerUnidadesDelJugador(jugador).size();
	}

}
