
public class Aula {
	
	private static Integer aumentarId = 0;
	private Integer id;
	private Integer capacidad;
	

	public Aula(Integer capacidad) {
		this.capacidad = capacidad;
		this.id = Aula.aumentarId++;
	}


	public static Integer getAumentarId() {
		return aumentarId;
	}


	public static void setAumentarId(Integer aumentarId) {
		Aula.aumentarId = aumentarId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}
