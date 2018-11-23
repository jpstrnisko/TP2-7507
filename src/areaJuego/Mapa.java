package areaJuego;
import edificios.Edificio;
import interfaces.Atacable;
import java.util.ArrayList;


public class Mapa {
	
	protected int alto;
	protected int ancho;
	protected ArrayList<Celda> celdas = new ArrayList();
			
	public Mapa(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.instalarCeldas();
	}
	
	public void instalarCeldas() {
		for(int i = 0; i<this.ancho; i++) {
			for(int j = 0; j<this.alto; j++) {
				Celda celda = new Celda(new Posicion(i,j));
				this.celdas.add(celda);
			}
		}
	}
	
	public Celda obtenerCeldaDeterminada(Posicion posicion) {
		for(Celda cadaCelda: celdas) {
			if(cadaCelda.obtenerPosicion().posicionesSonIguales(posicion))
				return cadaCelda;
		}
		return null;
	}
	
	public int obtenerAlto() {
		return this.alto;
	}
	
	public int obtenerAncho() {
		return this.ancho;
	}
	
	public int obtenerCantidadCeldas() {
		return celdas.size();
	}
	
	public boolean celdaOcupada(Posicion posicion) {
		Celda celda = this.obtenerCeldaDeterminada(posicion);
		return celda.estaLibre();
	}
	
	public boolean seSalioDelMapa(Posicion posicion) {
		boolean salioEnAncho = Math.abs(posicion.obtenerPosicionX()) >= this.ancho;
		boolean salioEnAlto = Math.abs(posicion.obtenerPosicionY()) >= this.alto;
		return salioEnAncho || salioEnAlto;
	}
	
	public ArrayList obtenerCeldas() {
		return celdas;
	}
	
	public void colocarAtacable(Posicion posicion, Atacable atacable) { //Por ahora solo para unidades (ocupan 1 solo casillero)
		for(Celda cadaCelda: celdas) {
			if (cadaCelda.obtenerPosicion().posicionesSonIguales(posicion))
				cadaCelda.colocarAtacable(atacable, posicion);
		}
	}
}
	
			
	
