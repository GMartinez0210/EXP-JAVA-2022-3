package interfaces;

import java.util.ArrayList;

import entidad.Retiro;

public interface RetiroDAO {
	// registrar
	public int registrar(Retiro retiro);
	
	// actualizar
	public int actualizar(Retiro retiro);
	
	// eliminar
	public int eliminar(int idRetiro);
	public int eliminar(String codRetiro);
	
	// leer
	public ArrayList<Retiro> leer();
	public Retiro leer(int idRetiro);
	public Retiro leer(String codRetiro);
	
	// generar codigo correlativo
	public String generarCodigo();
}
