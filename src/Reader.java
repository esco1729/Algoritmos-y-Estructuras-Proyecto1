import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;

public class Reader {

	public static String EvalBranch(Node<String> branch, HashMap<String,Node<String>> funciones) {
		if(branch.getChildren().size() == 0) {
			return branch.getData();
		}
		else {
			java.util.List<Node<String>> leaves = branch.getChildren();
			if(("+*-/").contains(branch.getData())) {
				float result = 0;
				result = Float.parseFloat(EvalBranch(leaves.get(0), funciones));
				for(int i = 1; i < leaves.size(); i++) {
					String data = EvalBranch(leaves.get(i), funciones);
					if(branch.getData().equals("+")) {
						result = result + Float.parseFloat(data);
					}
					else if(branch.getData().equals("*")) {
						result = result * Float.parseFloat(data);
					}
					else if(branch.getData().equals("-")) {
						result = result - Float.parseFloat(data);
					}
					else if(branch.getData().equals("/")) {
						result = result / Float.parseFloat(data);
					}
				}
				return Float.toString(result);
			}
			else if(("<>=EQUAL").contains(branch.getData())) {

				String result = "T";
				String compareTo = EvalBranch(leaves.get(0), funciones);
				for(int i = 1; i < leaves.size(); i++) {
					String data = EvalBranch(leaves.get(i), funciones);
					if(branch.getData().equals("=") || branch.getData().equals("EQUAL")) {
						if(Float.isNaN(Float.parseFloat(compareTo))) {
							if(!compareTo.equals(data)) {
								result = "F";
							}
						}
						else {
							if(Float.compare(Float.parseFloat(compareTo), Float.parseFloat(data)) != 0) {
								result = "F";
							}
						}
					}
					else if(branch.getData().equals("<")) {
						if(Float.parseFloat(compareTo) >= Float.parseFloat(data)) {
							result = "F";
						}
					}
					else if(branch.getData().equals(">")) {
						if(Float.parseFloat(compareTo) <= Float.parseFloat(data)) {
							result = "F";
						}
					}
				}
				return result;
			}
			else if(branch.getData().equals("ATOM")) {
				String result = "T";
				for(int i = 0; i < leaves.size(); i++) {
					if(leaves.get(i).getChildren().size() > 0) {
						result = "F";
					}
				}
				return result;
			}
			else if(branch.getData().equals("LIST")) {
				String list = "(";
				for(int i = 0; i < leaves.size(); i++) {
					list += EvalBranch(leaves.get(i), funciones) + " ";
				}
				return list.substring(0, list.length()-1)+")";
			}
			else if(branch.getData().equals("IF")) {
				java.util.List<Node<String>> children = branch.getChildren();
				if(EvalBranch(children.get(0),funciones).equals("T")) {
					return EvalBranch(children.get(1), funciones);
				}
				else {
					return EvalBranch(children.get(2), funciones);
				}
			}
			else if(branch.getData().equals("COND")) {
				java.util.List<Node<String>> children = branch.getChildren();
				for(int i = 0; i < children.size(); i = i+2) {
					if(EvalBranch(children.get(i),funciones).equals("T")) {
						return EvalBranch(children.get(i+1), funciones);
					}
				}
				return "Se ha definido la condición";
			}
			else if(branch.getData().equals("DEFUN")) {
				return "Función definida: "+branch.getChildren().get(0).getData();
			}
			else if(funciones.containsKey(branch.getData())) {
				java.util.List<String> parametros = new ArrayList<String>();
				java.util.List<Node<String>> children = branch.getChildren();
				for(int i = 0; i < children.size(); i++) {
					parametros.add(EvalBranch(children.get(i),funciones));
				}
				Node<String> funcion = funciones.get(branch.getData());
				Node<String> instrucciones = funcion.getChildren().get(2).copy();
				String[] nombreParametros = funcion.getChildren().get(1).getData().split(" ");
				for(int i = 0; i < nombreParametros.length; i++) {
					instrucciones.replace(nombreParametros[i], parametros.get(i));
				}
				return EvalBranch(instrucciones, funciones);
			}
			else {
				return "NIL";
			}
		}
	}
}