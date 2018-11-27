package unidades;

import edificios.Edificio;

public class VidaUnidad {
	
	protected int vida;
	protected Unidad unidad;
	
	public VidaUnidad(int vidaInicial, Unidad unidad) {
		this.vida = vidaInicial;
		this.unidad = unidad;
	}

	public int obtenerVida() {
		return vida;
	}

	public void daniar(int danio) {
		vida -= danio;
		if (vida <= 0) {
			unidad.matar();
		}
	}
}
