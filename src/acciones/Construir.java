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
			this.edificio = fabricaEdificios.crearEdificio(edificio.getClass(), posicion, aldeano.obtenerJugador());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hacer() {
		edificio.continuarConstruccion(aldeano);
	}

	public static Accion obtenerInstanciaAccion(Edificio edificio, Posicion posicion, Aldeano aldeano) {
		if(aldeano.estaAdyacenteAlEdificio(edificio, posicion)) {
			return new Construir(edificio, posicion, aldeano);
		}
		return new RecolectarOro(aldeano);
	}

}
