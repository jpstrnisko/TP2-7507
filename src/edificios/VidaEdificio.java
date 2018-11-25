package edificios;

public class VidaEdificio {
	
	protected int vida;
	protected int vidaMaxima;
	protected int incrementoReparacion;

	public VidaEdificio(int vidaInicial, int incrementoReparacion_) {
		vida = vidaInicial;
		vidaMaxima = vidaInicial;
		incrementoReparacion = incrementoReparacion_;
	}

	public int obtenerVida() {
		return vida;
	}

	public boolean Reparar() {
		if(vida == vidaMaxima) return false;
		vida += incrementoReparacion;
		if(vida > vidaMaxima) vida = vidaMaxima;
		return true;
	}

	public void Daniar(int danio) {
		vida -= danio;
	}

}
