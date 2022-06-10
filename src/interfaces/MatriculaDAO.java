package interfaces;

import java.util.ArrayList;

import entidad.Matricula;

public interface MatriculaDAO {
	public int registrar(Matricula matricula);
	
	public Matricula consultar(String Matricula);
	
	public int actualizar(String nMatricula, String cCurso);
	
	public ArrayList<Matricula> leer();
	
	public int eliminar(String numMatricula);
	
	public String obtenerCodigoCo();
}
