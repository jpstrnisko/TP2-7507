package edificios;

import java.util.ArrayList;
import java.util.List;


import areaJuego.Posicion;
import interfaces.ProductorUnidades;
import juego.Juego;
import unidades.Unidad;

public class ProduccionOcupada implements ProductorUnidades {
	
	protected Unidad unidadAProducir;
	protected Edificio productor;
	
	public ProduccionOcupada(Unidad unidad, Edificio productor) {
		unidadAProducir = unidad;
		this.productor = productor;
	}
	
	@Override
	public void producir(Unidad unidad, Edificio productor) {
		
	}

	@Override
	public void avanzar() throws Exception {
		List<Posicion> posicionesDisponibles = new ArrayList<Posicion>(productor.obtenerPosicionesValidasAdyacentes());
		try {
			unidadAProducir.cambiarPosicion(posicionesDisponibles.get(0));
		}
		catch (IndexOutOfBoundsException e){
			return;
		}
		
		unidadAProducir.cambiarJugador(productor.obtenerJugador());
		Juego.obtenerInstancia().obtenerMapa().colocarAtacable(unidadAProducir.obtenerPosicion(), unidadAProducir);
		
		productor.productorUnidades = new ProduccionDisponible();
	}

}
