package interfaces;
import edificios.Edificio;
import unidades.Unidad;

public interface Atacable {
	void quitarVida(int danio);
	int obtenerTamanio();
//PATRON DOUBLE DISPATCH
}
