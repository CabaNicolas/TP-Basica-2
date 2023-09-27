import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		Integer codigoMateria = 2626;
		String nombre = "Programacion Basica 2";
		
		Materia pb2 = new Materia(codigoMateria, nombre);

		assertNotNull(pb2);
	}

	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Integer codigoMateria = 2626;
		String nombre = "Programacion Basica 2";
		Integer codigoMateriaCorrelativa = 2619;
		String nombreMateriaCorrelativa = "Programacion Basica 1";
		
		Materia pb2 = new Materia(codigoMateria, nombre);
		Materia pb1 = new Materia(codigoMateriaCorrelativa, nombreMateriaCorrelativa);
		Boolean respuesta = pb2.agregarMateriaCorrelativa(pb1);

		assertTrue(respuesta);
	}
	
	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {
		Integer codigoMateria = 2626;
		String nombre = "Programacion Basica 2";
		Integer codigoMateriaCorrelativa = 2619;
		String nombreMateriaCorrelativa = "Programacion Basica 1";
		
		Materia pb2 = new Materia(codigoMateria, nombre);
		Materia pb1 = new Materia(codigoMateriaCorrelativa, nombreMateriaCorrelativa);
		pb2.agregarMateriaCorrelativa(pb1);
		Boolean respuesta = pb2.eliminarMateriaCorrelativa(pb1);

		assertTrue(respuesta);
	}
	
	@Test
	public void queSePuedaAsignarleUnaNotaALaMateria() {
		Integer codigoMateria = 2626;
		String nombre = "Programacion Basica 2";
		Integer primerParcial = 4;
		
		Materia pb2 = new Materia(codigoMateria, nombre);
		Nota nota = new Nota();
		nota.asignarNotaPrimerParcial(primerParcial);
		pb2.setNota(nota);
		Integer vo = pb2.getNota().getPrimerParcial();
		
		assertEquals(primerParcial, vo);
	}
	
	@Test
	public void queSePuedaAsignarNotaMayorOIgualASiete() {
		Integer codigoMateria = 2626;
		String nombre = "Programacion Basica 2";
		Integer codigoMateriaCorrelativa = 2619;
		String nombreMateriaCorrelativa = "Programacion Basica 1";
		Integer nota = 7;
		
		Materia pb2 = new Materia(codigoMateria, nombre);
		Materia pb1 = new Materia(codigoMateriaCorrelativa, nombreMateriaCorrelativa);
		pb2.agregarMateriaCorrelativa(pb1);
		pb1.asignarNotaPrimerParcial(7);
		pb1.asignarNotaSegundoParcial(5);
		pb2.asignarNotaPrimerParcial(7);
		Integer ve = nota;
		Integer vo = pb2.getNota().getPrimerParcial();
		
		assertEquals(ve, vo);

	}

}
