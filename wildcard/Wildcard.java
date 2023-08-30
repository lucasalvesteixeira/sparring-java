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
        
        System.out.printf("Sum Integer List: %.0f\n", sum(integers));
        System.out.printf("Sum Double List: %.2f\n", sum(doubles));
    }


    public static double sum( ArrayList< ? extends Number > list ) {
        double total = 0;
        for ( Number element : list )
        total += element.doubleValue();
        return total;
    }
    
}
