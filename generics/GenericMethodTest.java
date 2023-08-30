package generics;

public class GenericMethodTest { //metodo generico

    public static <E> void printArray(E[] inputArray) {
        // exibe os elementos do vetor
        for(E element: inputArray) 
            System.out.printf("%s ", element);
            
        System.out.println();
    }

    public static void main(String args[]) { 
        // cria vetores dos tipos Integer, Double e Character
        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray ={ 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray( integerArray ); // envia um vetor de Integer
        
        System.out.println("\nArray doubleArray contains:");
        printArray( doubleArray ); // envia um vetor de Double
        
        System.out.println("\nArray characterArray contains:");
        printArray( characterArray ); // envia um vetor de Character
    }
}