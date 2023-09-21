
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

}
