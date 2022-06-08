package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Alumno;
import util.MySQLConexion8;

public class GestionAlumnoDAO {

	public int registrar(Alumno a) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm =null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into james_school.alumno values (null,?,?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getCodAlumno());
			pstm.setString(2, a.getNombres());
			pstm.setString(3, a.getApellidos());
			pstm.setString(4, a.getDni());
			pstm.setInt(5, a.getEdad());
			pstm.setInt(6, a.getCelular());
			pstm.setInt(7, a.getEstado());
			
			res =pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Error en la instruccion SQL - Registrar" + e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con != null)pstm.close();
			} catch (SQLException e2) {
				System.out.println(">>>>>>>>>>Error al cerrar la base de da datos" + e2.getMessage());
			}
		}
		return res;
	}

	public int actualizar(Alumno a) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update alumno set nombreAlumno = ?, apellidoAlumno = ?, dniAlumno = ?, edadAlumno = ?, estadoAlumno = ? where codAlumno = ?;";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, a.getNombres());
			pstm.setString(2, a.getApellidos());
			pstm.setString(3, a.getDni());
			pstm.setInt(4, a.getEdad());
			pstm.setInt(5, a.getEstado());
			pstm.setString(6, a.getCodAlumno());
			
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

	public ArrayList<Alumno> listar() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Alumno a;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM alumno";
			pstm = con.prepareStatement(sql);
			 res = pstm.executeQuery();
			 while(res.next()) {
				a = new Alumno();
				a.setCodAlumno(res.getString(2));
				a.setNombres(res.getString(3));
				a.setApellidos(res.getString(4));
				a.setDni(res.getString(5));
				a.setEdad(res.getInt(6));
				a.setCelular(res.getInt(7));
				a.setEstado(res.getInt(8));
				 
				lista.add(a);
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
		return lista ;
	}
	
	public int eliminar(Alumno a) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "delete from james_school.alumno where codAlumno = ?;";
			pstm = con.prepareStatement(sql);

			pstm.setString(1, a.getCodAlumno());

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
	
    public String leerCodigoAlumno() {

        String codigoAlumno = null;
        Alumno alumno;
        
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet result = null;
        try {
            connection = MySQLConexion8.getConexion();
            String sql = "select codAlumno from alumno order by idAlumno;";
            pstm = connection.prepareStatement(sql);
            result = pstm.executeQuery();
            while(result.next()) {
            	alumno = new Alumno();

                alumno.setCodAlumno(result.getString(1));
                codigoAlumno = alumno.getCodAlumno();
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
        int codAlumno = Integer.parseInt(codigoAlumno.replace("A", ""))+1;
        return  "A"+codAlumno;
    }

    public Alumno listarAlumno(String codAlumno){
        Alumno alumno = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            con = MySQLConexion8.getConexion();
            String sql = "SELECT * from james_school.alumno where codAlumno = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codAlumno);
            res = pstm.executeQuery();
            while(res.next()) {
                alumno = new Alumno();
                alumno.setCodAlumno(res.getString(2));
                alumno.setNombres(res.getString(3));
                alumno.setApellidos(res.getString(4));
                alumno.setDni(res.getString(5));
                alumno.setEdad(res.getInt(6));
                alumno.setEstado(res.getInt(8));
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
        return alumno;
    }

    public Alumno listarAlumnoDni(String dni){
        Alumno alumno = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            con = MySQLConexion8.getConexion();
            String sql = "SELECT * from james_school.alumno where dniAlumno = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dni);
            res = pstm.executeQuery();
            while(res.next()) {
                alumno = new Alumno();
                alumno.setCodAlumno(res.getString(2));
                alumno.setNombres(res.getString(3));
                alumno.setApellidos(res.getString(4));
                alumno.setDni(res.getString(5));
                alumno.setEdad(res.getInt(6));
                alumno.setEstado(res.getInt(8));
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
        return alumno;
    }
}
