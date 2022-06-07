package interfaces;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDAO {
	public int registrar(Alumno a);
	
	public int actualizar(Alumno a);
	
	public ArrayList<Alumno> listar();

	public int eliminar(Alumno a);
	
	public String leerCodigoAlumno();
}
