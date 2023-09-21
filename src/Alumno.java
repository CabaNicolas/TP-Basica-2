import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Alumno {
	
	private static Integer aumentarId = 0;
	private Integer id;
	private Integer dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaIngreso;
	private ArrayList<Materia> materias;
	
	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaIngreso) {
		this.id = Alumno.aumentarId++;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.materias = new ArrayList<Materia>();
	}
	
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public static Integer getAumentarId() {
		return aumentarId;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public static void setAumentarId(Integer aumentarId) {
		Alumno.aumentarId = aumentarId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
}
