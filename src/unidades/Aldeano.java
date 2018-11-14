package unidades;
import areaJuego.Celda;
import edificios.Cuartel;
import edificios.PlazaCentral;
import edificios.Edificio;

public class Aldeano extends Unidad {
	
	//private TurnoRecogerOro turnoRecogerOro;
	//private TurnoConstruir turnoConstruir;
	//private TurnoReparar turnoReparar;
	
	public Aldeano() {
		this.vida = 50;
		this.costo = 25;
		//this.turnoMovimiento = new TurnoMovimiento();
		//this.turnoRecogerOro = new TurnoRecolectarOro();
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
	
	/*public Number recolectarOro() {
		return turnoRecogerOro.recogerOro();
	}

	public boolean estaReparando() {
		return turnoReparar.estaReparando();
	}
	
	public boolean moverA(Celda celda) {
		return turnoMovimiento.moverA(celda);
	}*/
}
