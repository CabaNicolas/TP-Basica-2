
public class Nota {

	private Integer primerParcial;
	private Integer segundoParcial;
	private Boolean rindioRecuperatorio;

	public Boolean asignarNotaPrimerParcial(Integer primerParcial) {
		Boolean resultado = false;
		if (this.primerParcial == null && primerParcial >= 1 && primerParcial <= 10) {
			this.primerParcial = primerParcial;
			resultado = true;
		}
		return resultado;
	}

	public Boolean asignarNotaSegundoParcial(Integer segundoParcial) {
		Boolean resultado = false;
		if (this.segundoParcial == null && segundoParcial >= 1 && segundoParcial <= 10) {
			this.segundoParcial = segundoParcial;
			resultado = true;
		}
		return resultado;
	}

	public Boolean chequearSiPromociona() {
		Boolean promociono = false;
		if (this.chequearSiYaTieneNotaEnAmbosParciales() && this.primerParcial >= 7 && this.segundoParcial >= 7) {
			promociono = true;
		}
		return promociono;
	}

	public Boolean chequearSiAprobo() {
		Boolean aprobado = false;
		if (this.chequearSiYaTieneNotaEnAmbosParciales() && this.primerParcial >= 4 && this.segundoParcial >= 4) {
			aprobado = true;
		}

		return aprobado;
	}

	public Boolean puedeRecuperar() {
		Boolean puedeRecuperar = false;
		if (!this.rindioRecuperatorio && (this.primerParcial >= 4 || this.segundoParcial >= 4)) {
			puedeRecuperar = true;
		}
		return puedeRecuperar;
	}

	public Boolean asignarNotaRecuperatorio(Integer notaRecuperatorio) {
		if (this.puedeRecuperar()) {
			if (this.primerParcial < 4) {
				this.primerParcial = notaRecuperatorio;
			} else {
				this.segundoParcial = notaRecuperatorio;
			}
			this.rindioRecuperatorio = true;
		}
		return this.rindioRecuperatorio;
	}

	public Boolean chequearSiYaTieneNotaEnAmbosParciales() {
		Boolean rindioAmbosParciales = false;
		if (this.primerParcial != null && this.segundoParcial != null) {
			rindioAmbosParciales = true;
		}

		return rindioAmbosParciales;
	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

}
