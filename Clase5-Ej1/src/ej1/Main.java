package ej1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayMap<Integer,String> array = new ArrayMap();
		
		
		array.put(4,"Hola");
		array.put(5, "Chau");
		array.put(7, "Jajaja");
		array.put(10, "Probando");

		//array.remove(4);
		
		
		Object[] arrayValues = array.values();
		
		for(int i = 0; i < array.size();i++) {
			System.out.println("Valor: "+arrayValues[i]);
		}
		
		Object[] arrayKeys = array.keys();
		
		for(int i = 0; i < array.size(); i++) {
			System.out.println("Clave: " + arrayKeys[i]);
		}
		
		
		Entry<Integer,String>[] arrayEntries = array.entries();
		
		for(int i = 0; i< array.size(); i++) {
			System.out.println("Clave:"+arrayEntries[i].getKey() + " - Valor:"+arrayEntries[i].getValue());
			
		}
		
	}

}
