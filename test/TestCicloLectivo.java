import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		assertNotNull(nuevoCiclo);
	}

}
