package jdbcPractica;

import java.util.Arrays;
import java.util.List;

public class Where {
	private String campo;
	private List<String> operador = Arrays.asList("=","like",">","<","!=",">=","<=","between");
	
	
	public Where(String a) {
		this.campo = a;
	}
	
	
	
	public String igual(String condicion) {
		return st(operador.get(0),condicion);
	}
	
	public String like(String condicion) {
		return st(operador.get(1),condicion);
	}
	
	public String mayorque(int condicion) {
		return stin(operador.get(2),condicion);
	}
	public String menorque(int condicion) {
		return stin(operador.get(3),condicion);
	}
	public String distinto(int condicion) {
		return stin(operador.get(4),condicion);
	}
	public String mayorigual(int condicion) {
		return stin(operador.get(5),condicion);
	}
	public String menorigual(int condicion) {
		return stin(operador.get(6),condicion);
	}
	public String entre(String condicion) {
		return st(operador.get(7),condicion);
	}
	
	
	public String st(String a, String condicion) {
		return "where "+ campo +" "+ a +" "+ condicion + "order by 1";
	}
	
	public String stin(String a, int condicion) {
		return "where "+ campo +" "+ a +" "+ condicion + "order by 1";
	}
}