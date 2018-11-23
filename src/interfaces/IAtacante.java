package interfaces;
import edificios.Edificio;
import unidades.Unidad;

public interface IAtacante {
	
	public abstract void atacar(Unidad unidad);
	public abstract void atacar(Edificio edificio);
}
