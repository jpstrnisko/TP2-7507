package juego;

import java.util.List;
import java.util.stream.Collectors;

import areaJuego.Mapa;
import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Edificio;
import edificios.PlazaCentral;
import turnos.Jugador;
import turnos.MaximoJugadoresError;
import turnos.SistemaTurnos;
import unidades.FabricaAldeano;
import unidades.Unidad;


public class Juego {
	private static Juego instancia = null;
	
	protected SistemaTurnos sistemaTurnos;
	protected Mapa mapa;
	protected Jugador ganador;


	private Juego() {
		sistemaTurnos = new SistemaTurnos();
		mapa = new Mapa(26, 20);
		ganador = null;
	}
	
	public static Juego obtenerInstancia() {
		if(instancia == null)
			instancia = new Juego();
		return instancia;
	}
	
	public static Juego obtenerNuevaInstancia() {
		/*Metodo que crea y devuelve una instancia nueva de juego, usar
		 * solo para pruebas unitarias.
		 */
		instancia = new Juego();
		return instancia;
	}
	
	public void comenzarJuego() throws Exception {
		if (sistemaTurnos.obtenerCantidadJugadores() < 2) {
			throw new FaltanJugadoresError();
		}
		this.agregarUnidadesIniciales();
		
	}
	
	private void agregarUnidadesIniciales() throws Exception {
		Jugador jugador1 = sistemaTurnos.obtenerJugadores().get(0);
		Jugador jugador2 = sistemaTurnos.obtenerJugadores().get(1);
		FabricaAldeano fabricaAldeanos = new FabricaAldeano();
		FabricaEdificiosConstruidos fabricaEdificios = new FabricaEdificiosConstruidos();
		
		fabricaAldeanos.crearAldeano(new Posicion(2, 7), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(3, 9), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(2, 10), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(23, 9), jugador2);
		fabricaAldeanos.crearAldeano(new Posicion(22, 10), jugador2);
		fabricaAldeanos.crearAldeano(new Posicion(23, 12), jugador2);
		fabricaEdificios.crearEdificio(PlazaCentral.class, new Posicion(1, 8), jugador1);
		fabricaEdificios.crearEdificio(PlazaCentral.class, new Posicion(23, 10), jugador2);
		
		fabricaEdificios.crearEdificio(Castillo.class, new Posicion(1, 1), jugador1);
		fabricaEdificios.crearEdificio(Castillo.class, new Posicion(21, 15), jugador2);
		
	}

	public void agregarJugador(Jugador jugador) throws MaximoJugadoresError {
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
	
	public void moverUnidad(Jugador jugador, Posicion nuevaPosicion) {
		this.obtenerUnidadesDelJugador(jugador).get(0).cambiarPosicion(nuevaPosicion);
	}	

	public int obtenerPoblacion(Jugador jugador) {
		return this.obtenerUnidadesDelJugador(jugador).size();
	}

	public List<Edificio> obtenerEdificiosDelJugador(Jugador jugador) {
		List<Edificio> edificiosDelJugador = mapa.obtenerEdificios().stream()
			    .filter(p -> p.obtenerJugador() == jugador).collect(Collectors.toList());
		return edificiosDelJugador;
	}

	public boolean finalizo() {
		if(ganador == null) {
			return false;
		}
		return true;
	}

	public Jugador obtenerGanador() {
		return ganador;
	}

	public void esDerrotado(Jugador jugadorPerdedor) {
		ganador = this.obtenerEnemigo(jugadorPerdedor);
	}

	public Jugador obtenerJugadorActual() {
		return sistemaTurnos.obtenerJugadorActual();
	}

	public void avanzarTurno() throws Exception {
		for (Edificio edificio: obtenerEdificiosDelJugador(sistemaTurnos.obtenerJugadorActual()))
			edificio.realizarAccion();
		for (Unidad unidad: obtenerUnidadesDelJugador(sistemaTurnos.obtenerJugadorActual()))
			unidad.realizarAccion();
		sistemaTurnos.avanzarTurno();
	}

	public Jugador obtenerEnemigo(Jugador jugador) {
		List<Jugador> jugadores = sistemaTurnos.obtenerJugadores();
		if(jugadores.get(0) == jugador) 
			return jugadores.get(1);
		else
			return jugadores.get(0);
	}

	public List<Edificio> obtenerEdificios() {
		return mapa.obtenerEdificios();
	}

}
