import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Functions {
	private String nombre;
	private int pos;
	private LinkedHashMap<String, String> params;
	private ArrayList<String> vars;


	public Functions() {
		nombre = "";
		params = new LinkedHashMap<>();
		vars = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedHashMap<String, String> getParams() {
		return params;
	}

	public void setParams(String param2) {
		params.put(param2, "");
	}

	public ArrayList<String> getVars() {
		return vars;
	}

	public void setVars(ArrayList<String> vars) {
		this.vars = vars;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	
}


