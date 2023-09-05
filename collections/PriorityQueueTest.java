package collections;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main( String args[] ) {
        // fila de capacidade 11
        PriorityQueue< Double > queue = new PriorityQueue< Double >();
        
        // insere os elementos na fila
        queue.offer( 3.2 );
        queue.offer( 9.8 );
        queue.offer( 5.4 );
        
        System.out.print( "Polling from queue: " );
        
        // exibe os elementos da fila
        while ( queue.size() > 0 ) {
            System.out.printf( "%.1f ", queue.peek() ); // exibe o elemento do topo
            queue.poll(); // remove o elemento do topo
        }
    } 
}

