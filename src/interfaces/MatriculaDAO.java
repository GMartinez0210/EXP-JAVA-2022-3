package interfaces;

import java.util.ArrayList;

import entidad.Matricula;

public interface MatriculaDAO {
	public int registrar(Matricula matricula);
	
	public int actualizar(Matricula matricula);
	
	public ArrayList<Matricula> leer();
	
	public int eliminar(Matricula matricula);
}
