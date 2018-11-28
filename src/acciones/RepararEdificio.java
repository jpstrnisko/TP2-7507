package acciones;

import edificios.Edificio;
import interfaces.Accion;
import unidades.Aldeano;
import unidades.Unidad;

public class RepararEdificio implements Accion {
	private Edificio edificio;
	private Aldeano aldeano;
	
	public RepararEdificio(Edificio edificio, Aldeano aldeano) {
		this.edificio = edificio;
		this.aldeano = aldeano;
	}

	@Override
	public void hacer() {
		if(this.edificio.reparar()) {
			aldeano.recolectarOro();
		}
	}

}
