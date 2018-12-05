package AccionesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import unidades.ArmaDeAsedio;

public class MontarTest {
	
	
	
	@Test
	public void montarArmaDeAsedio() {
		
		ArmaDeAsedio arma = new ArmaDeAsedio();
		
		arma.montar();
		assertTrue(arma.estaMontada());
	}
	
	
}

