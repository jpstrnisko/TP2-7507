package edificios;

public class VidaEdificio {
	
	protected int vida;
	protected int incrementoReparacion;

	public VidaEdificio(int vidaInicial, int incrementoReparacion_) {
		vida = vidaInicial;
		incrementoReparacion = incrementoReparacion_;
	}

	public int obtenerVida() {
		return vida;
	}

	public void Reparar() {
		vida += incrementoReparacion;
	}

	public void Daniar(int danio) {
		vida -= danio;
	}

}
