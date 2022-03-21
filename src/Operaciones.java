public class Operaciones {

    public Operaciones() {

    }

    public String operar(String datos){
        String[] data = datos.split(" ");
        double res;
            res = Double.parseDouble(data[1]);
           if(data.length > 2) {
               switch (data[0]) {
                   case "+":
                       for (int i = 2; i < data.length; i++) {
                           if (!data[i].equals(" ")&&!data[i].equals("*")&&!data[i].equals("")) {
                               res += Double.parseDouble(data[i]);
                           }
                       }
                       break;
                   case "-":
                       for (int i = 2; i < data.length; i++) {
                           if (!data[i].equals(" ")&&!data[i].equals("*")&&!data[i].equals("")) {
                               res -= Double.parseDouble(data[i]);
                           }
                       }
                       break;
                   case "*":
                       for (int i = 2; i < data.length; i++) {
                           if (!data[i].equals(" ")&&!data[i].equals("*")&&!data[i].equals("")) {
                               res = res * Double.parseDouble(data[i]);
                           }
                       }

                       break;
                   case "/":
                       for (int i = 2; i < data.length; i++) {
                           if (!data[i].equals(" ")&&!data[i].equals("*")&&!data[i].equals("")) {

                               res = res / Double.parseDouble(data[i]);
                           }
                       }
                       break;
               }
           }
           else{
               return data[1];
           }
        
        return String.valueOf(res);
    }

}