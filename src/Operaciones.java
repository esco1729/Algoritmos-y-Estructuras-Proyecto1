import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operaciones{
	public Node<String> ParseList(List<String> lista) {
		Node<String> root = new Node<String>("");
		for(int i = 0; i < lista.size(); i++) {   
        }
		return root;
	}
	
	
	public static List<String> makeList(String exp){
		List<String> lista = new ArrayList<String>();
		exp= exp.replace("(", " ( ");
		exp = exp.replace(")", " ) ");
		exp = exp.replace("+", " + ");
		exp = exp.replace("*", " * ");
		exp = exp.replace("/", " / ");
		exp= exp.replace("-", " - ");
		exp = exp.replace(">", " > ");
		exp = exp.replace("<", " < ");
		exp = exp.replace("=", " = ");
		exp = exp.replace("\t", " ");
		String[] texto = exp.split(" ");
        for (int i = 0; i < texto.length; i++) {
        	if(!texto[i].isEmpty()) {
        		lista.add(texto[i]);
        	}
        }
        return lista;
	}
	
	public static List<String> getExp(List<String> list) {
		int parentesisCount = 1;
		int toIndex = list.size();
		for(int i = 1; (parentesisCount != 0) && (i < list.size()); i++) {
			if(list.get(i).equals("(")) {
				parentesisCount++;
			}
			else if(list.get(i).equals(")")) {
				parentesisCount--;
			}
			if(parentesisCount == 0) {
				toIndex = i;
			}
		}
		return list.subList(0, toIndex+1);
	}
	

	public static Node<String> makeFun(List<String> list, HashMap<String,Node<String>> funciones){

		Node<String> nombre = new Node<String>(list.get(2));
		List<String> param = getExp(list.subList(3, list.size()));
		String l = "";
		for(int i = 1; i < param.size()-1; i++) {
			l += param.get(i) + " ";
		}
		Node<String> parametros = new Node<String>(l.substring(0, l.length()));
		Node<String> funcion = new Node<String>("DEFUN");
		Node<String> instrucciones = MakeBranch(list.subList(3+param.size(), list.size()-1), funciones);
		funcion.addChild(nombre);
		funcion.addChild(parametros);
		funcion.addChild(instrucciones);
		return funcion;
	}
	
	public static List<List<String>> getInst(List<String> texto){
		List<List<String>> instrucciones = new ArrayList<List<String>>();
		for(int i = 0; i < texto.size(); i++) {
			List<String> linea = getExp(texto.subList(i, texto.size()));
			i += linea.size() - 1;
			instrucciones.add(linea);
		}
		return instrucciones;
	}
	
	public static Node<String> MakeBranch(List<String> list, HashMap<String,Node<String>> funs) {
		if(list.get(1).equals("DEFUN")) {
			return makeFun(list, funs);
		}
		else {
			int inicio=0;
			int fin=0;
			int count=0;
			if(funs.containsKey(list.get(1)) || list.get(1).equals("COND")) { // Si es una funcion definida por el usuario
				inicio = 3;
				fin = list.size() - 2;
			}
			else { 
				inicio = 2;
				fin = list.size() - 1;
			}
			Node<String> root = new Node<String>(list.get(1));
			for(int i = inicio; i < fin; i++) {
				Node<String> leaf = null;
				if(list.get(i).equals("(")) {
					
					List<String> subLista = getExp(list.subList(i, list.size()));
					
					
					i += subLista.size() - 1;
					
					
					leaf = MakeBranch(subLista, funs);
				}
				else {
					leaf = new Node<String>(list.get(i));
				}
				root.addChild(leaf);
				count++;
				if(list.get(1).equals("COND") & count % 2 == 0) {
					i = i + 2;
				}
			}
			return root;
		}
	}
}