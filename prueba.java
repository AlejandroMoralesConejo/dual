package jdbcPractica;

public class prueba {

	public static void main(String[] args) {
		CRUDAlumno prueba1 = new CRUDAlumno();
		//Alumno jaja = new Alumno(1,1,"Saul","Jimenez Fortes");
		//Clase antonio = new Clase(1,10,"Miguel","Blanco");
		//prueba1.listar();
		Where where = new Where("Idalumno");
		prueba1.consulta(where.entre("1 and 2"));
		
	}

}