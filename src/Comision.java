import java.util.ArrayList;

public class Comision {
	
	private static Integer aumentarId = 0;
	private Integer id;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Dia dia;
	private Turno turno;
	private Aula aula;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;

	public Comision(Materia materia, CicloLectivo nuevoCiclo, Dia dia, Turno turno, Aula aula) {
		this.materia = materia;
		this.cicloLectivo = nuevoCiclo;
		this.dia = dia;
		this.turno = turno;
		this.aula = aula;
		this.id = Comision.aumentarId++;
		this.alumnos = new ArrayList<Alumno>();
		this.profesores = new ArrayList<Profesor>();
	}
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void asginarAula(Aula aula) {
		this.aula = aula;
	}
	
	public Boolean asignarAlumno(Alumno alumno) {
		Boolean resultado = false;
		if(!this.alumnos.contains(alumno)) {
			resultado = this.alumnos.add(alumno);
		}
		return resultado;
	}

	public static Integer getAumentarId() {
		return aumentarId;
	}

	public Integer getId() {
		return id;
	}

	public Materia getMateria() {
		return materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public Dia getDia() {
		return dia;
	}

	public Turno getTurno() {
		return turno;
	}

	public Aula getAula() {
		return aula;
	}

	public static void setAumentarId(Integer aumentarId) {
		Comision.aumentarId = aumentarId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	
}
