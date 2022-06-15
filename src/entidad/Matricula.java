package entidad;

public class Matricula {
	private int idMatricula, estado;
	private String numMatricula, codAlumno, codCurso, fecha, hora, nombre;
	
	public Matricula(int idMatricula, int estado, String numMatricula, String codAlumno, String codCurso, String fecha,
			String hora, String nombre) {
		super();
		this.idMatricula = idMatricula;
		this.estado = estado;
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		this.nombre = nombre;
	}

	public Matricula (String numMatricula, String codAlumno, String codCurso, int estado, String fecha, String hora) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.estado = estado;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Matricula (String numMatricula, String codAlumno, String codCurso, String fecha, String hora) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Matricula() {
	}
	
	public void setIdMatricula (int idMatricula) {
		this.idMatricula = idMatricula;
	}
	
	public int getIdMatricula() {
		return idMatricula;
	}
	
	public void setNumMatricula (String numMatricula) {
		this.numMatricula = numMatricula;
	}
	
	public void setCodAlumno (String codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public void setCodCurso (String codCurso) {
		this.codCurso = codCurso;
	}
	
	public void setFecha (String fecha) {
		this.fecha = fecha;
	}
	
	public void setHora (String hora) {
		this.hora = hora;
	}
	
	public String getNumMatricula () {
		return numMatricula;
	}
	
	public String getCodAlumno () {
		return codAlumno;
	}
	
	public String getCodCurso () {
		return codCurso;
	}
	
	public String getFecha () {
		return fecha;
	}
	
	public String getHora () {
		return hora;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
