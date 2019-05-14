package jdbcPractica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDAlumno extends Conectar {
	

	public void alta(Alumno entidad) {
		try { // insertar fila
			int update = getCon().createStatement().executeUpdate("INSERT INTO alumno VALUES (" + entidad + ")");
			System.out.println("Nº de objetos insertados: " + update);
		} catch (SQLException up) {
			up.getMessage();
		}
		finally {
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}
	}

	public void actualizar(Alumno entidad) {
		String sSQL = "UPDATE alumno SET idclase = ?,nombre = ?,apellidos = ? WHERE idalumno=" + entidad.getIdalumno();
		PreparedStatement pstm = null;
		try {
			pstm = getCon().prepareStatement(sSQL);
			pstm.setInt(1, entidad.getIdclase());
			pstm.setString(2, entidad.getNombre());
			pstm.setString(3, entidad.getApellidos());
			pstm.executeUpdate();
			System.out.println("El alumno "+ entidad.getIdalumno() + " ha sido actualizado.");
		} catch (SQLException up) {
			System.out.println(up.getMessage());
			System.out.println("No se ha podido actualizar");
		}
		finally {
	        if (pstm != null) {
	            try { pstm.close(); }
	            catch (SQLException ignore) { }
	        }
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}

	}

	public void baja(Alumno entidad) {
		try { // eliminar fila
			int delete = getCon().createStatement().executeUpdate("DELETE FROM alumno WHERE idalumno =" 
																	+ entidad.getIdalumno());
			System.out.println("Nº de filas borradas: " + delete);
		} catch (SQLException up) {
			up.getMessage();
		}
		finally {
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}
	}

	public void listar() {
		ResultSet res = null;
		try { // Ejecutarla
			res = getCon().createStatement().executeQuery("SELECT * FROM alumno ORDER BY 1");
			mostrarSelect(res);
		} catch (SQLException res1) {
			System.out.println(res1.getMessage());
		}
		finally {
	        if (res != null) {
	            try { res.close(); }
	            catch (SQLException ignore) { }
	        }
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}
	}

	public void consultaId(int entidad) {
		ResultSet res = null;
		try { // Ejecutarla
			res = getCon().createStatement().executeQuery("SELECT * FROM alumno WHERE idalumno=" + entidad);
			mostrarSelect(res);
		} catch (SQLException res1) {
			System.out.println(res1.getMessage());
		}
		finally {
	        if (res != null) {
	            try { res.close(); }
	            catch (SQLException ignore) { }
	        }
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}
	}
	
	public void consulta(String nombre, String apellidos) {
		ResultSet res = null;
		try { // Ejecutarla
			res = getCon().createStatement().executeQuery("SELECT idalumno,idclase,nombre,apellidos"
					+ " FROM alumno WHERE nombre = '"+nombre+"' AND apellidos = '"+apellidos+"'");
			mostrarSelect(res);
		} catch (SQLException res1) {
			System.out.println(res1.getMessage());
		}
		finally {
	        if (res != null) {
	            try { res.close(); }
	            catch (SQLException ignore) { }
	        }
	        if (getCon() != null) {
	            try { getCon().close(); }
	            catch (SQLException ignore) { }
	        }
		}
	}

	public void mostrarSelect(ResultSet res) throws SQLException {
		System.out.println("Id_alumno\tId_clase\tNombre\t\tApellidos");
		System.out.println("--------------------------------------------------------");
		while (res.next()) {
			for (int x = 1; x <= 4; x++) {
				System.out.format("%-16s", res.getString(x));
			}
			System.out.println();
		}
	}
}