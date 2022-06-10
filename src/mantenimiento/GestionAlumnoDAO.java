package mantenimiento;

import java.util.ArrayList;

import entidad.Alumno;
import interfaces.AlumnoDAO;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
import util.MySQLConexion8;
>>>>>>> Stashed changes

public class GestionAlumnoDAO implements AlumnoDAO {

	@Override
	public int registrar(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Alumno> leer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int eliminar(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}
<<<<<<< Updated upstream
=======
	
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

	@Override
	public int obtenerEstado(String codAlumno) {
		int estadoAlumno = 0;
		
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        
        try {
            con = MySQLConexion8.getConexion();
            String sql = "{call usp_obtenerEstadoAlumno(?)}";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codAlumno);
            res = pstm.executeQuery();
            
            while(res.next()) {            	
            	estadoAlumno = res.getInt(1);
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
		
		return estadoAlumno;
	}
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
