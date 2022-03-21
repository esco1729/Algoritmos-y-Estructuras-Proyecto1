public class Predicados {

	
	public boolean equal(Object a, Object b) {
		return a.equals(b);
		
	}
	
	public boolean biggerThan(Object a, Object b) {
		return (Double.parseDouble(a.toString()) > Double.parseDouble(b.toString()));
			
	}
	
	
	public boolean smallerThan(Object a, Object b) {
		return (Double.parseDouble(a.toString()) < Double.parseDouble(b.toString()));
			
	}

	public boolean Atom(Object value){
		
		try { 
			if((Integer)Integer.parseInt(value.toString()) instanceof Integer){
				return true;
			}
		} 
		catch (NumberFormatException e) { 
			try {
				if((Float)Float.parseFloat(value.toString()) instanceof Float){
					return true;
				}
			} 
			catch (NumberFormatException e2) { 
				try {
					if((Double)Double.parseDouble(value.toString()) instanceof Double){
						return true;
					}
				} 
				catch (Exception e3) { 
					try{
						String valor = value.toString();
						if(valor instanceof String){
							
							return true;
						}
					}
					catch(Exception e4){
						return false;
						}
					}
			}
		}
		return false;
	}

}

