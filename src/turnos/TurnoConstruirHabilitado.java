package turnos;

import edificios.Cuartel;
import edificios.PlazaCentral;
import interfaces.TurnoConstruir;
import unidades.Aldeano;

public class TurnoConstruirHabilitado implements TurnoConstruir{
	
	public PlazaCentral construirPlazaCentral(Aldeano aldeano) {
		PlazaCentral plazaCentral = new PlazaCentral();
		aldeano.finalizarAcciones();
		return plazaCentral;
	}
	
	public Cuartel construirCuartel(Aldeano aldeano) {
		Cuartel cuartel = new Cuartel();
		aldeano.finalizarAcciones();
		return cuartel;
	}
}
