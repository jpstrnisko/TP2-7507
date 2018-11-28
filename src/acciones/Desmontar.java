package acciones;

import interfaces.Accion;
import unidades.ArmaDeAsedio;

public class Desmontar implements Accion {
	
	private ArmaDeAsedio armaAMontar;

	public Desmontar(ArmaDeAsedio arma) {
		this.armaAMontar = arma;
	}

	@Override
	public void hacer() {
		this.armaAMontar.desmontar();
	}


}
