package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Curso;
import interfaces.CursoDAO;
import util.MySQLConexion8;

public class GestionCursoDAO implements CursoDAO {

	public int registrar(Curso curso) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection con = null;
		PreparedStatement pstm =null;
		try {
			//paso 1: Establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			//Paso 2: determine la isntruccion sql -->register
			String sql = "insert into  curso values (?,?,?,?,?,?);";
			//paso 3: crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			//paso 4: parametros
			pstm.setString(1, curso.getCodCurso());
			pstm.setString(2, curso.getAsignatura());
			pstm.setInt(3, curso.getCiclo());
			pstm.setInt(4, curso.getCreditos());
			pstm.setInt(5, curso.getHoras());
			//paso 5 ejecutar la instruccion
			res =pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Error en la instruccion SQL - Registrar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con != null)pstm.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>>>Error al cerrar la basde da datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Curso curso) {
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Paso 1: Establecer conexion
			con = MySQLConexion8.getConexion();
			
			// Paso 2: Registrar
			String sql = "update jugador set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, sueldo = ? where idCurso = ?;";
			
			// Paso 3: Creacion del objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			
			// Paso 4: parametros
			
			pstm.setString(1, curso.getCodCurso());
			pstm.setString(2, curso.getAsignatura());
			pstm.setInt(3, curso.getCiclo());
			pstm.setInt(4, curso.getCreditos());
			pstm.setInt(5, curso.getHoras());
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL " + e.getMessage());
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (con != null) con.close();
				
			} catch (Exception e2) {
				System.out.println(">>> Error al cerrar la bd: " + e2.getMessage());
			}
		}
		
		return res;
	}

	@Override
	public ArrayList<Curso> leer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(Curso curso) {
		// TODO Auto-generated method stub
		return 0;
	}

}