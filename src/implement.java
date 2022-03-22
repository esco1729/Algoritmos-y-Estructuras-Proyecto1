public class  implement implements interfaz {

	@Override
	public double calculate(String operation, double num1, double num2) {
		double calc = 0.25;
		String suma = "+";
		String resta = "-";
		String multi = "*";
		String div = "/";
		
		if (operation.equals(suma)) {
			calc = num1 + num2;
		}
		if (operation.equals(resta)) {
			calc = num1 - num2;
		}
		if(operation.equals(multi)) {
			calc = num1*num2;
		}
		if(operation.equals(div)) {
			calc = num1/num2;
		}
		return calc;
	}

}
