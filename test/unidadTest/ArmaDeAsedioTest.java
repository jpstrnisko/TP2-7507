package unidadTest;
import static org.junit.Assert.*;
import org.junit.Test;

import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import unidades.ArmaDeAsedio;

public class ArmaDeAsedioTest {
	
	public static final ArmaDeAsedio miArma = new ArmaDeAsedio();
	@Test
	public void test01ArmaDeAsedioSeCreaCon150DeVida() {
		assertEquals(150, miArma.obtenerVida());
	}
	
	@Test
	public void test02ArmaDeAsedioSeCreaConUnCostoDe200() {
		assertEquals(200, miArma.obtenerCosto());
	}
	
	@Test
	public void unArmaAtacaAUnCastilloYLoDejaCon925DeVida() {
		Castillo castillo = new Castillo();
		miArma.atacar(castillo);
		assertEquals(925, castillo.obtenerVida());
	}
	
	@Test
	public void unArmaAtacaAUnCuartelYLoDejaCon175Devida() {
		Cuartel cuartel = new Cuartel();
		miArma.atacar(cuartel);
		assertEquals(175, cuartel.obtenerVida());
	}
	
	@Test
	public void unArmaAtacaAUnaPlazaYLaDejaCon375DeVida() {
		PlazaCentral plaza = new PlazaCentral();
		miArma.atacar(plaza);
		assertEquals(375, plaza.obtenerVida());
	}
	
	@Test
	public void ASDSeCreaEnPosicion00DevuelvePosicionCorrecta() {
		miArma.establecerPosicion(new Posicion(0,0));
		assertEquals(miArma.obtenerPosicion().obtenerPosicionX(), 0);
		assertEquals(miArma.obtenerPosicion().obtenerPosicionY(), 0);
	}
	
	@Test
	public void ASDSeCreaEnPosicion00YLuegoSeMueveA11() {
		miArma.establecerPosicion(new Posicion(0,0));
		miArma.cambiarPosicion(new Posicion(1,1));
		assertEquals(miArma.obtenerPosicion().obtenerPosicionY(), 1);
		assertEquals(miArma.obtenerPosicion().obtenerPosicionX(), 1);
	}
}