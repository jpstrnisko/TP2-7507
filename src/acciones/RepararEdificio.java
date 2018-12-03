package acciones;

import edificios.Edificio;
import interfaces.Accion;
import unidades.Aldeano;

public class RepararEdificio implements Accion {
	private Edificio edificio;
	private Aldeano aldeano;
	
	public RepararEdificio(Edificio edificio, Aldeano aldeano) {
		this.aldeano = aldeano;
		this.edificio = edificio;
		edificio.comenzarReparacion();
	}

	@Override
	public void hacer() {
		edificio.continuarReparacion(aldeano);
	}

	public static Accion obtenerInstanciaAccion(Edificio edificio, Aldeano aldeano) {
		if (aldeano.estaAdyacenteAlEdificio(edificio, edificio.obtenerPosicionInicial()) && edificio.esReparable()) 
			return new RepararEdificio(edificio, aldeano);
		return new RecolectarOro(aldeano);
	}
}
