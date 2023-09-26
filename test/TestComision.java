import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestComision {

	@Test
	public void queSePuedaCrearUnaComision() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Aula aula = new Aula(2);
		
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		
		assertNotNull(nuevaComision);
	}

}
