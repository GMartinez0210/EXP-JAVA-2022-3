package interfaces;

import java.util.ArrayList;

import entidad.Curso;

public interface CursoDAO {
	public int registrar(Curso curso);
	
	public int actualizar(Curso curso);
	
	public ArrayList<Curso> leer();
	
	public int eliminar(Curso curso);
	
	public String leerCodigo();
}
