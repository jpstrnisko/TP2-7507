package unidades;
import acciones.Construir;
import acciones.RecolectarOro;
import acciones.RepararEdificio;
import areaJuego.Posicion;
import edificios.Cuartel;
import edificios.PlazaCentral;
import edificios.Edificio;

public class Aldeano extends Unidad {

	public Aldeano() {
		this.vida = new VidaUnidad(50, this);
		this.costo = 25;
		this.accion = new RecolectarOro(this);
	}
	
	public void construirCuartel(Posicion posicion) {
		this.accion = Construir.obtenerInstanciaAccion(new Cuartel(), posicion, this);
	}
	
	public void construirPlazaCentral(Posicion posicion) {
		this.accion = Construir.obtenerInstanciaAccion(new PlazaCentral(), posicion, this);
	}
	
	public void repararEdificio(Edificio edificio) {
		this.accion = RepararEdificio.obtenerInstanciaAccion(edificio, this);
	}
	
	public void recolectarOro() {
		this.accion = new RecolectarOro(this);
	}

	public boolean estaAdyacenteAlEdificio(Edificio edificio, Posicion posicion) {
		return this.obtenerPosicion().obtenerPosicionesDeConstruccion(edificio.obtenerTamanio()).contains(posicion);
	}

	@Override
	protected void reiniciarAccion() {
		this.recolectarOro();
	}
	
}
