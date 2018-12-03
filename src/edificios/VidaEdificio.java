package edificios;

public class VidaEdificio {
	
	protected double vida;
	protected double vidaMaxima;
	protected double incrementoReparacion;
	protected Edificio edificio;
	protected double incrementoConstruccion;

	public VidaEdificio(int vidaInicial, int incrementoReparacion, Edificio edificio) {
		this.vida = vidaInicial;
		this.vidaMaxima = vidaInicial;
		this.incrementoReparacion = incrementoReparacion;
		this.edificio = edificio;
		this.incrementoConstruccion = vidaMaxima / edificio.obtenerTurnosConstruccion();
	}

	public int obtenerVida() {
		return (int) vida;
	}
	
	private boolean aumentarVida(double incremento) {
		if(vida == vidaMaxima) return false;
		vida += incremento;
		if(vida > vidaMaxima) vida = vidaMaxima;
		return true;
	}

	public boolean reparar() {
		return aumentarVida(incrementoReparacion);
	}

	public void daniar(int danio) {
		vida -= danio;
		if (vida <= 0) {
			edificio.destruir();
		}
	}

	public void aumentarVidaConstruccion() {
		aumentarVida(incrementoConstruccion);
	}

	public void establecer(int valor) {
		vida = valor;
	}

	public boolean esMaxima() {
		return vida == vidaMaxima;
	}

	public int obtenerVidaMaxima() {
		return (int) vidaMaxima;
	}

}
