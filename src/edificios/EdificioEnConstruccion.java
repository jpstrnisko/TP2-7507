package edificios;

import interfaces.EstadoEdficio;
import unidades.Aldeano;

public class EdificioEnConstruccion implements EstadoEdficio {
	
	int turnosRestantesConstruccion;
	
	public EdificioEnConstruccion(int turnosConstruccion) {
		this.turnosRestantesConstruccion = turnosConstruccion;
	}

	@Override
	public boolean estaEnConstruccion() {
		return true;
	}

	@Override
	public void continuarDesarrollo(Edificio edificio, Aldeano aldeano) {
		turnosRestantesConstruccion--;
		edificio.aumentarVidaConstruccion();
		
		if(turnosRestantesConstruccion == 0) {
			edificio.finalizarConstruccion();
			aldeano.recolectarOro();
		}
	}


}
