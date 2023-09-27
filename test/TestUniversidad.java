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
		Aula aula = new Aula(2);
		
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		
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
		LocalDate fechaActual = LocalDate.of(2023, 7, 26);
		
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Aula aula = new Aula(2);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		dni = 45478554;
		nombre = "Joaquin";
		apellido = "Paiva";
		Alumno joaquin = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.setCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		unlam.agregarAlumno(joaquin);
		
		Boolean resultado = unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);
		Boolean resultado2 = unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);

		assertTrue(resultado );
	}
	
	@Test
	public void queSePuedaAsignarUnaNotaAlAlumno() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaActual = LocalDate.of(2023, 7, 26);
		
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Aula aula = new Aula(2);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.setCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		
		
		unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);
		Boolean resultado = unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "primer parcial");
		
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaObtenerListaDeMateriasAprobadas() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaActual = LocalDate.of(2023, 7, 26);
		
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Aula aula = new Aula(2);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.setCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		
		
		unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "primer parcial");
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "segundo parcial");
		System.out.println(unlam.obtenerListadoMateriasAprobadasParaUnAlumno(nicolas.getDni()));
		
		
	}
	
	@Test
	public void queSePuedaObtenerListaDeMateriasQueFaltanCursar() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaActual = LocalDate.of(2023, 7, 26);
		
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Aula aula = new Aula(2);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		Materia pb2 = new Materia(2627, "Programacion Basica 2");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.setCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb1);
		
		
		unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "primer parcial");
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "segundo parcial");
		System.out.println(unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(nicolas.getDni()));
		
		
	}
	
	@Test
	public void queSePuedaObtenerListaDeNotas() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaActual = LocalDate.of(2023, 7, 26);
		
		Turno turno = Turno.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Integer dni = 40767127;
		String nombre = "Nicolas";
		String apellido = "Caba";
		LocalDate fechaInscripcion = LocalDate.of(2023, 7, 20);
		Aula aula = new Aula(2);
		
		Universidad unlam = new Universidad("UNLAM");
		Materia pb1 = new Materia(2626,"Programacion Basica 1");
		Materia pb2 = new Materia(2627, "Programacion Basica 2");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision nuevaComision = new Comision(pb1, nuevoCiclo, dia, turno, aula);
		Alumno nicolas = new Alumno(dni,nombre,apellido,fechaInscripcion);
		
		unlam.setCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		unlam.agregarAlumno(nicolas);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb1);
		
		
		unlam.inscribirAlumnoAComision(nicolas.getDni(), nuevaComision.getId(), fechaActual);
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "primer parcial");
		unlam.registrarNota(nuevaComision.getId(), nicolas.getDni(), 7, "segundo parcial");
		System.out.println(unlam.obtenerReporteDeNotasDeAumnosDeCurso(nuevaComision.getId()));
		
		
	}
	
}
