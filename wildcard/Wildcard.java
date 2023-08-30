package wildcard;

import java.util.ArrayList;

public class Wildcard {

    public static void main(String args[]) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(3.1);
        doubles.add(4.1);
        
        System.out.printf("Sum Integer List: %.0f\n", sumWithWildcard(integers));
        System.out.printf("Sum Double List: %.2f\n\n", sumWithWildcard(doubles));

        System.out.printf("Sum Integer List: %.0f\n", sumWithoutWildcard(integers));
        System.out.printf("Sum Double List: %.2f\n", sumWithoutWildcard(doubles));
    }

    /*
     *  Uma desvantagem desta sintaxe eh que o simbolo nao pode ser utilizado
     *  como o nome de um tipo ao longo do metodo.
     *  - Por exemplo, no for aprimorado nao podemos substituir Number por ?
     */
    public static double sumWithWildcard( ArrayList< ? extends Number > list ) {
        double total = 0;
        for ( Number element : list )
        total += element.doubleValue();
        return total;
    }
    
    // Uma alternativa eh declarar o metodo como a seguir 
    public static <T extends Number> double sumWithoutWildcard( ArrayList< T > list ) {
        double total = 0;
        for ( Number element : list )
        total += element.doubleValue();
        return total;
    }
}
