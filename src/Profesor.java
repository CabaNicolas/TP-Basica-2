
public class Profesor {

	private static Integer aumentarId = 0;
	private Integer dni;
	private String nombre;
	private String apellido;
	private Object id;

	public Profesor(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = Profesor.aumentarId ++;
	}

	public static Integer getAumentarId() {
		return aumentarId;
	}

	public static void setAumentarId(Integer aumentarId) {
		Profesor.aumentarId = aumentarId;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}



}
