package interfaces;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDAO {
	public int registrar(Alumno a);
	
	public int actualizar(Alumno a);
	
	public ArrayList<Alumno> listar();

	public int eliminar(Alumno a);
	
	public String leerCodigoAlumno();
	
	public Alumno listarAlumno(String codAlumno);
	
	public Alumno listarAlumnoDni(String dni);
	
	public int obtenerEstado(String codAlumno);
	
	public void actualizarEstadoAlumno(int estado, String codA);
	
	public ArrayList<Alumno> listarAlumnoXEstado(int estado);
	public ArrayList<Alumno> listarAlumnoXNombre(String nombre);
}
