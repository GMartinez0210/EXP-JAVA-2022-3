package interfaces;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDAO {
	public int registrar(Alumno alumno);
	
	public int actualizar(Alumno alumno);
	
	public ArrayList<Alumno> leer();

<<<<<<< Updated upstream
	public int eliminar(Alumno alumno);
=======
	public int eliminar(Alumno a);
	
	public String leerCodigoAlumno();
	
	public Alumno listarAlumno(String codAlumno);
	
	public Alumno listarAlumnoDni(String dni);
	
	public int obtenerEstado(String codAlumno);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
