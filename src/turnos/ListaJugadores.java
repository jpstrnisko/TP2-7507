package turnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaJugadores {
	
	private List<Jugador> lista = new ArrayList<Jugador>();
	private int indice;
	
	public void agregar(Jugador jugador) {
		lista.add(jugador);
	}

	public Jugador obtenerActual() {
		return lista.get(indice);
	}

	public void avanzarSiguiente() {
		indice += 1;
		if(indice == lista.size()) {
			indice = 0;
		}
	}

	public void comenzarTurnos() {
		Random random = new Random();
		indice = random.nextInt(lista.size());
	}

	public int obtenerCantidadJugadores() {
		return lista.size();
	}

	public List<Jugador> obtenerJugadores() {
		return lista;
	}

}
