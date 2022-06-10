package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Matricula;
import interfaces.MatriculaDAO;
import util.MySQLConexion8;

public class GestionMatriculaDAO implements MatriculaDAO {

	@Override
	public int registrar(Matricula mtrl) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "INSERT INTO matricula values (null, ?, ?, ?, ?, ?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, mtrl.getNumMatricula());
			pstm.setString(2, mtrl.getCodAlumno());
			pstm.setString(3, mtrl.getCodCurso());
			pstm.setString(4, mtrl.getFecha());
			pstm.setString(5, mtrl.getHora());
			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Registrar " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		
		return res;
	}

	@Override
	public int actualizar(String nMatricula, String cCurso) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update matricula set codCurso = ? where numMatricula = ?";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, cCurso);
			pstm.setString(2, nMatricula);
			
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
	public ArrayList<Matricula> leer() {
		ArrayList<Matricula> lista = new ArrayList<Matricula>();//null
		Matricula matri;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "SELECT * FROM matricula;";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while(res.next()) {
				matri = new Matricula();
			
				matri.setNumMatricula(res.getString(2));
				matri.setCodAlumno(res.getString(3));
				matri.setCodCurso(res.getString(4));
				matri.setFecha(res.getString(5));
				matri.setHora(res.getString(6));
			
				lista.add(matri);	 
			}
							
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>> Error en la Instrucción SQL - Consultar" + e.getMessage());
		}finally {
			try {
				if(pstm != null ) pstm.close();
				if(res != null) res.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int eliminar(String numMatricula) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "delete from matricula where numMatricula = ?";
			pstm = con.prepareStatement(sql);

			pstm.setString(1, numMatricula);

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
	public String obtenerCodigoCo() {
		String codigoMatricula = null;
        Matricula matricula;
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet result = null;

        try {
            // Paso 1: Establecer conexion
            connection = MySQLConexion8.getConexion();

            // Paso 2: Registrar
            String sql = "select numMatricula from matricula order by idMatricula;";

            // Paso 3: Creacion del objeto pstm y enviar la variable sql
            pstm = connection.prepareStatement(sql);

            // Paso 4: ejecutar la instruccion
            result = pstm.executeQuery();

            // Paso 5: corre la info
            while(result.next()) {
                matricula = new Matricula();

                matricula.setNumMatricula(result.getString(1));
                codigoMatricula = matricula.getNumMatricula();
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
        int codCurso = Integer.parseInt(codigoMatricula.replace("M", ""))+1;
        return  "M"+codCurso;
	}

	@Override
	public Matricula consultar(String matricula) {
        Matricula matr = new Matricula();
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet res = null;
        
        try {
            connection = MySQLConexion8.getConexion();

            String sql = "{call usp_consultarMatricula(?)}";

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, matricula);
            res = pstm.executeQuery();

            while(res.next()) {	
            	matr.setIdMatricula(res.getInt(1));
            	matr.setNumMatricula(res.getString(2));
            	matr.setCodAlumno(res.getString(3));
            	matr.setCodCurso(res.getString(4));
            	matr.setFecha(res.getString(5));
            	matr.setHora(res.getString(6));
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
        
		return matr;
	}

	

}
