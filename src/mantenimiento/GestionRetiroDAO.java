package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Retiro;
import entidad.Retiro;
import interfaces.RetiroDAO;
import util.MySQLConexion8;

public class GestionRetiroDAO implements RetiroDAO {
	
	@Override
	public int registrar(Retiro retiro) {
		int registrar = 0;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "{call USP_AgregarRetiro(?,?,?,?)}";
			
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, retiro.getNumRetiro());
			pstm.setString(2, retiro.getNumMatricula());
			pstm.setString(3, retiro.getFecha());
			pstm.setString(4, retiro.getHora());
			
			registrar = pstm.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		
		if (registrar != 0) JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO", "Tienda Ccenhua", 1);
		
		return registrar;
	}

	@Override
	public int actualizar(String numRetiro, String codCurso) {
		int actualizar = 0;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "call USP_ModificarRetiro(?, ?)";
			
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, numRetiro);
			pstm.setString(2, codCurso);

			
			actualizar = pstm.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		
		if (actualizar != 0) JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSA", "Tienda Ccenhua", 1);
		
		return actualizar;
	}
	
	@Override
	public int eliminar(String codReporte) {
		int eliminar = 0;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "{call USP_EliminarRetiro(?)}";
			
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, codReporte);
			
			eliminar = pstm.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
				
		return eliminar;
	}

	@Override
	public ArrayList<Retiro> leer() {
		ArrayList<Retiro> retiroLista = new ArrayList<Retiro>();
		
		Retiro retiro;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "{call USP_LeerRetiro()}";
			
			pstm = connection.prepareStatement(sql);
			
			result = pstm.executeQuery();
			
			while(result.next()) {
				retiro = new Retiro();
				
				retiro.setIdRetiro(result.getInt(1));
				retiro.setNumRetiro(result.getString(2));
				retiro.setNumMatricula(result.getString(3));
				retiro.setCodAlumno(result.getString(4));
				retiro.setCodCurso(result.getString(5));
				retiro.setFecha(result.getString(6));
				retiro.setHora(result.getString(7));
				
				retiroLista.add(retiro);
			}
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		
		return retiroLista;
	}
	
	@Override
	public Retiro leer(int idRetiro) {
		Retiro retiro = null;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "{call USP_LeerIdRetiro(?)}";
			
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, idRetiro);
			
			result = pstm.executeQuery();
			
			while(result.next()) {
				retiro = new Retiro();
				
				retiro.setIdRetiro(result.getInt(1));
				retiro.setNumRetiro(result.getString(2));
				retiro.setNumMatricula(result.getString(3));
				retiro.setCodAlumno(result.getString(4));
				retiro.setCodCurso(result.getString(5));
				retiro.setFecha(result.getString(6));
				retiro.setHora(result.getString(7));
			}
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		
		return retiro;
	}
	
	@Override
	public Retiro leer(String codRetiro) {
		Retiro retiro = null;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion8.getConexion();
			
			String sql = "{call USP_LeerNumRetiro(?)}";
			
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, codRetiro);
			
			result = pstm.executeQuery();
			
			while(result.next()) {
				retiro = new Retiro();
				
				retiro.setIdRetiro(result.getInt(1));
				retiro.setNumRetiro(result.getString(2));
				retiro.setNumMatricula(result.getString(3));
				retiro.setCodAlumno(result.getString(4));
				retiro.setCodCurso(result.getString(5));
				retiro.setFecha(result.getString(6));
				retiro.setHora(result.getString(7));
			}
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR en la instruccion SQL: " + e.getMessage());
		} 
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
				
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		
		return retiro;
	}

	@Override
	public String generarCodigo() {
		String codCurso = null;
        Retiro retiro;
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet result = null;

        try {
            connection = MySQLConexion8.getConexion();

            String sql = "SELECT codRetiro from Retiro order by idCurso;";

            pstm = connection.prepareStatement(sql);

            result = pstm.executeQuery();

            while(result.next()) {
            	retiro = new Retiro();

            	retiro.setNumRetiro(result.getString(1));
                codCurso = retiro.getNumRetiro();
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
        int codRetiroNumero = Integer.parseInt(codCurso.replace("R", "")) + 1;
        return  "R" + codRetiroNumero;
	}
}
