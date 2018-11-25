package interfaces;

import edificios.Cuartel;
import edificios.PlazaCentral;
import unidades.Aldeano;

public interface TurnoConstruir {
	
	public PlazaCentral construirPlazaCentral(Aldeano aldeano);
	
	public Cuartel construirCuartel(Aldeano aldeano);
}