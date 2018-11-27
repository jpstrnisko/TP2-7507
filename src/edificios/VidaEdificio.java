package edificios;

public class VidaEdificio {
	
	protected int vida;
	protected int vidaMaxima;
	protected int incrementoReparacion;
	protected Edificio edificio;

	public VidaEdificio(int vidaInicial, int incrementoReparacion, Edificio edificio) {
		this.vida = vidaInicial;
		this.vidaMaxima = vidaInicial;
		this.incrementoReparacion = incrementoReparacion;
		this.edificio = edificio;
	}

	public int obtenerVida() {
		return vida;
	}

	public boolean reparar() {
		if(vida == vidaMaxima) return false;
		vida += incrementoReparacion;
		if(vida > vidaMaxima) vida = vidaMaxima;
		return true;
	}

	public void daniar(int danio) {
		vida -= danio;
		if (vida <= 0) {
			edificio.destruir();
		}
	}

}
