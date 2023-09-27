import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private static Integer aumentarId = 0;
	private Integer id;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private CicloLectivo cicloLectivo;
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.id = Universidad.aumentarId++;
		this.materias = new ArrayList<Materia>();
		this.comisiones = new ArrayList<Comision>();
		this.alumnos = new ArrayList<Alumno>();
		this.profesores = new ArrayList<Profesor>();
	}

	public Boolean agregarMateria(Materia materia) {
		Boolean resultado = false;
		if (!this.materias.contains(materia)) {
			resultado = this.materias.add(materia);
		}
		return resultado;
	}

	public Boolean asignarMateriaCorrelativa(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Boolean resultado = false;
		Materia materia = null;
		Materia materiaCorrelativa = null;
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigoMateria().equals(codigoMateria)) {
				materia = this.materias.get(i);
			} else if (this.materias.get(i).getCodigoMateria().equals(codigoMateriaCorrelativa)) {
				materiaCorrelativa = this.materias.get(i);
			}
		}

		resultado = materia.agregarMateriaCorrelativa(materiaCorrelativa);

		return resultado;
	}

	public Boolean eliminarMateriaCorrelativa(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Boolean resultado = false;
		Materia materia = null;
		Materia materiaCorrelativa = null;
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigoMateria().equals(codigoMateria)) {
				materia = this.materias.get(i);
			} else if (this.materias.get(i).getCodigoMateria().equals(codigoMateriaCorrelativa)) {
				materiaCorrelativa = this.materias.get(i);
			}
		}

		resultado = materia.eliminarMateriaCorrelativa(materiaCorrelativa);

		return resultado;
	}

	public Boolean agregarComision(Comision comision) {
		Boolean resultado = false;
		if (!this.comisiones.contains(comision)) {
			resultado = this.comisiones.add(comision);
		}
		return resultado;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		Boolean resultado = false;
		if (!this.alumnos.contains(alumno)) {
			resultado = this.alumnos.add(alumno);
		}
		return resultado;
	}

	public Alumno buscarAlumno(Integer dni) {
		Alumno alumnoEncontrado = null;
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				alumnoEncontrado = this.alumnos.get(i);
			}
		}
		return alumnoEncontrado;
	}

	public Profesor buscarProfesor(Integer dni) {
		Profesor profesorEncontrado = null;
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				profesorEncontrado = this.profesores.get(i);
			}
		}
		return profesorEncontrado;
	}

	public Comision buscarComision(Integer id) {
		Comision comisionEncontrada = null;
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(id)) {
				comisionEncontrada = this.comisiones.get(i);
			}
		}
		return comisionEncontrada;
	}

	public Boolean verificarSiYaAprobo(Alumno alumno, Comision comision) {
		Boolean yaLaAprobo = false;
		ArrayList<Materia> materiasAprobadas = alumno.getMateriasAprobadas();

		for (int i = 0; i < materiasAprobadas.size(); i++) {
			if (materiasAprobadas.get(i).equals(comision.getMateria())) {
				yaLaAprobo = true;
			}
		}
		return yaLaAprobo;
	}

	public Boolean verificarDuplicidad(Alumno alumno, Comision comision) {
		Boolean estaDuplicado = false;
		ArrayList<Comision> comisionesAlumno = alumno.getComisiones();

		for (int i = 0; i < comisionesAlumno.size(); i++) {
			Dia diaAlumno = comisionesAlumno.get(i).getDia();
			Turno turnoAlumno = comisionesAlumno.get(i).getTurno();
			if (comision.getDia().equals(diaAlumno) && comision.getTurno().equals(turnoAlumno)) {
				estaDuplicado = true;
			}
		}

		return estaDuplicado;
	}

	public Boolean verificarCapacidad(Comision comision) {
		Boolean hayCupo = false;
		Integer capacidadAula = comision.getAula().getCapacidad();
		Integer cantidadAlumnos = comision.getAlumnos().size();
		if (cantidadAlumnos < capacidadAula) {
			hayCupo = true;
		}

		return hayCupo;
	}

	public Boolean verificarCorrelativa(Comision comision, Alumno alumno) {
		Boolean correlativasAprobadadas = false;

		Materia comisionMateria = comision.getMateria(); // pb2
		Integer contadorDeMateriasCorrelativasAprobadas = 0;
		ArrayList<Materia> materiasCorrelativas = comisionMateria.getMateriasCorrelativas();
		ArrayList<Materia> materiasAprobadas = alumno.getMateriasAprobadas();

		for (int i = 0; i < materiasAprobadas.size(); i++) {
			for (int j = 0; j < materiasCorrelativas.size() - 1; j++) {
				if (materiasAprobadas.get(i).equals(materiasCorrelativas.get(j))) {
					contadorDeMateriasCorrelativasAprobadas++;
				}
			}
		}
		if (contadorDeMateriasCorrelativasAprobadas == materiasCorrelativas.size()) {
			correlativasAprobadadas = true;
		}
		return correlativasAprobadadas;
	}

	public Boolean verificarFecha(LocalDate fechaActual) {
		Boolean fechaRango = false;
		if (fechaActual.isAfter(this.cicloLectivo.getFechaInicioInscripcion())
				&& fechaActual.isBefore(this.cicloLectivo.getFechaFinalizacionInscripcion())) {
			fechaRango = true;
		}
		return fechaRango;
	}

	public Boolean inscribirAlumnoAComision(Integer dni, Integer id2, LocalDate fechaActual) {
		Alumno alumnoAInscribir = buscarAlumno(dni);
		Comision comisionElegida = buscarComision(id2);
		Boolean estadoInscripcion = false;
		if (alumnoAInscribir != null && comisionElegida != null && verificarFecha(fechaActual)
				&& verificarCorrelativa(comisionElegida, alumnoAInscribir) && verificarCapacidad(comisionElegida)
				&& !verificarDuplicidad(alumnoAInscribir, comisionElegida)
				&& !verificarSiYaAprobo(alumnoAInscribir, comisionElegida)) {
			estadoInscripcion = comisionElegida.asignarAlumno(alumnoAInscribir);
			alumnoAInscribir.getMaterias().add(comisionElegida.getMateria());
			alumnoAInscribir.getComisiones().add(comisionElegida);
		}
		return estadoInscripcion;
	}

	public Boolean inscribirProfesorAComision(Integer dni, Integer id2) {
		Comision comisionElegida = buscarComision(id2);
		Profesor profesorAInscribir = buscarProfesor(dni);
		Boolean asignacionProfesor = false;

		Integer cantidadAlumnos = comisionElegida.getAlumnos().size();
		Integer limiteProfesores = cantidadAlumnos / 20;

		if (cantidadAlumnos > 1 && comisionElegida.getProfesores().size() == limiteProfesores) {
			comisionElegida.getProfesores().add(profesorAInscribir);
			asignacionProfesor = true;
		}

		return asignacionProfesor;
	}

	public Boolean registrarNota(Integer idComision, Integer dniAlumno, Integer nota, String tipoDeParcial) {
		Boolean exitoEnRegistroDeNota = false;
		Comision comision = buscarComision(idComision);
		Alumno alumno = null;
		Materia materia = null;
		if (comision != null) {
			alumno = comision.encontrarAlumno(dniAlumno);
		}

		for (int i = 0; i < alumno.getMaterias().size(); i++) {
			if (comision.getMateria().equals(alumno.getMaterias().get(i))) {
				materia = alumno.getMaterias().get(i);
				switch (tipoDeParcial.toLowerCase()) {
				case "primer parcial":
					exitoEnRegistroDeNota = materia.asignarNotaPrimerParcial(nota);
					break;
				case "segundo parcial":
					exitoEnRegistroDeNota = materia.asignarNotaSegundoParcial(nota);
					break;
				case "recuperatorio":
					if (alumno.getMaterias().get(i).getNota().puedeRecuperar()) {
						exitoEnRegistroDeNota = materia.getNota().asignarNotaRecuperatorio(nota);
					}
					break;
				}
			}
		}

		aprobarMateria(materia, alumno);

		return exitoEnRegistroDeNota;
	}

	public void aprobarMateria(Materia materia, Alumno alumno) {
		for (int i = 0; i < alumno.getMaterias().size(); i++) {
			if (alumno.getMaterias().get(i).equals(materia)) {
				if (alumno.getMaterias().get(i).getNota().chequearSiAprobo()
						|| alumno.getMaterias().get(i).getNota().chequearSiPromociona()) {
					alumno.getMateriasAprobadas().add(materia);
				}
			}
		}
	}

	public String obtenerListadoMateriasAprobadasParaUnAlumno(Integer dniAlumno) {
		Alumno alumno = buscarAlumno(dniAlumno);
		ArrayList<Materia> materiasAprobadas = null;
		String lista = "";
		if (alumno != null) {
			materiasAprobadas = alumno.getMateriasAprobadas();
			for (int i = 0; i < materiasAprobadas.size(); i++) {
				lista += alumno.getDni() + " " + alumno.getNombre() + " " + alumno.getApellido() + " "
						+ materiasAprobadas.get(i).getNombre() + " "
						+ materiasAprobadas.get(i).getNota().getPrimerParcial() + "\n";
			}

		}
		return lista;
	}

	public String obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dniAlumno) {
		ArrayList<Materia> materiasQueFaltanCursar = new ArrayList<Materia>();
		Alumno alumno = buscarAlumno(dniAlumno);
		String lista = "";
		if (alumno != null) {
			for (int i = 0; i < this.materias.size(); i++) {
				if (!alumno.getMaterias().contains(this.materias.get(i))) {
					materiasQueFaltanCursar.add(this.materias.get(i));
				}
			}
		}
		
		for (int i = 0; i < materiasQueFaltanCursar.size(); i++) {
			lista += materiasQueFaltanCursar.get(i).getNombre() + "\n";
		}
		
		
		return lista;
	}

	public String obtenerReporteDeNotasDeAumnosDeCurso(Integer idCurso) {
		Comision comision = buscarComision(idCurso);
		String lista = "";
		for (int i = 0; i < comision.getAlumnos().size(); i++) {
			lista += comision.getId() + " " + comision.getMateria().getNombre() + " " + comision.getAlumnos().get(i).getNombre() + " " + comision.getAlumnos().get(i).getApellido() + " " + comision.getMateria().getNota().getPrimerParcial() + "\n";
		}
		
		return lista;
	}
	
	public String getNombre() {
		return nombre;
	}

	public static Integer getAumentarId() {
		return aumentarId;
	}

	public Integer getId() {
		return id;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static void setAumentarId(Integer aumentarId) {
		Universidad.aumentarId = aumentarId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

}
