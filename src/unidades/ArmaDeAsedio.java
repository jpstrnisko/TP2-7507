package unidades;
import edificios.Edificio;
import acciones.Desmontar;
import acciones.Montar;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;
import interfaces.IAtacante;
import turnos.TurnoMovimientoHabilitado;


public class ArmaDeAsedio extends Unidad implements IAtacante {
	
	protected EstadoArmaDeAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = new VidaUnidad(150, this);
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
		this.estado = new EstadoDesmontada(this);
		this.accion = new Inactivo();
		this.turnoMovimiento = new TurnoMovimientoHabilitado(this);
	}
	
	public boolean estaMontada() {
		return estado.estaMontada();
	}

	public void montar() {
		this.estado = new EstadoMontada(this);
	}

	public void desmontar() {
		this.estado = new EstadoDesmontada(this);
	}
	
	@Override
	public void realizarAccion() {
		this.accion.hacer();
		this.turnoMovimiento = new TurnoMovimientoHabilitado(this);
		this.reiniciarAccion();
	}

	@Override
	public void atacar(Edificio edificio) {
		this.estado.atacar(edificio);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		this.estado.atacar(unidad);
	}
	
	public void montarArma() {
		this.accion = new Montar(this);
	}
	
	public void desmontarArma() {
		this.accion = new Desmontar(this);
	}

	@Override
	public void reiniciarAccion() {
		this.accion = new Inactivo();
	}

	@Override
	public void seleccionarObjetivo(Atacable objetivo) {
		this.estado.seleccionarObjetivo(objetivo);
	}

	@Override
	public int obtenerRangoAtaque() {
		return distanciaMaximaAtaque;
	}
}
