package interfaces;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDAO {
	public int registrar(Alumno alumno);
	
	public int actualizar(Alumno alumno);
	
	public ArrayList<Alumno> leer();

	public int eliminar(Alumno alumno);
}
