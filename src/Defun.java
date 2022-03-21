
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Defun {

    
    private HashMap<String, Object> variables = new HashMap<>();
    private List<Object> instrucciones;
    private String nombreFuncion = "";
    
    
    public Defun(String nombre, Object var, Object newIns){
        List<String> variables = new ArrayList<>();
        variables.add(var.toString());
        List ins = (List) newIns;
        this.nombreFuncion = nombreFuncion;
        for (String item: variables){
            this.variables.put(item, null);
        }
        this.instrucciones = instrucciones;
    }
    
    public String getNombre(){
        return this.nombreFuncion;
    }
    
    public static String fun(ArrayList<String> function) {
    	String nombre = "";
		return nombre;
    }
    
    
    

}
