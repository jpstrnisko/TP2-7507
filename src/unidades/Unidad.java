package unidades;
import areaJuego.Mapa;
import areaJuego.Posicion;
import edificios.VidaEdificio;
import interfaces.TurnoMovimiento;
import juego.Juego;
import turnos.Jugador;
import turnos.TurnoMovimientoFinalizado;
import turnos.TurnoMovimientoHabilitado;
import interfaces.Accion;
import interfaces.Atacable;
import interfaces.IAtacante;

public abstract class Unidad implements Atacable {
	
	protected VidaUnidad vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
	protected Posicion posicion;
	protected int tamanio = 1; //1 casillero
	protected TurnoMovimiento turnoMovimiento;
	protected Jugador jugador;
	
	protected Accion accion;

	public int obtenerVida() {
		return this.vida.obtenerVida();
	}

	public int obtenerCosto() {
		return this.costo;
	}
	
	public void quitarVida(int danio) {
		vida.daniar(danio);
	}
	
	public int obtenerDistanciaAtaque() {
		return this.distanciaMaximaAtaque;
	}
	
	public void establecerPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Posicion obtenerPosicion() {
		return this.posicion;
	}
	
	public void cambiarPosicion(Posicion destino) {
		this.posicion =  destino;
	}
	
		
	public int obtenerTamanio() {
		return this.tamanio;
	}
	
	public void finalizarTurnoMovimiento() {
		this.turnoMovimiento = new TurnoMovimientoFinalizado();	
	}

	public Jugador obtenerJugador() {
		return jugador;
	}
	
	public void cambiarJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void matar() {
		Juego juego = Juego.obtenerInstancia();
		juego.obtenerMapa().removerAtacable(this);
	}
	
	public void mover(Posicion posicion) throws Exception {
		turnoMovimiento.moverUnidad(posicion);
	}
	
	public abstract void reiniciarAccion();

	public void realizarAccion() {
		this.accion.hacer();
		this.turnoMovimiento = new TurnoMovimientoHabilitado(this);
	}
	
	public boolean estaEnRangoDe(int rangoDeAtaque, IAtacante atacante) {
		return this.obtenerPosicion().estaEnRango(atacante.obtenerPosicion(), rangoDeAtaque);
	}
	
	public boolean estaOcupando(Posicion posicion) {
		return posicion.equals(this.posicion);
	}
	
	public int obtenerVidaMaxima() {
		return vida.obtenerVidaMaxima();
	}
}

