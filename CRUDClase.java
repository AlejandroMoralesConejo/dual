package jdbcPractica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDClase extends Conectar {

	public void alta(Clase entidad) {
		try { // insertar fila
			int update = getCon().createStatement().executeUpdate("INSERT INTO clase VALUES (" + entidad + ")");
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

	public void actualizar(Clase entidad) {
		String sSQL = "";
		PreparedStatement pstm = null;
		try {
			sSQL = "UPDATE clase SET curso = ?,planta = ?,edificio = ? WHERE idclase=" + entidad.getIdclase();
			pstm = getCon().prepareStatement(sSQL);
			pstm.setInt(1, entidad.getCurso());
			pstm.setString(2, entidad.getPlanta());
			pstm.setString(3, entidad.getEdificio());
			pstm.executeUpdate();
			System.out.println("La clase " + entidad.getIdclase() + " ha sido actualizada.");
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

	public void baja(Clase entidad) {
		try { // eliminar fila
			int delete = getCon().createStatement().executeUpdate("DELETE FROM clase WHERE idclase = " 
					+ entidad.getIdclase());
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
			res = getCon().createStatement().executeQuery("SELECT * FROM clase ORDER BY 1");
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
			res = getCon().createStatement().executeQuery("SELECT * FROM clase WHERE idclase=" + entidad);
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

	public void consulta(String planta, String edificio) {
		ResultSet res = null;
		try { // Ejecutarla
			res = getCon().createStatement().executeQuery("SELECT idclase,curso,planta,edificio"
					+ " FROM clase WHERE planta like '"+planta+"' AND edificio = '"+edificio+"'");
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
		System.out.println("Id_clase\tCurso\t\tPlanta\t\tEdificio");
		System.out.println("--------------------------------------------------------");
		while (res.next()) {
			for (int x = 1; x <= 4; x++) {
				System.out.format("%-16s", res.getString(x));
			}
			System.out.println();
		}
	}
}
