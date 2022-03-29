import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Vista {
    public static void main(String[] args){
    		String programa = "";
    		HashMap<String,Node<String>> funciones = new HashMap<String,Node<String>>();
    		try {
    			System.out.println("Ingrese la ubicación del archivo por evaluar: \n");
    			Scanner input = new Scanner(System.in);
    			File file = new File(input.nextLine());
    	        Scanner scanner = new Scanner(file);
    	        input.close();
    	        System.out.println("Expresiones por evaluar");
    	        int n = 0;
    	        while (scanner.hasNextLine()){
    	            String line = scanner.nextLine();
    	            if(line.indexOf(";") > 0) {
    	            	programa += line.substring(0, line.indexOf(";"));
    	            }
    	            else {
    	            	programa += line;
    	            }
    	            System.out.println("[" + Integer.toString(++n) + "]: " + line);
    	        }
    	        scanner.close();	
    	        
    	        n = 0;
    	        try {
    	        	System.out.println("\nResultado:");
    				java.util.List<String> lista =  Operaciones.makeList(programa);
    				java.util.List<java.util.List<String>> instrucciones = Operaciones.getInst(lista);
    				for(int i = 0; i < instrucciones.size(); i++) {
    					Node<String> branch = Operaciones.MakeBranch(instrucciones.get(i), funciones);

    					if(branch.getData().equals("DEFUN")) {
    						String nombre = branch.getChildren().get(0).getData();
    						funciones.put(nombre, branch);
    					}
    					String result = Reader.EvalBranch(branch,funciones);
    			        System.out.println("[" + Integer.toString(++n) + "]: " + result);
    				}
            	}
            	catch(Exception ie) {
            		System.out.println("Error");
            	}
    		}
    		catch(Exception ie) {
    			System.out.println("Inténtelo nuevamente");
    		}
    		
    	}
  }