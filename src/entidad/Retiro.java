package entidad;

public class Retiro {
	private int idRetiro;
	private String numRetiro, numMatricula, fecha, hora;
	private String codAlumno, codCurso;
	
	public Retiro(int idRetiro, String numRetiro, String numMatricula, String fecha, String hora, String codAlumno,
			String codCurso) {
		super();
		this.idRetiro = idRetiro;
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
	}

	public Retiro(String numRetiro, String numMatricula, String fecha, String hora) {
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Retiro() {
	}
	
	public void setIdRetiro (int idRetiro) {
		this.idRetiro = idRetiro;
	}
	
	public int getIdRetiro () {
		return idRetiro;
	}
	
	public void setNumRetiro (String numRetiro) {
		this.numRetiro = numRetiro;
	}
	
	public void setNumMatricula (String numMatricula) {
		this.numMatricula = numMatricula;
	}
	
	public void setFecha (String fecha) {
		this.fecha = fecha;
	}
	
	public void setHora (String hora) {
		this.hora = hora;
	}
	
	public String getNumRetiro () {
		return numRetiro;
	}
	
	public String getNumMatricula () {
		return numMatricula;
	}
	
	public String getFecha () {
		return fecha;
	}
	
	public String getHora () {
		return hora;
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
}
