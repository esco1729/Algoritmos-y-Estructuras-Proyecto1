import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Functions {
	private String nombre;
	private int pos;
	private LinkedHashMap<String, Stack<Double>> params;
	private ArrayList<String> vars;


	public Functions(String nombre, LinkedHashMap<String, Stack<Double>> params,  ArrayList<Object> vars)
	{
		nombre = "";
		params = new LinkedHashMap<>();
		vars = new ArrayList<>();
	}


    public void setparametro(String parametro, double par){
        Stack<Double> temporal = params.get(parametro);
        temporal.push(par);
        params.replace(parametro, temporal);
    }

    public Double getparametro(String par){
        Double valor = params.get(par).peek();
        return valor;
    }
    public void delete(String par){
        params.get(par).pop();
    }

    public ArrayList<String> getVars(){
        return vars;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean isParameter(String parametro){
        return params.containsKey(parametro);
    }
}


