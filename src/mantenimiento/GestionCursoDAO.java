package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Curso;
import interfaces.CursoDAO;
import util.MySQLConexion8;

public class GestionCursoDAO implements CursoDAO {

	@Override
	public int registrar(Curso curso) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection con = null;
		PreparedStatement pstm =null;
		try {
			//paso 1: Establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			//Paso 2: determine la isntruccion sql -->register
			String sql = "insert into  curso values (null,?,?,?,?,?);";
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
				System.out.println(">>>>>>>>>>Error al cerrar la base de datos" + e2.getMessage());
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
			String sql = "update curso set codCurso = ?, asignaturaCurso = ?, cicloCurso = ?, creditoCurso = ?, horasCurso = ? where idCurso = ?;";
			
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
		ArrayList<Curso> lista = new ArrayList<Curso>();
		
		Curso curso;
		PreparedStatement pstm = null;
		Connection connection = null;
		ResultSet result = null;
		
		try {
			// Paso 1: Establecer conexion
			connection = MySQLConexion8.getConexion();
			
			// Paso 2: Registrar
			String sql = "select * from curso;";
			
			// Paso 3: Creacion del objeto pstm y enviar la variable sql
			pstm = connection.prepareStatement(sql);
			
			// Paso 4: ejecutar la instruccion
			result = pstm.executeQuery();
			
			// Paso 5: corre la info
			while(result.next()) {
				curso = new Curso();
				
				curso.setIdCurso(result.getInt(1));
				curso.setCodCurso(result.getString(2));
				curso.setAsignaturas(result.getString(3));
				curso.setCiclo(result.getInt(4));
				curso.setCreditos(result.getInt(5));
				curso.setHoras(result.getInt(6));

				
				lista.add(curso);
			}
		} catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL " + e.getMessage());
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} catch (Exception e2) {
				System.out.println(">>> Error al cerrar la bd: " + e2.getMessage());
			}
		}
		
		return  lista;
	}

	@Override
	public String leerCodigo() {
		 
		String codigoCurso = null;
		Curso curso;
		PreparedStatement pstm = null;
		Connection connection = null;
		ResultSet result = null;
		
		try {
			// Paso 1: Establecer conexion
			connection = MySQLConexion8.getConexion();
			
			// Paso 2: Registrar
			String sql = "select codCurso from curso order by idCurso;";
			
			// Paso 3: Creacion del objeto pstm y enviar la variable sql
			pstm = connection.prepareStatement(sql);
			
			// Paso 4: ejecutar la instruccion
			result = pstm.executeQuery();
			
			// Paso 5: corre la info
			while(result.next()) {
				curso = new Curso();			

				curso.setCodCurso(result.getString(1));
				codigoCurso = curso.getCodCurso();
			}
		} catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL " + e.getMessage());
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} catch (Exception e2) {
				System.out.println(">>> Error al cerrar la bd: " + e2.getMessage());
			}
		}
		int codCurso = Integer.parseInt(codigoCurso.replace("C", ""))+1;
		return  "C"+codCurso;
	}
	
	@Override
	public int eliminar(Curso curso) {
	int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Paso 1: Establecer conexion
			con = MySQLConexion8.getConexion();
			
			// Paso 2: Registrar
			String sql = "delete from curso where codCurso = ?;";
			
			// Paso 3: Creacion del objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			
			// Paso 4: parametros
			pstm.setString(1, curso.getCodCurso());
			
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

}