package acciones;

import areaJuego.Posicion;
import edificios.Edificio;
import edificios.FabricaEdificios;
import interfaces.Accion;
import unidades.Aldeano;

public class Construir implements Accion {
	private Edificio edificio;
	private Aldeano aldeano;
	
	public Construir(Edificio edificio, Posicion posicion, Aldeano aldeano) {
		this.aldeano = aldeano;
		FabricaEdificios fabricaEdificios = new FabricaEdificios();
		try {
			fabricaEdificios.crearEdificio(edificio.getClass(), posicion, aldeano.obtenerJugador());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hacer() {
		if(this.edificio.estaEnConstruccion()) {
			this.edificio.continuarConstruccion();
			aldeano.recolectarOro();
		}
	}

}
