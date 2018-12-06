package juegoTest;

import static org.junit.Assert.*;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import areaJuego.Mapa;
import areaJuego.Posicion;
import areaJuego.PosicionOcupadaError;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import juego.Juego;
import turnos.Jugador;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;
import unidades.Unidad;
import juego.FaltanJugadoresError;
import turnos.MaximoJugadoresError;

public class ReglasJuegoTest {
	
	@Test(expected = FaltanJugadoresError.class)
	public void elJuegoNoSePodriaComenzarSinJugadores() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		juego.comenzarJuego();
	}

	@Test(expected = FaltanJugadoresError.class)
	public void elJuegoNoSePodriaComenzarConSoloUnJugador() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		juego.agregarJugador(jugador1);
		juego.comenzarJuego();
	}
	
	@Test(expected = MaximoJugadoresError.class)
	public void noSeDeberiaPoderAgregarMasDeDosJugadores() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		Jugador jugador3 = new Jugador("Lucas");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.agregarJugador(jugador3);
		juego.comenzarJuego();
	}
	
	@Test
	public void cadaJugadorDeberiaComenzarCon100DeOro() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		assertEquals(juego.obtenerJugadores().get(0).obtenerOro(), 100);
		assertEquals(juego.obtenerJugadores().get(1).obtenerOro(), 100);
	}
	
	@Test
	public void elJuegoDeberiaComenzarConUnMapaDe26x20() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		assertEquals(juego.obtenerMapa().obtenerAlto(), 20);
		assertEquals(juego.obtenerMapa().obtenerAncho(), 26);
	}
	
	@Test
	public void elJuegoDeberiaComenzarCon6Aldeanos() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		assertEquals(juego.obtenerUnidades().size(), 6);
		for(int i = 0; i < 6; i++) {
			assert(juego.obtenerUnidades().get(i) instanceof Aldeano);
		}
	}
	
	@Test
	public void elJugador1DeberiaComenzarCon3Aldeanos() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Unidad> unidadesJugador1 = juego.obtenerUnidadesDelJugador(jugador1);
		assertEquals(unidadesJugador1.size(), 3);
		for(int i = 0; i < 3; i++) {
			assert(unidadesJugador1.get(i) instanceof Aldeano);
		}
	}
	
	@Test
	public void elJugador2DeberiaComenzarCon3Aldeanos() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Unidad> unidadesJugador2 = juego.obtenerUnidadesDelJugador(jugador2);
		assertEquals(unidadesJugador2.size(), 3);
		for(int i = 0; i < 3; i++) {
			assert(unidadesJugador2.get(i) instanceof Aldeano);
		}
	}
	
	@Test
	public void elJugador1DeberiaComenzarCon3DePoblacion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador1), 3);
	}
	
	@Test
	public void elJugador2DeberiaComenzarCon3DePoblacion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador2), 3);
	}
	
	@Test
	public void cadaJugadorDeberiaComenzarConUnaPlazaCentralYUnCastillo() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Edificio> edificios = juego.obtenerEdificiosDelJugador(jugador1);
		assertEquals(2, edificios.size());
		
		if(edificios.get(0) instanceof Castillo) {
			assert(edificios.get(0) instanceof Castillo);
			assert(edificios.get(1) instanceof PlazaCentral);
		}
		else {
			assert(edificios.get(0) instanceof PlazaCentral);
			assert(edificios.get(1) instanceof Castillo);
		}
		
	}
	
	@Test
	public void siSeDestruyeUnCastilloElOtroJugadorDeberiaGanar() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Edificio> edificios = juego.obtenerEdificiosDelJugador(jugador1);
		Castillo castillo = null;
		for(Edificio edificio: edificios) {
			if(edificio instanceof Castillo)
				castillo = (Castillo) edificio;
		}
		
		castillo.quitarVida(1000);

		assertTrue(juego.finalizo());
		assertEquals(juego.obtenerGanador(), jugador2);
	}
	
	@Test
	public void siLosCastillosSiguenConVidaElJuegoDeberiaNoHaberFinalizado() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		assertFalse(juego.finalizo());
	}
	
	@Test
	public void siLosCastillosSiguenConVidaElJuegoDeberiaNoTenerGanador() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerGanador(), null);
	}
	
	@Test
	public void daniarUnaUnidadHastaMatarlaDeberiaRestarLaPoblacionDelJugador() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Unidad> unidadesJugador1 = juego.obtenerUnidadesDelJugador(jugador1);
		unidadesJugador1.get(0).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 2);
		
		unidadesJugador1.get(1).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 1);
		
		unidadesJugador1.get(2).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 0);
	}
	
	@Test
	public void aldeanoDeberiaPoderConstruirPlazaCentral() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(1,2));
		
		List<Edificio> edificios = juego.obtenerEdificiosDelJugador(jugador1);
		assertEquals(1, edificios.size());
		assert(edificios.get(0) instanceof PlazaCentral);
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(1, 2)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(1, 3)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(2, 2)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(2, 3)));
	}
	
	@Test
	public void aldeanoDeberiaPoderConstruirCuartel() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(1,2));
		
		List<Edificio> edificios = juego.obtenerEdificiosDelJugador(jugador1);
		assertEquals(1, edificios.size());
		assert(edificios.get(0) instanceof Cuartel);
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(1, 2)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(1, 3)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(2, 2)));
		assert(edificios.get(0).obtenerPosiciones().contains(new Posicion(2, 3)));
	}
	
	@Test
	public void unEdificioDeberiaEstarEnConstruccionAlComenzarloAConstruir() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(1,2));
		
		Edificio cuartel = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assert(cuartel.estaEnConstruccion());
	}
	
	@Test
	public void unAldeanoNoDeberiaPoderConstruirUnEdificioEnUnaPosicionAdyacente() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(6, 6));
		
		assertEquals(0, juego.obtenerEdificiosDelJugador(jugador1).size());
	}
	
	@Test
	public void comprueboCorrectamenteLasPosicionesDondeElAldeanoPuedeConstruirUnCuartel() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(4, 4);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(2, 2)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(2, 3)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(2, 4)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(2, 5)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(3, 2)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(3, 5)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(4, 2)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(4, 5)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(5, 2)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(5, 3)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(5, 4)));
		assert(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(5, 5)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(3, 3)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(3, 4)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(4, 3)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(4, 4)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(15, 4)));
		assertFalse(aldeano.estaAdyacenteAlEdificio(new Cuartel(), new Posicion(4, 20)));
	}
	
	@Test
	public void unCuartelDeberiaTardar3TurnosEnConstruirse() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(1,2));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		Edificio cuartel = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertFalse(cuartel.estaEnConstruccion());
	}
	
	@Test
	public void unEdificioDeberiaTener0DeVidaAlComenzarAConstruirse() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(1,2));
		
		Edificio cuartel = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertEquals(0, cuartel.obtenerVida());
	}
	
	@Test
	public void unCuartelDeberiaTener250DeVidaAFinalizarLaConstruccion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirCuartel(new Posicion(1,2));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		Edificio cuartel = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertEquals(250, cuartel.obtenerVida());
	}
	
	@Test
	public void unaPlazaCentralDeberiaTener450DeVidaAFinalizarLaConstruccion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(1,2));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertEquals(450, plazaCentral.obtenerVida());
	}
	
	@Test
	public void unEdificioDeberiaCorresponderAlJugadorQueLoConstruye() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(1,2));
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertEquals(jugador1, plazaCentral.obtenerJugador());
	}
	
	@Test
	public void unaUnidadNoSeDeberiaPoderMoverAUnaPosicionQueNoEsAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);

		aldeano.mover(new Posicion(20, 1));
		assertEquals(posicionAldeano, aldeano.obtenerPosicion());
		aldeano.mover(new Posicion(1, 20));
		assertEquals(posicionAldeano, aldeano.obtenerPosicion());
		aldeano.mover(new Posicion(3, 3));
		assertEquals(posicionAldeano, aldeano.obtenerPosicion());
	}
	
	@Test
	public void unaUnidadSeDeberiaPoderMoverAUnaPosicionAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(1, 1);
		Posicion nuevaPosicionAldeano = new Posicion(2, 1);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		

		aldeano.mover(nuevaPosicionAldeano);
		assertEquals(nuevaPosicionAldeano, aldeano.obtenerPosicion());
	}
	
	@Test
	public void unaUnidadNoSeDeberiaPoderMoverAUnaPosicionOcupada() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		
		Aldeano aldeano1 = new Aldeano();
		Aldeano aldeano2 = new Aldeano();
		aldeano1.cambiarJugador(jugador1);
		aldeano2.cambiarJugador(jugador1);

		Posicion posicionAldeano1 = new Posicion(1, 1);
		Posicion posicionAldeano2 = new Posicion(2, 1);
		aldeano1.cambiarPosicion(posicionAldeano1);
		aldeano2.cambiarPosicion(posicionAldeano2);
		
		mapa.colocarAtacable(posicionAldeano1, aldeano1);
		mapa.colocarAtacable(posicionAldeano2, aldeano2);
		
		aldeano1.mover(posicionAldeano2);
		assertEquals(posicionAldeano1, aldeano1.obtenerPosicion());
	}
	
	@Test
	public void moverAUnAldeanoQueEstabaConstruyendoUnEdificioDeberiaDetenerLaConstruccion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.mover(new Posicion(4, 5));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		assertEquals(plazaCentral.obtenerVida(), 0);
		assert(plazaCentral.estaEnConstruccion());
	}
	
	@Test
	public void unAldeanoDeberiaProducir20DeOroPorTurno() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		assertEquals(jugador1.obtenerOro(), 100);
		aldeano.realizarAccion();
		
		assertEquals(jugador1.obtenerOro(), 120);
	}
	
	@Test
	public void unAldeanoNoDeberiaProducirOroSiEstaConstruyendoUnEdificio() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		int oroInicial = jugador1.obtenerOro();
		oroInicial -= (new PlazaCentral()).obtenerCosto();
		
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();

		assertEquals(jugador1.obtenerOro(), oroInicial);
	}
	
	@Test
	public void unAldeanoNoDeberiaProducirOroSiEstaReparandoUnEdificio() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		
		mapa.colocarAtacable(posicionAldeano, aldeano);
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		int oroInicial = jugador1.obtenerOro();
		
		Edificio plaza = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		plaza.quitarVida(50);
		
		aldeano.repararEdificio(plaza);
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		assertEquals(jugador1.obtenerOro(), oroInicial);
	}
	
	@Test
	public void alFinalizarUnaReparacionUnAldeanoDeberiaVolverAProducirOro() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		
		mapa.colocarAtacable(posicionAldeano, aldeano);
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		int oroInicial =  jugador1.obtenerOro();
		
		Edificio plaza = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		plaza.quitarVida(50);
		
		aldeano.repararEdificio(plaza);
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		assertEquals(jugador1.obtenerOro(), oroInicial);
		
		aldeano.realizarAccion();
		assertEquals(jugador1.obtenerOro(), oroInicial + 20);
	}
	
	@Test
	public void unAldeanoDeberiaRepararUnEdificioAdyacenteHastaQueRecupereSuVidaMaxima() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		
		plazaCentral.quitarVida(50);
		assertEquals(plazaCentral.obtenerVida(), 400);
		
		aldeano.repararEdificio(plazaCentral);
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		assertEquals(plazaCentral.obtenerVida(), 450);
	}
	
	@Test
	public void unAldeanoNoDeberiaPoderRepararUnEdificioQueNoEsAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(6, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		aldeano.mover(new Posicion(4, 4));
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		
		plazaCentral.quitarVida(250);
		assertEquals(200, plazaCentral.obtenerVida());
		
		aldeano.repararEdificio(plazaCentral);
		aldeano.realizarAccion();
		
		assertEquals(200, plazaCentral.obtenerVida());
	}
	
	@Test
	public void unAldeanoDeberiaProducirOroSiSeLeOrdenaConstruirEnUnaPosicionNoAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		aldeano.construirPlazaCentral(new Posicion(10, 10));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		assertEquals(140, jugador1.obtenerOro());
	}
	
	@Test
	public void unEspadchinDeberiaPoderAtacarUnaUnidadAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Espadachin espadachin = new Espadachin();
		Posicion posicionEspadachin = new Posicion(6, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		espadachin.cambiarPosicion(posicionEspadachin);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		espadachin.seleccionarObjetivo(aldeano);
		espadachin.realizarAccion();
		
		assertEquals(25, aldeano.obtenerVida());
	}
	
	@Test
	public void unEspadchinNoDeberiaPoderAtacarUnaUnidadFueraDeSuRango() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Espadachin espadachin = new Espadachin();
		Posicion posicionEspadachin = new Posicion(7, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		espadachin.cambiarPosicion(posicionEspadachin);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		espadachin.seleccionarObjetivo(aldeano);
		espadachin.realizarAccion();
		
		assertEquals(50, aldeano.obtenerVida());
	}
	
	@Test
	public void unEspadchinDeberiaPoderAtacarUnEdificioAdyacente() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Espadachin espadachin = new Espadachin();
		Posicion posicionEspadachin = new Posicion(5, 5);
		Cuartel cuartel = new Cuartel();
		Posicion posicionCuartel = new Posicion(6, 5);
		espadachin.cambiarPosicion(posicionEspadachin);
		cuartel.establecerPosicion(posicionCuartel);
		espadachin.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionCuartel, cuartel);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		espadachin.seleccionarObjetivo(cuartel);
		espadachin.realizarAccion();
		
		assertEquals(235, cuartel.obtenerVida());
	}
	
	@Test
	public void unEspadchinNoDeberiaPoderAtacarUnEdificioQueNoEsteEnSuRango() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Espadachin espadachin = new Espadachin();
		Posicion posicionEspadachin = new Posicion(6, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		espadachin.cambiarPosicion(posicionEspadachin);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		espadachin.seleccionarObjetivo(aldeano);
		espadachin.realizarAccion();
		
		assertEquals(25, aldeano.obtenerVida());
	}
	
	@Test
	public void unArqueroDeberiaPoderAtacarUnaUnidadEnSuRangoDeAtaque() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Arquero arquero = new Arquero();
		Posicion posicionArquero = new Posicion(7, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		arquero.cambiarPosicion(posicionArquero);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionArquero, arquero);
		
		arquero.seleccionarObjetivo(aldeano);
		arquero.realizarAccion();
		
		assertEquals(35, aldeano.obtenerVida());
	}
	
	@Test
	public void unArqueroNoDeberiaPoderAtacarUnaUnidadFueraDeSuRangoDeAtaque() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Arquero arquero = new Arquero();
		Posicion posicionArquero = new Posicion(9, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		arquero.cambiarPosicion(posicionArquero);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionArquero, arquero);
		
		arquero.seleccionarObjetivo(aldeano);
		arquero.realizarAccion();
		
		assertEquals(50, aldeano.obtenerVida());
	}
	
	@Test
	public void unaUnidadQueEsMovidaLuegoDeSeleccionarObjetivoDeAtaqueNoDeberiaAtacar() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Arquero arquero = new Arquero();
		Posicion posicionArquero = new Posicion(6, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		arquero.cambiarPosicion(posicionArquero);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionArquero, arquero);
		
		arquero.seleccionarObjetivo(aldeano);
		arquero.mover(new Posicion(7, 5));
		arquero.realizarAccion();
		
		assertEquals(50, aldeano.obtenerVida());
	}
	
	@Test
	public void unaUnidadNoDeberiaAtacarUnidadesDeSuMismoEquipo() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Arquero arquero = new Arquero();
		Posicion posicionArquero = new Posicion(6, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		arquero.cambiarPosicion(posicionArquero);
		aldeano.cambiarJugador(jugador1);
		arquero.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionArquero, arquero);
		
		arquero.seleccionarObjetivo(aldeano);
		arquero.realizarAccion();
		
		assertEquals(50, aldeano.obtenerVida());
	}
	
	@Test
	public void unAldeanoNoDeberiaPoderRepararUnEdificioQueYaEstaSiendoReparado() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano1 = new Aldeano();
		Posicion posicionAldeano1 = new Posicion(5, 5);
		aldeano1.cambiarPosicion(posicionAldeano1);
		aldeano1.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano1, aldeano1);
		Aldeano aldeano2 = new Aldeano();
		Posicion posicionAldeano2 = new Posicion(4, 5);
		aldeano2.cambiarPosicion(posicionAldeano2);
		aldeano2.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano2, aldeano2);
		
		aldeano1.construirPlazaCentral(new Posicion(4, 6));
		aldeano1.realizarAccion();
		aldeano1.realizarAccion();
		aldeano1.realizarAccion();
		
		Edificio plazaCentral = juego.obtenerEdificiosDelJugador(jugador1).get(0);
		
		plazaCentral.quitarVida(50);
		assertEquals(plazaCentral.obtenerVida(), 400);
		
		aldeano1.repararEdificio(plazaCentral);
		aldeano2.repararEdificio(plazaCentral);
		aldeano1.realizarAccion();
		aldeano2.realizarAccion();
		
		assertEquals(425, plazaCentral.obtenerVida());
	}
	
	@Test
	public void unEdificioDeberiaProducirUnaUnidadEnSusAdyacencias() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));
		List<Posicion> posicionesAdyacentes = new ArrayList<Posicion>();
		posicionesAdyacentes.add(new Posicion(2, 2)); posicionesAdyacentes.add(new Posicion(2, 3));
		posicionesAdyacentes.add(new Posicion(2, 4)); posicionesAdyacentes.add(new Posicion(2, 5));
		posicionesAdyacentes.add(new Posicion(3, 2)); posicionesAdyacentes.add(new Posicion(3, 5));
		posicionesAdyacentes.add(new Posicion(4, 2)); posicionesAdyacentes.add(new Posicion(4, 5));
		posicionesAdyacentes.add(new Posicion(5, 2)); posicionesAdyacentes.add(new Posicion(5, 3));
		posicionesAdyacentes.add(new Posicion(5, 4)); posicionesAdyacentes.add(new Posicion(5, 5));
		
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		Unidad aldeano = juego.obtenerUnidadesDelJugador(jugador1).get(0);
		
		assert(posicionesAdyacentes.contains(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void unEdificioDeberiaProducirUnaUnidadEnSusAdyacenciasQueNoEstenOcupadas() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));
		plaza.finalizarConstruccion();
		mapa.colocarAtacable(new Posicion(3, 3), plaza);
		mapa.colocarAtacable(new Posicion(2, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 3), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 4), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(3, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(3, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(4, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(4, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 3), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 4), new Aldeano());
		
		Posicion posicionLibre = new Posicion(5, 5);
		
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		Unidad aldeano = juego.obtenerUnidadesDelJugador(jugador1).get(0);
		
		assertEquals(posicionLibre, aldeano.obtenerPosicion());
	}
	
	@Test
	public void unEdificioQueNoTienePosicionAdyacenteLibreNoDeberiaProducirUnaUnidad() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));
		mapa.colocarAtacable(new Posicion(3, 3), plaza);
		mapa.colocarAtacable(new Posicion(2, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 3), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 4), new Aldeano());
		mapa.colocarAtacable(new Posicion(2, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(3, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(3, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(4, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(4, 5), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 2), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 3), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 4), new Aldeano());
		mapa.colocarAtacable(new Posicion(5, 5), new Aldeano());
		
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		
		assertEquals(0, juego.obtenerUnidadesDelJugador(jugador1).size());
	}
	
	@Test
	public void producirUnAldeanoLeDeberiaRestar25DeOroAlJugadorProductor() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));
		plaza.finalizarConstruccion();
		
		int oroActual = jugador1.obtenerOro();
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		
		assertEquals(oroActual - 25, jugador1.obtenerOro());
	}
	
	@Test
	public void unJugadorQueNoPosea25DeOroDisponibleNoDeberiaPoderProducirUnAldeanoYNoPerderOro() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));
		
		jugador1.quitarOro(80);
		int oroActual = jugador1.obtenerOro();
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		
		assertEquals(oroActual, jugador1.obtenerOro());
		assertEquals(0, juego.obtenerUnidadesDelJugador(jugador1).size());
	}
	
	@Test
	public void unaUnidadProducidaPorUnEdificioDeberiaSerDelMismoJugadorDelEdificio() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(new Posicion(3, 3));

		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		
		assertEquals(jugador1, juego.obtenerUnidadesDelJugador(jugador1).get(0).obtenerJugador());
	}
	
	@Test
	public void unCuartelYaConstruidoDeberiaPoderProducirUnEspadachin() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Cuartel cuartel = new Cuartel();
		cuartel.finalizarConstruccion();
		cuartel.cambiarJugador(jugador1);
		cuartel.establecerPosicion(new Posicion(3, 3));

		cuartel.comenzarProduccionEspadachin();
		cuartel.realizarAccion();
		
		assert(juego.obtenerUnidadesDelJugador(jugador1).get(0) instanceof Espadachin);
	}
	
	@Test
	public void unCuartelYaConstruidoDeberiaPoderProducirUnArquero() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Cuartel cuartel = new Cuartel();
		cuartel.cambiarJugador(jugador1);
		cuartel.establecerPosicion(new Posicion(3, 3));
		cuartel.finalizarConstruccion();

		cuartel.comenzarProduccionArquero();
		cuartel.realizarAccion();
		
		assert(juego.obtenerUnidadesDelJugador(jugador1).get(0) instanceof Arquero);
	}
	
	@Test
	public void unEdificioNoDeberiaPoderProducirUnidadesSiEstaEnConstruccion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		
		int poblacionInicial = juego.obtenerPoblacion(jugador1);
		
		aldeano.construirPlazaCentral(new Posicion(5, 6));
		aldeano.realizarAccion();
		aldeano.realizarAccion();
		
		PlazaCentral plaza = (PlazaCentral) juego.obtenerEdificiosDelJugador(jugador1).get(0);
		
		plaza.comenzarProduccionAldeano();
		plaza.realizarAccion();
		
		assertEquals(poblacionInicial, juego.obtenerPoblacion(jugador1));
	}
	
	@Test
	public void alAvanzarUnTurnoElJugadorDeberiaObtener20DeOroPorCadaAldeano() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		Jugador jugadorActual = juego.obtenerJugadorActual();
		int oroInicial = jugadorActual.obtenerOro();
		juego.avanzarTurno();
		
		assertEquals(oroInicial + 60, jugadorActual.obtenerOro());
	}
	
	@Test
	public void unaUnidadNoSeDeberiaPoderMoverMasDeUnaVezPorTurno() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.comenzarJuego();
		
		Jugador jugadorActual = juego.obtenerJugadorActual();
		Unidad unidad = juego.obtenerUnidadesDelJugador(jugadorActual).get(0);
		Posicion posicionInicial = unidad.obtenerPosicion();
		Posicion nuevaPosicion = posicionInicial.obtenerNuevaPosicionVariadaEn(1, 0);
		unidad.mover(nuevaPosicion);
		unidad.mover(posicionInicial);
		
		assertEquals(unidad.obtenerPosicion(), nuevaPosicion);
	}
	
	@Test
	public void construirUnaPlazaCentralDeberiaRestar100DeOro() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		int oroInicial = jugador1.obtenerOro();
		
		aldeano.construirPlazaCentral(new Posicion(5, 6));

		assertEquals(oroInicial - 100, jugador1.obtenerOro());
	}
	
	@Test
	public void construirUnCuartelDeberiaRestar50DeOro() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		int oroInicial = jugador1.obtenerOro();
		
		aldeano.construirCuartel(new Posicion(5, 6));

		assertEquals(oroInicial - 50, jugador1.obtenerOro());
	}
	
	@Test
	public void unaUnidadSoloDebeQueSeLeOrdeneAtacarNoDeberiaAtacarElTurnoSiguienteSiNoRecibeNuevasOrdenes() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Mapa mapa = juego.obtenerMapa();
		Aldeano aldeano = new Aldeano();
		Posicion posicionAldeano = new Posicion(5, 5);
		Espadachin espadachin = new Espadachin();
		Posicion posicionEspadachin = new Posicion(6, 5);
		aldeano.cambiarPosicion(posicionAldeano);
		espadachin.cambiarPosicion(posicionEspadachin);
		aldeano.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionAldeano, aldeano);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		espadachin.seleccionarObjetivo(aldeano);
		espadachin.realizarAccion();
		
		assertEquals(25, aldeano.obtenerVida());
		
		espadachin.realizarAccion();
		assertEquals(25, aldeano.obtenerVida());
	}
	
	@Test
	public void unCastilloDeberiaQuitarAutomaticamente20DeDanioAUnidadesYEdificiosCercanosEnemigos() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		Mapa mapa = juego.obtenerMapa();
		
		Posicion posicionPlaza = new Posicion(4, 4);
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(posicionPlaza);
		mapa.colocarAtacable(posicionPlaza, plaza);

		Posicion posicionEspadachin = new Posicion(5, 10);
		Espadachin espadachin = new Espadachin();
		espadachin.cambiarPosicion(posicionEspadachin);
		espadachin.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		Posicion posicionCastillo = new Posicion(8, 4);
		Castillo castillo = new Castillo();
		castillo.finalizarConstruccion();
		castillo.cambiarJugador(jugador2);
		castillo.establecerPosicion(posicionCastillo);
		mapa.colocarAtacable(posicionCastillo, castillo);
		
		int vidaInicialEspadachin = espadachin.obtenerVida();
		int vidaInicialPlazaCentral = plaza.obtenerVida();
		
		castillo.realizarAccion();
		assertEquals(vidaInicialEspadachin - 20, espadachin.obtenerVida());
		assertEquals(vidaInicialPlazaCentral - 20, plaza.obtenerVida());
	}
	
	@Test
	public void unArmaDeAsedioDeberiaPoderAtacarAlEstarMontadaYEstarEnRangoDeAtaque() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		Mapa mapa = juego.obtenerMapa();
		
		Posicion posicionPlaza = new Posicion(4, 4);
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(posicionPlaza);
		mapa.colocarAtacable(posicionPlaza, plaza);

		Posicion posicionArmaDeAsedio = new Posicion(4, 7);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
		armaDeAsedio.cambiarPosicion(posicionArmaDeAsedio);
		armaDeAsedio.cambiarJugador(jugador2);
		mapa.colocarAtacable(posicionArmaDeAsedio, armaDeAsedio);
		
		int vidaInicialPlazaCentral = plaza.obtenerVida();
		armaDeAsedio.montar();
		armaDeAsedio.realizarAccion();
		armaDeAsedio.seleccionarObjetivo(plaza);
		armaDeAsedio.realizarAccion();

		assertEquals(vidaInicialPlazaCentral - 75, plaza.obtenerVida());
	}
	
	@Test
	public void unArmaDeAsedioNoDeberiaPoderAtacarUnidadesFueraDeSuRangoDeAtaque() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		Mapa mapa = juego.obtenerMapa();
		
		Posicion posicionPlaza = new Posicion(4, 4);
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(posicionPlaza);
		mapa.colocarAtacable(posicionPlaza, plaza);

		Posicion posicionArmaDeAsedio = new Posicion(4, 15);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
		armaDeAsedio.cambiarPosicion(posicionArmaDeAsedio);
		armaDeAsedio.cambiarJugador(jugador2);
		mapa.colocarAtacable(posicionArmaDeAsedio, armaDeAsedio);
		
		int vidaInicialPlazaCentral = plaza.obtenerVida();
		armaDeAsedio.montar();
		armaDeAsedio.realizarAccion();
		armaDeAsedio.seleccionarObjetivo(plaza);
		armaDeAsedio.realizarAccion();

		assertEquals(vidaInicialPlazaCentral, plaza.obtenerVida());
	}
	
	@Test
	public void unArmaDeAsedioDesmontadaNoDeberiaPoderAtacar() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		Mapa mapa = juego.obtenerMapa();
		
		Posicion posicionPlaza = new Posicion(4, 4);
		PlazaCentral plaza = new PlazaCentral();
		plaza.finalizarConstruccion();
		plaza.cambiarJugador(jugador1);
		plaza.establecerPosicion(posicionPlaza);
		mapa.colocarAtacable(posicionPlaza, plaza);

		Posicion posicionArmaDeAsedio = new Posicion(4, 7);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
		armaDeAsedio.cambiarPosicion(posicionArmaDeAsedio);
		armaDeAsedio.cambiarJugador(jugador2);
		mapa.colocarAtacable(posicionArmaDeAsedio, armaDeAsedio);
		
		int vidaInicialPlazaCentral = plaza.obtenerVida();
		armaDeAsedio.seleccionarObjetivo(plaza);
		armaDeAsedio.realizarAccion();

		assertEquals(vidaInicialPlazaCentral, plaza.obtenerVida());
	}
	
	@Test
	public void unArmaDeAsedioNoLeDeberiaQuitarDanioAlAtacarUnaUnidad() throws Exception {
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		Mapa mapa = juego.obtenerMapa();
		
		Posicion posicionEspadachin = new Posicion(4, 8);
		Espadachin espadachin = new Espadachin();
		espadachin.cambiarPosicion(posicionEspadachin);
		espadachin.cambiarJugador(jugador1);
		mapa.colocarAtacable(posicionEspadachin, espadachin);
		
		Posicion posicionArmaDeAsedio = new Posicion(4, 7);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
		armaDeAsedio.cambiarPosicion(posicionArmaDeAsedio);
		armaDeAsedio.cambiarJugador(jugador2);
		mapa.colocarAtacable(posicionArmaDeAsedio, armaDeAsedio);
		
		int vidaInicialEspadachin = espadachin.obtenerVida();
		armaDeAsedio.montar();
		armaDeAsedio.realizarAccion();
		armaDeAsedio.seleccionarObjetivo(espadachin);
		armaDeAsedio.realizarAccion();

		assertEquals(vidaInicialEspadachin, espadachin.obtenerVida());
	}

}
