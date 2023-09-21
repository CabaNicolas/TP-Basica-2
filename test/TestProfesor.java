import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSePuedaCrearUnProfesor() {
		Integer dni = 12453211;
		String nombre = "German";
		String apellido = "Mazza";
		Profesor profesor = new Profesor(dni, nombre, apellido);
		
		assertNotNull(profesor);
	}

}
