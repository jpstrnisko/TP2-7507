package unidades;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;

public class Aldeano extends Unidad {
		
	public Aldeano() {
		this.vida = 50;
		this.costo = 25;
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

	@Override
	public void atacar(Edificio edificio) {
	}

	@Override
	public void atacar(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}
	
}
