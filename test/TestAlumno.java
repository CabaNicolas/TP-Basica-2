import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		assertNotNull(nicolas);
	}

}
