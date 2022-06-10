package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	public static Connection getConexion() {
		Connection con = null;
		try {
<<<<<<< Updated upstream
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
			String url = "jdbc:mysql://localhost:3306/ciberfarma?useSSL=false&useTimezone=true&serverTimezone=UTC";
=======
			String url = "jdbc:mysql://localhost:3310/james_school?useSSL=false&useTimezone=true&serverTimezone=UTC";
>>>>>>> Stashed changes
=======
			String url = "jdbc:mysql://localhost:3310/james_school?useSSL=false&useTimezone=true&serverTimezone=UTC";
>>>>>>> Stashed changes
			String usr = "root";
=======
			Class.forName("com.mysql.cj.jdbc.Driver");
			          // dirver:protocoloDriver/ubicación/nombreBD/actualización 
			String url = "jdbc:mysql://localhost:3310/james_school?serverTimezone=UTC";
			String usr = "root"; //root
>>>>>>> Stashed changes
			String psw = "admin";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
