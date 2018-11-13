package edificios;

import modelo.ArmaDeAsedio;

public class Castillo {
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}

	public int obtenerVida() {
		return 1000;
	}
}
