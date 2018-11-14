package interfaces;
import edificios.Edificio;
import unidades.Unidad;

public interface Atacable {
	public abstract void quitarVida(int danio);
	public abstract void atacar(Edificio edificio);
	public abstract void atacar(Unidad unidad);
//PATRON DOUBLE DISPATCH
}
