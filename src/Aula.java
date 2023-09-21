
public class Aula {
	
	private static Integer aumentarId = 0;
	private Integer id;
	private Integer capacidad;
	

	public Aula(Integer capacidad) {
		this.capacidad = capacidad;
		this.id = Aula.aumentarId++;
	}

}
