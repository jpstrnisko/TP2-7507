package AccionesTest;

import static org.junit.Assert.*;
import org.junit.Test;
import unidades.ArmaDeAsedio;

public class DesmontarTest {	
	
	@Test
	public void montarArmaDeAsedio() {
		
		ArmaDeAsedio arma = new ArmaDeAsedio();
		
		assertFalse(arma.estaMontada());
	}
	
	
}
