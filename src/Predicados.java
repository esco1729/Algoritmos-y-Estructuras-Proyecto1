import java.awt.List;
import javax.swing.tree.TreeNode;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Predicados {

    public static java.util.Hashtable<String, TreeNode> vars = new Hashtable<>();

    public String toString(){
        return vars.toString();
    }

    public static boolean varDef(String name){
        return vars.containsKey(name);
    }

    public static void sep(Hashtable <String, TreeNode> tbl){
        Iterator it = tbl.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if ( vars.get(pairs.getKey()) == pairs.getValue() ){
                vars.remove(pairs.getKey());
            }
            it.remove(); 
        }
    }

    public static void unbind(String name){
        vars.remove(name);
    }
    public static TreeNode getVarValue(String name) throws Exception{
        if ( vars.containsKey(name) ){
            return vars.get(name);
        } else {
            throw new Exception("Error");
        }
    }

    public static void mergeVars(Hashtable<String, TreeNode> newVars){
        Iterator counter = newVars.entrySet().iterator();
        while (counter.hasNext()){
            Map.Entry pairs = (Map.Entry)counter.next();
            if(vars.contains(pairs.getKey())){
                vars.remove(pairs.getKey());
            }
            vars.put((String) pairs.getKey(), (TreeNode) pairs.getValue());
            counter.remove();
        }
    }

    public static Hashtable<String, TreeNode> getVarTable(){
        return new Hashtable<String, TreeNode>(vars);
    }

    public static void setVars(Hashtable<String, TreeNode> v){
        vars = new Hashtable<String, TreeNode>(v);
    }

}
