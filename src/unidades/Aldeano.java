package unidades;
import areaJuego.Posicion;
import edificios.Cuartel;
import edificios.PlazaCentral;
import interfaces.Atacable;
import interfaces.TurnoRecolectar;
import turnos.TurnoRecolectarOro;
import turnos.TurnoRecolectarFinalizado;
import edificios.Edificio;

public class Aldeano extends Unidad {
	
	private TurnoRecolectar turnoRecolectarOro;
	//private Turno turnoConstruir;
	//private Turno turnoReparar;
	
	public Aldeano() {
		this.vida = 50;
		this.costo = 25;
		this.turnoRecolectarOro = new TurnoRecolectarOro();
		//this.turnoConstruir = new TurnoConstruir();
		//this.turnoReparar = new TurnoReparar();
	}

	
	public Cuartel construirCuartel() {
		Cuartel nuevoCuartel = new Cuartel();
		return nuevoCuartel;
	}
	
	public PlazaCentral construirPlaza() {
		PlazaCentral nuevaPlaza = new PlazaCentral();
		return nuevaPlaza;
	}
	
	public void repararEdificio(Edificio edificio) {
		edificio.reparar();
	}
	
	public Number recolectarOro() {
		return turnoRecolectarOro.recolectarOro(this);
	}
/*
	public boolean estaReparando() {
		return turnoReparar.estaReparando();
	}
	*/


	public void finalizarTurnoRecoleccion() {
		this.turnoRecolectarOro = new TurnoRecolectarFinalizado();	
	}


	@Override
	public void atacar(Atacable atacable) {		
	}

	@Override
	public boolean moverA(Posicion posicion) {
		return turnoMovimiento.moverUnidad(posicion, this);
	}

}
