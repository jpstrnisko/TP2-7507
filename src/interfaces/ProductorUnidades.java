package interfaces;

import edificios.Edificio;
import unidades.Aldeano;
import unidades.Unidad;

public interface ProductorUnidades {

	void producir(Unidad unidad, Edificio productor);
	
	void avanzar() throws Exception;
}