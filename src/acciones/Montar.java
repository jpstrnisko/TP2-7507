package acciones;

import interfaces.Accion;
import unidades.ArmaDeAsedio;

public class Montar implements Accion {
	
	private ArmaDeAsedio armaAMontar;

	public Montar(ArmaDeAsedio arma) {
		this.armaAMontar = arma;
	}

	@Override
	public void hacer() {
		this.armaAMontar.montar();
	}


}
