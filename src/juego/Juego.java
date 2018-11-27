package juego;

import java.util.List;
import java.util.stream.Collectors;

import areaJuego.Mapa;
import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Edificio;
import edificios.FabricaEdificios;
import edificios.PlazaCentral;
import edificios.FabricaEdificios;
import interfaces.Atacable;
import turnos.Jugador;
import turnos.MaximoJugadoresError;
import turnos.SistemaTurnos;
import unidades.Aldeano;
import unidades.FabricaAldeano;
import unidades.Unidad;

public class Juego {
	private static Juego instancia = null;
	
	protected SistemaTurnos sistemaTurnos;
	protected Mapa mapa;
	protected Jugador ganador;

	private Juego() {
		sistemaTurnos = new SistemaTurnos();
		mapa = new Mapa(25, 25);
		ganador = null;
	}
	
	public static Juego obtenerInstancia() {
		if(instancia == null)
			instancia = new Juego();
		return instancia;
	}
	
	public static Juego obtenerNuevaInstancia() {
		/*M�todo que crea y devuelve una instancia nueva de juego, usar
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
		FabricaEdificios fabricaEdificios = new FabricaEdificios();
		
		fabricaAldeanos.crearAldeano(new Posicion(6, 4), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(9, 6), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(11, 4), jugador1);
		fabricaAldeanos.crearAldeano(new Posicion(15, 22), jugador2);
		fabricaAldeanos.crearAldeano(new Posicion(17, 20), jugador2);
		fabricaAldeanos.crearAldeano(new Posicion(20, 22), jugador2);
		
		fabricaEdificios.crearEdificio(PlazaCentral.class, new Posicion(8, 2), jugador1);
		fabricaEdificios.crearEdificio(PlazaCentral.class, new Posicion(17, 22), jugador2);
		
		fabricaEdificios.crearEdificio(Castillo.class, new Posicion(13, 2), jugador1);
		fabricaEdificios.crearEdificio(Castillo.class, new Posicion(7, 21), jugador2);
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

	public int obtenerPoblacion(Jugador jugador) {
		return this.obtenerUnidadesDelJugador(jugador).size();
	}

	public List<Edificio> obtenerEdifciosDelJugador(Jugador jugador) {
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
		List<Jugador> jugadores = sistemaTurnos.obtenerJugadores();
		if(jugadores.get(0) == jugadorPerdedor) 
			ganador = jugadores.get(1);
		else
			ganador = jugadores.get(0);
	}

}