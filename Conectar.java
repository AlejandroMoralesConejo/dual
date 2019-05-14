package jdbcPractica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conectar {

	public Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escuela", "yourusername",
					"yoursecurepassword");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return con;
	}
}
