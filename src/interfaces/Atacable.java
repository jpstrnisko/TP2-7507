package interfaces;
import edificios.Edificio;
import unidades.Unidad;

public interface Atacable {
	void quitarVida(int danio);
	void atacar(Edificio edificio);
	void atacar(Unidad unidad);
//PATRON DOUBLE DISPATCH
}
