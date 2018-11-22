package unidades;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.TurnoMovimiento;
import turnos.TurnoMovimientoFinalizado;

public abstract class Unidad implements Atacable {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
	protected TurnoMovimiento turnoMovimiento;

	public int obtenerVida() {
		return this.vida;
	}

	public int obtenerCosto() {
		return this.costo;
	}
	
	public void quitarVida(int danio) {
		this.vida -= danio;
	}
	
	public abstract void atacar(Atacable atacable);
	
	public abstract boolean moverA(Posicion posicion);
	
	public void finalizarTurnoMovimiento() {
		this.turnoMovimiento = new TurnoMovimientoFinalizado();	
	}
}
