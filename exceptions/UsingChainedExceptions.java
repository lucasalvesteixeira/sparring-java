package exceptions;

public class UsingChainedExceptions {
    public static void main( String args[] ) {
        try { 
            method1(); 
        } catch ( Exception exception ) { // excecao lancada por method1
            exception.printStackTrace(); 
        }
    }
    
    // lanca uma excecao de volta ao main
    public static void method1() throws Exception {
        try {
            method2();
        } catch ( Exception exception ) { // excecao lancada por method2
            throw new Exception( "Exception thrown in method1", exception );
        }
    }

    // lanca uma excecao de volta ao method1
    public static void method2() throws Exception {
        try {
            method3();
        } catch ( Exception exception ) { // excecao lancada por method3
            throw new Exception( "Exception thrown in method2", exception );
        }
    }
    
    // lanca uma excecao de volta ao method2
    public static void method3() throws Exception {
        throw new Exception( "Exception thrown in method3" );
    }
}