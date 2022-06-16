package interfaces;

import java.util.ArrayList;

import entidad.Retiro;

public interface RetiroDAO {
	// registrar
	public int registrar(Retiro retiro);
	
	// actualizar
	public int actualizar(String numRetiro, String codCurso);
	
	// eliminar
	public int eliminar(String codRetiro);
	
	// leer
	public ArrayList<Retiro> leer();
	public Retiro leer(int idRetiro);
	public Retiro leer(String numRetiro);
	
	// generar codigo correlativo
	public String generarCodigo();
}
