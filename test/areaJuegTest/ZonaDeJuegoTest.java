package areaJuegTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import areaJuego.Posicion;
import areaJuego.ZonaDeJuego;
import edificios.Cuartel;
import edificios.Edificio;
import unidades.Aldeano;
import unidades.Unidad;

public class ZonaDeJuegoTest {
	
	@Test
	public void seObtieneCorrectamenteLasDimensionesDeLaZonaDeJuego() {
		int filas = 50;
		int columnas = 50;
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerInstancia();
		
		assertEquals(filas, zonaDeJuego.obtenerCantidadFilas());
		assertEquals(columnas, zonaDeJuego.obtenerCantidadColumnas());
	}
	
	@Test
	public void seLePuedenAgregarUnidadesALaZonaDeJuego() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		
		Unidad aldeano = new Aldeano();
		List<Unidad> unidades = new ArrayList<Unidad>();
		unidades.add(aldeano);
		
		zonaDeJuego.agregarUnidad(aldeano);
		
		assertEquals(unidades, zonaDeJuego.obtenerUnidades());
	}
	
	
	@Test
	public void seLePuedenAgregarEdificiosALaZonaDeJuego() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		
		Edificio cuartel = new Cuartel();
		List<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add(cuartel);
		
		zonaDeJuego.agregarEdificio(cuartel);
		
		assertEquals(edificios, zonaDeJuego.obtenerEdificios());
	}
	
	@Test
	public void preguntarSiUnaPosicionValidaEsValidaDeberiaDevolverTrue() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		Posicion posicion = new Posicion(32, 22);
				
		assertTrue(zonaDeJuego.esPosicionValida(posicion));
	}
	
	@Test
	public void preguntarSiUnaPosicionInvalidaEsValidaDeberiaDevolverFalse() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		Posicion posicion = new Posicion(75, 22);
				
		assertFalse(zonaDeJuego.esPosicionValida(posicion));
	}
	
	@Test
	public void preguntarSiUnaPosicionBordeEsValidaDeberiaDevolverTrue() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		Posicion posicion = new Posicion(50, 50);
				
		assertTrue(zonaDeJuego.esPosicionValida(posicion));
	}
	
	@Test
	public void preguntarSiUnaPosicionOcupadaPorUnaUnidadEstaDisponibleDeberiaDevolverFalse() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		Posicion posicion = new Posicion(20, 50);
		
		Unidad aldeanoMock = mock(Aldeano.class);
		when(aldeanoMock.estaOcupando(posicion)).thenReturn(true);
		
		zonaDeJuego.agregarUnidad(aldeanoMock);
				
		assertFalse(zonaDeJuego.estaDisponible(posicion));
	}
	
	@Test
	public void preguntarSiUnaPosicionOcupadaPorUnEdificioEstaDisponibleDeberiaDevolverFalse() {
		ZonaDeJuego zonaDeJuego = ZonaDeJuego.obtenerNuevaInstancia();
		Posicion posicion = new Posicion(20, 50);
		
		Edificio cuartelMock = mock(Cuartel.class);
		when(cuartelMock.estaOcupando(posicion)).thenReturn(true);
		
		zonaDeJuego.agregarEdificio(cuartelMock);
				
		assertFalse(zonaDeJuego.estaDisponible(posicion));
	}
	
	
}