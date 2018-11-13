package fiuba.algo3.ejemplo1;

public class Mapa {
	
	Celda celda = new Celda();
	ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	
	
	public void asignarTamanio(int filas,int columnas) {
		
		zonaDeJuego.crearZonaDeJuego(filas, columnas);
				
	}
	
	public int obtenerTamanio() {
		
		int tamanio = zonaDeJuego.obtenerTamanio();
		
		return tamanio;		
	}
	
	
	public void colocarUnidad(int fila, int columna) {
		
		if (zonaDeJuego.nollegoAlFinal(fila,columna)) {
			
			celda.colocarUnidad(fila,columna);
		}
	}	
			
}