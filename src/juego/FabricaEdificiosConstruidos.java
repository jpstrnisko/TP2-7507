package juego;

import areaJuego.Posicion;
import edificios.Edificio;
import edificios.FabricaEdificios;
import edificios.PlazaCentral;
import turnos.Jugador;

public class FabricaEdificiosConstruidos {

	public void crearEdificio(Class clase, Posicion posicion, Jugador jugador) throws Exception {
		FabricaEdificios fabrica = new FabricaEdificios();
		Edificio edificio = fabrica.crearEdificio(clase, posicion, jugador);
		edificio.finalizarConstruccion();
		edificio.establecerVida(edificio.obtenerVidaMaxima());
	}

}
