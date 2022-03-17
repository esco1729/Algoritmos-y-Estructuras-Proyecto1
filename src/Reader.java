import java.util.Stack;

public class Reader {
	
    public static ArrayList<Node> parseProgram(ArrayList<String> separatedProgram) {
        ArrayList<Node> parsedProgram = new ArrayList<>();
        while(!separatedProgram.isEmpty()) {
            Node node;
            String t = separatedProgram.remove(0);
            if (t.equals("(")) {
                node = new Node(parseProgram(separatedProgram));
                parsedProgram.add(node);
            } else if (t.equals(")")) {
                return parsedProgram;
            } else if (isNumber(t)) {
                parsedProgram.add(new Node(Float.parseFloat(t)));
            } else {
                parsedProgram.add(new Node(t));
            }
        }
        return parsedProgram;
    }
    private static ArrayList<String> separar(String codigo) {

        String[] arr = codigo.split(" ");
        ArrayList<String> l = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].startsWith("\"")){ //Determina si el elemento se indica como una cadena de strings
                int j = i;
                String str =  "";
                while(!arr[j].endsWith("\"")){
                    if (str == "") {
                        str += arr[j];
                    } else {
                        str += " "+arr[j];
                    }
                    j++;
                }
                str += " "+arr[j];
                l.add(str);
                i = j;
            }else{
                l.add(arr[i]);
            }
        }  

        return l;
    }
    
    public static ArrayList<Nodo> parseProgram(ArrayList<String> separatedProgram) {
        ArrayList<Nodo> parsedProgram = new ArrayList<>();
        while(!separatedProgram.isEmpty()) {
            Nodo node;
            String t = separatedProgram.remove(0);
            if (t.equals("(")) {
                node = new Nodo(parseProgram(separatedProgram));
                parsedProgram.add(node);
            } else if (t.equals(")")) {
                return parsedProgram;
            } else if (isNumber(t)) {
                parsedProgram.add(new Nodo(Float.parseFloat(t)));
            } else {
                parsedProgram.add(new Nodo(t));
            }
        }
        return parsedProgram;
    }
}
