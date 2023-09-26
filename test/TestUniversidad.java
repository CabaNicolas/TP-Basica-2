import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		Universidad unlam = new Universidad("UNLAM");
		
		assertNotNull(unlam);
	}
	
	@Test
	public void queSePuedaCrearUnCicloLectivoDeLaUniversidad() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Universidad unlam = new Universidad("UNLAM");
		unlam.setCicloLectivo(nuevoCiclo);
		
		CicloLectivo ve = nuevoCiclo;
		CicloLectivo vo = unlam.getCicloLectivo();
		
		assertEquals(ve, vo);
	}
	//Completar
	@Test
	public void queSePuedaAgregarUnAula() {
		Universidad unlam = new Universidad("UNLAM");
		
		assertNotNull(unlam);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateria() {
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2621, "Programacion Basica 1");
		
		Boolean resultado = unlam.agregarMateria(pb1);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Integer codigomateria = 2621;
		Integer codigoMateriaCorrelativa = 2626;
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(codigomateria, "Programacion Basica 1");
		Materia pb2 = new Materia(codigoMateriaCorrelativa, "Programacion Basica 2");
		
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		
		Boolean resultado = unlam.asignarMateriaCorrelativa(codigomateria, codigoMateriaCorrelativa);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {
		Integer codigomateria = 2621;
		Integer codigoMateriaCorrelativa = 2626;
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(codigomateria, "Programacion Basica 1");
		Materia pb2 = new Materia(codigoMateriaCorrelativa, "Programacion Basica 2");
		
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		unlam.asignarMateriaCorrelativa(codigomateria, codigoMateriaCorrelativa);
		
		Boolean resultado = unlam.eliminarMateriaCorrelativa(codigomateria, codigoMateriaCorrelativa);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaComision() {
		Universidad unlam = new Universidad("UNLAM");
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno);
		
		Boolean resultado = unlam.agregarComision(nuevaComision);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumno() {
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		
		Universidad unlam = new Universidad("UNLAM");
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);

		Boolean resultado = unlam.agregarAlumno(nicolas);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaInscribirAlumnoAComision() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		
		Boolean resultado = unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId());
		assertTrue(resultado);
	}
	
}
