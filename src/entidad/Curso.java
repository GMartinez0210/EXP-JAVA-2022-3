package entidad;

public class Curso {
	private int ciclo, creditos, horas, idCurso;
	private String codCurso, asignatura;
	
	public Curso (String codCurso, String asignatura, int ciclo, int creditos, int horas) {
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}
	
	public Curso() {
		
	}
	
	public void setCodCurso (String codCurso) {
		this.codCurso = codCurso;
	}
	public void setAsignaturas (String asignaturas) {
		this.asignatura = asignaturas;
	}
	public void setCiclo (int ciclo) {
		this.ciclo = ciclo;
	}
	public void setCreditos (int creditos) {
		this.creditos = creditos;
	}
	public void setHoras (int horas) {
		this.horas = horas;
	}
	public String getCodCurso () {
		return codCurso;
	}
	public String getAsignatura () {
		return asignatura;
	}
	public int getCiclo () {
		return ciclo;
	}
	public int getCreditos () {
		return creditos;
	}
	public int getHoras () {
		return horas;
	}
	
	public void setIdCurso (int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdCurso () {
		return idCurso;
	}
}
