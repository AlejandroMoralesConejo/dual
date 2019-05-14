package jdbcPractica;

public class Clase {
	private int idclase;
	private int curso;
	private String planta;
	private String edificio;
	
	public Clase(int id,int curso,String planta,String edificio) {
		this.idclase = id;
		this.curso = curso;
		this.planta = planta;
		this.edificio = edificio;
	}
	
	public Clase(int id) {
		this.idclase = id;
	}

	@Override
	public String toString() {
		return "DEFAULT,"+curso + ",'" +planta+ "','"+ edificio+"'";
	}

	public int getIdclase() {
		return idclase;
	}

	public String getEdificio() {
		return edificio;
	}

	public int getCurso() {
		return curso;
	}

	public String getPlanta() {
		return planta;
	}
	
}
