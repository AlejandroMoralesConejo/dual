package jdbcPractica;

public class Alumno {
	private int idalumno;
	private int idclase;
	private String nombre;
	private String apellidos;
	
	public Alumno(int idalumno, int idclase, String nombre, String apellidos) {
		this.idclase = idclase;
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return idalumno + "," +idclase+ ",'"+ nombre+"','"+apellidos+"'";
	}

	public int getIdalumno() {
		return idalumno;
	}

	public int getIdclase() {
		return idclase;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

}
