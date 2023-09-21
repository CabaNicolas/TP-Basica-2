import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnAula() {
		Integer capacidad = 60;
		Aula aula = new Aula(capacidad);
		
		assertNotNull(aula);
	}

}
