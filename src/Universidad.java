import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private static Integer aumentarId = 0;
	private Integer id;
	private ArrayList<Alumno> alumnos;
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
	}
	
	public Boolean agregarMateria(Materia materia) {
		Boolean resultado = false;
		if(!this.materias.contains(materia)) {
			resultado = this.materias.add(materia);
		}
		return resultado;
	}
	
	public Boolean asignarMateriaCorrelativa(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Boolean resultado = false;
		Materia materia = null;
		Materia materiaCorrelativa = null;
		for(int i = 0; i < this.materias.size(); i++) {
			if(this.materias.get(i).getCodigoMateria().equals(codigoMateria)) {
				materia = this.materias.get(i);
			}else if(this.materias.get(i).getCodigoMateria().equals(codigoMateriaCorrelativa)) {
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
		for(int i = 0; i < this.materias.size(); i++) {
			if(this.materias.get(i).getCodigoMateria().equals(codigoMateria)) {
				materia = this.materias.get(i);
			}else if(this.materias.get(i).getCodigoMateria().equals(codigoMateriaCorrelativa)) {
				materiaCorrelativa = this.materias.get(i);
			}
		}
		
		resultado = materia.eliminarMateriaCorrelativa(materiaCorrelativa);
		
		
		return resultado;
	}
	
	public Boolean agregarComision(Comision comision) {
		Boolean resultado = false;
		if(!this.comisiones.contains(comision)) {
			resultado = this.comisiones.add(comision);
		}
		return resultado;
	}
	
	public Boolean agregarAlumno(Alumno alumno) {
		Boolean resultado = false;
		if(!this.alumnos.contains(alumno)) {
			resultado = this.alumnos.add(alumno);
		}
		return resultado;
	}
	
	public Alumno buscarAlumno(Integer dni) {
		Alumno alumnoEncontrado = null;
		for(int i = 0; i < this.alumnos.size(); i++) {
			if(this.alumnos.get(i).getDni().equals(dni)) {
				alumnoEncontrado = this.alumnos.get(i);
		}
		}
		return alumnoEncontrado;
	}
	
	public Comision buscarComision(Integer id) {
		Comision comisionEncontrada = null;
		for(int i = 0; i < this.comisiones.size(); i++) {
			if(this.comisiones.get(i).getId().equals(id)) {
				comisionEncontrada = this.comisiones.get(i);
		}
		}
		return comisionEncontrada;
	}
	
	public Boolean inscribirAlumnoAComision(Integer dni, Integer id2) {
		Alumno alumnoAInscribir = buscarAlumno(dni);
		Comision comisionElegida = buscarComision(id2);
		Boolean estadoInscripcion = false;
		
		if(alumnoAInscribir!=null && comisionElegida!=null) {
			estadoInscripcion = comisionElegida.asignarAlumno(alumnoAInscribir);
		}
		return estadoInscripcion;
	}
	
	
	//Anotar alumno a la uni
	//Anotar alumno a materia (y correlativas)
	//metodos de aula
	
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
