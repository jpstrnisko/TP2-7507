package juegoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import areaJuego.Mapa;
import areaJuego.Posicion;
import areaJuego.PosicionOcupadaError;
import edificios.Castillo;
import juego.Juego;
import turnos.Jugador;
import unidades.Aldeano;
import unidades.Unidad;
import juego.FaltanJugadoresError;

public class ReglasJuegoTest {
	
	@Test(expected = FaltanJugadoresError.class)
	public void elJuegoNoSePodriaComenzarSinJugadores() throws Exception{
		Juego juego = new Juego();
		juego.comenzarJuego();
	}

	@Test(expected = FaltanJugadoresError.class)
	public void elJuegoNoSePodriaComenzarConSoloUnJugador() throws Exception{
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		juego.agregegarJugador(jugador1);
		juego.comenzarJuego();
	}
	
	@Test
	public void cadaJugadorDeberiaComenzarCon100DeOro() throws Exception{
		Juego juego = new Juego();
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
		Juego juego = new Juego();
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
		Juego juego = new Juego();
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
		Juego juego = new Juego();
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
		Juego juego = new Juego();
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
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador1), 3);
	}
	
	@Test
	public void elJugador2DeberiaComenzarCon3DePoblacion() throws Exception{
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pedro");
		juego.agregegarJugador(jugador1);
		juego.agregegarJugador(jugador2);
		juego.comenzarJuego();
		
		assertEquals(juego.obtenerPoblacion(jugador2), 3);
	}

}
