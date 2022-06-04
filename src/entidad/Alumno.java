package entidad;

public class Alumno {
	private int edad, celular, estado, idAlumno;
	private String codAlumno, nombres, apellidos,dni;
	
	public Alumno (String codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado, int idAlumno) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
		this.idAlumno = idAlumno;
	}
	
	public Alumno (String codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;	
	}
	
	public Alumno() {
		
	}
	
	public void setIdAlumno (int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public void setCodAlumno (String codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public void setNombres (String nombres) {
		this.nombres = nombres;
	}
	
	public void setApellidos (String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setDni (String dni) {
		this.dni = dni;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setCelular (int celular) {
		this.celular = celular;
	}
	
	public void setEstado (int estado) {
		this.estado = estado;
	}
	
	public String getCodAlumno () {
		return codAlumno;
	}
	
	public int getIdAlumno () {
		return idAlumno;
	}
	
	public String getNombres () {
		return nombres;
	}
	
	public String getApellidos () {
		return apellidos;
	}
	
	public String getDni () {
		return dni;
	}
	
	public int getEdad () {
		return edad;
	}
	
	public int getCelular () {
		return celular;
	}
	
	public int getEstado () {
		return estado;
	}
}
