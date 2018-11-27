package juegoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import areaJuego.Mapa;
import areaJuego.Posicion;
import areaJuego.PosicionOcupadaError;
import edificios.Castillo;
import edificios.Edificio;
import edificios.PlazaCentral;
import juego.Juego;
import turnos.Jugador;
import unidades.Aldeano;
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
		juego.agregegarJugador(jugador1);
		juego.comenzarJuego();
	}
	
	@Test(expected = MaximoJugadoresError.class)
	public void noSeDeberiaPoderAgregarMasDeDosJugadores() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		Jugador jugador3 = new Jugador("Lucas");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.agregegarJugador(jugador3);
		juego.comenzarJuego();
	}
	
	@Test
	public void cadaJugadorDeberiaComenzarCon100DeOro() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		assertEquals(juego.obtenerJugadores().get(0).obtenerOro(), 100);
		assertEquals(juego.obtenerJugadores().get(1).obtenerOro(), 100);
	}
	
	@Test
	public void elJuegoDeberiaComenzarConUnMapaDe25x25() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		assertEquals(juego.obtenerMapa().obtenerAlto(), 25);
		assertEquals(juego.obtenerMapa().obtenerAncho(), 25);
	}
	
	@Test
	public void elJuegoDeberiaComenzarCon6Aldeanos() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
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
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
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
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
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
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador1), 3);
	}
	
	@Test
	public void elJugador2DeberiaComenzarCon3DePoblacion() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador2), 3);
	}
	
	@Test
	public void cadaJugadorDeberiaComenzarConUnaPlazaCentralYUnCastillo() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Edificio> edificios = juego.obtenerEdifciosDelJugador(jugador1);
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
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Edificio> edificios = juego.obtenerEdifciosDelJugador(jugador1);
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
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertFalse(juego.finalizo());
	}
	
	@Test
	public void siLosCastillosSiguenConVidaElJuegoDeberiaNoTenerGanador() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerGanador(), null);
	}
	
	@Test
	public void daniarUnaUnidadHastaMatarlaDeberiaRestarLaPoblacionDelJugador() throws Exception{
		Juego juego = Juego.obtenerNuevaInstancia();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		List<Unidad> unidadesJugador1 = juego.obtenerUnidadesDelJugador(jugador1);
		unidadesJugador1.get(0).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 2);
		
		unidadesJugador1.get(1).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 1);
		
		unidadesJugador1.get(2).quitarVida(500);
		assertEquals(juego.obtenerPoblacion(jugador1), 0);
	}
	

}
