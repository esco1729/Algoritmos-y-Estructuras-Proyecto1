import java.util.Arrays;
import java.util.List;

public class SetQ {

    private static String quote = "";

    /**
     * instrucciones para analizar en el quote
     * @param instrucciones
     * @return string 
     */
    public static String quote(List instrucciones){

        quote = Arrays.toString(instrucciones.toArray()).replace("[", "(").replace("]", ")").replaceAll(",","");
        return quote;
    }

    /**
     * definicion de la función set q
     * @param instrucciones
     */
    public static void setq(List instrucciones){

        for(int x = 0; x < (instrucciones.size()-1); x++){
            if(instrucciones.get(x+2) instanceof List){
              List sub = (List) instrucciones.get(x+2);
              List sub2 = (List) sub.get(1);
              System.out.println(instrucciones.get(x+1) + ": " + quote(sub2));
            }else{
              System.out.println(instrucciones.get(x+1) + ": "+instrucciones.get(x+2));
            }
            x++;
        }
    }    
}
