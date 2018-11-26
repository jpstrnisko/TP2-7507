package unidades;
import areaJuego.Posicion;
import edificios.Cuartel;
import edificios.PlazaCentral;
import interfaces.Atacable;
import interfaces.TurnoConstruir;
import interfaces.TurnoRecolectar;
import interfaces.TurnoReparar;
import turnos.TurnoRecolectarOro;
import turnos.TurnoRepararFinalizado;
import turnos.TurnoRepararHabilitado;
import turnos.Jugador;
import turnos.TurnoConstruirFinalizado;
import turnos.TurnoConstruirHabilitado;
import turnos.TurnoRecolectarFinalizado;
import edificios.Edificio;
import edificios.Edificio;
import edificios.PlazaCentral;

public class Aldeano extends Unidad {
	
	private TurnoRecolectar turnoRecolectarOro;
	private TurnoConstruir turnoConstruir;
	private TurnoReparar turnoReparar;
		
	public Aldeano() {
		this.vida = 50;
		this.costo = 25;
		this.turnoRecolectarOro = new TurnoRecolectarOro();
		this.turnoConstruir = new TurnoConstruirHabilitado();
		this.turnoReparar = new TurnoRepararHabilitado();
	}
	
	public Cuartel construirCuartel() {
		return turnoConstruir.construirCuartel(this);
	}
	
	public PlazaCentral construirPlaza() {
		return turnoConstruir.construirPlazaCentral(this);
	}
	
	public boolean repararEdificio(Edificio edificio) {
		return turnoReparar.repararEdificio(edificio, this);
	}
	
	
	public Number recolectarOro() {
		return turnoRecolectarOro.recolectarOro(this);
	}	
	
	public void finalizarAcciones() {
		this.turnoRecolectarOro = new TurnoRecolectarFinalizado();	
		this.turnoConstruir = new TurnoConstruirFinalizado();
		this.turnoReparar = new TurnoRepararFinalizado();
		
	}

}
