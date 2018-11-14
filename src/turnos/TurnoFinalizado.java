package turnos;

import edificios.Edificio;
import mapa.Celda;

public class TurnoFinalizado implements Turno{
	
	public Number recolectarOro() {
		return 0;
	}
	
	public boolean moverA(Celda celda) {
		return false;
	}
	
	public boolean construirEdificio() {
		return false;
	}
	
	public boolean estaReparando() {
		return false;
	}
	
	public void repararEdificio(Edificio edificio) {
	}
}
