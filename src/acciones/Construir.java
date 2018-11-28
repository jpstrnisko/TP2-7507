package acciones;

import areaJuego.Posicion;
import edificios.Edificio;
import edificios.FabricaEdificios;
import edificios.PlazaCentral;
import interfaces.Accion;
import unidades.Aldeano;
import unidades.Unidad;

public class Construir implements Accion {
	private Edificio edificio;
	
	public Construir(Edificio edificio, Posicion posicion, Aldeano aldeano) {
		FabricaEdificios fabricaEdificios = new FabricaEdificios();
		try {
			fabricaEdificios.crearEdificio(edificio.getClass(), posicion, aldeano.obtenerJugador());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hacer(Unidad unidad) {
		if(this.edificio.estaEnConstruccion()) {
			this.edificio.continuarConstruccion();
			((Aldeano) unidad).recolectarOro();
		}
	}

}
