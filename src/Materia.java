import java.util.ArrayList;
import java.util.Objects;

public class Materia {

	private Integer id;
	private static Integer aumentarId = 0;
	private Integer codigoMateria;
	private String nombre;
	private ArrayList<Materia> materiasCorrelativas;
	private Nota nota;

	public Materia(Integer codigoMateria, String nombre) {
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.id = Materia.aumentarId++;
		this.materiasCorrelativas = new ArrayList<Materia>();
		this.nota = new Nota();
	}

	public Boolean asignarNotaPrimerParcial(Integer nota) {
		Boolean resultado = false;
		if (nota >= 7) {
			if (this.analizarEstadoDeCorrelativas() == this.materiasCorrelativas.size()) {
				resultado =  this.nota.asignarNotaPrimerParcial(nota);
			}
		}else {
			resultado = this.nota.asignarNotaPrimerParcial(nota);
		}
		
		return resultado;
	}

	public Boolean asignarNotaSegundoParcial(Integer nota) {
		Boolean resultado = false;
		if (nota >= 7) {
			if (this.analizarEstadoDeCorrelativas() == this.materiasCorrelativas.size()) {
				resultado = this.nota.asignarNotaSegundoParcial(nota);
			}
		}else {
			resultado =  this.nota.asignarNotaSegundoParcial(nota);
		}
		return resultado;
	}

	public Boolean agregarMateriaCorrelativa(Materia correlativa) {
		Boolean materiaAgregada = false;
		if (!this.materiasCorrelativas.contains(correlativa) && correlativa.getCodigoMateria() != this.codigoMateria) {
			materiaAgregada = this.materiasCorrelativas.add(correlativa);
		}
		return materiaAgregada;
	}

	public Integer analizarEstadoDeCorrelativas() { // analizarEstadoDeCorrelativas == materiasCorrelativas.size()
		Integer contadorDeMateriasCorrelativasAprobadas = 0;
		for (int i = 0; i < this.materiasCorrelativas.size(); i++) {
			if (materiasCorrelativas.get(i).getNota().chequearSiAprobo()
					|| materiasCorrelativas.get(i).getNota().chequearSiPromociona()) {
				contadorDeMateriasCorrelativasAprobadas++;
			}
		}

		return contadorDeMateriasCorrelativasAprobadas;
	}

	public Boolean eliminarMateriaCorrelativa(Materia correlativa) {
		Boolean materiaEliminada = false;
		if (this.materiasCorrelativas.contains(correlativa)) {
			materiaEliminada = this.materiasCorrelativas.remove(correlativa);
		}
		return materiaEliminada;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public ArrayList<Materia> getMateriasCorrelativas() {
		return materiasCorrelativas;
	}

	public void setMateriasCorrelativas(ArrayList<Materia> materiasCorrelativas) {
		this.materiasCorrelativas = materiasCorrelativas;
	}

	public Nota getNota() {
		return nota;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoMateria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(codigoMateria, other.codigoMateria);
	}

}
