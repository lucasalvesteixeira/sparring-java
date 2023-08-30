package generics;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class StackTest {
    private double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
    private int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    private Stack< Double > doubleStack; // pilha de Double
    private Stack< Integer > integerStack; // pilha de Integer

    public void testStacks() {
        doubleStack = new Stack< Double >( 5 );
        integerStack = new Stack< Integer >( 10 );
        
        // nao aceita array de tipo primitivo
        testPush( "doubleStack", doubleStack, doubleElements);
        testPop( "doubleStack", doubleStack );
        testPush( "integerStack", integerStack, integerElements );
        testPop( "integerStack", integerStack );
    }

    // metodo generico que testa o metodo push da classe generica
    public < T > void testPush( String name, Stack< T > stack, T[] elements ) {
        try {
            System.out.printf( "\nPushing elements onto %s\n", name );
            for ( T element : elements ) {
                System.out.printf( "%s ", element );
                stack.push( element );
            }
        } catch ( CustomStackFullException fullStackException ) {
            System.out.println();
            fullStackException.printStackTrace();
        }
    }

    // metodo generico que testa o metodo pop da classe generica
    public < T > void testPop( String name, Stack< T > stack ) {
        try {
            System.out.printf( "\nPopping elements from %s\n", name );
            T popValue;
            while ( true ) {
                popValue = stack.pop();
                System.out.printf( "%s ", popValue );
            }
        } catch( EmptyStackException emptyStackException ) {
            System.out.println();
            emptyStackException.printStackTrace();
        }
    }

    public static void main( String args[] ) {
        StackTest application = new StackTest();
        application.testStacks();
    }

}