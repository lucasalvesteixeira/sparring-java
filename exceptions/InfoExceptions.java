package exceptions;

public class InfoExceptions {
    public static void main(String args[]) {
        try {
            method1();
        } catch(Exception exception) { // captura a excecao lancada em method1
            System.err.printf("%s\n\n", exception.getMessage());
            exception.printStackTrace(); // imprime o stack trace

            // obtem a informacao do stack trace
            StackTraceElement[] traceElements = exception.getStackTrace();

            System.out.println("\nStack trace from getStackTrace:");
            System.out.println("Class\t\tFile\t\t\tLine\tMethod");
            
            // itera pelos elementos para obter a descricao da excecao
            for ( StackTraceElement element : traceElements ) {
                System.out.printf( "%s\t", element.getClassName() );
                System.out.printf( "%s\t", element.getFileName() );
                System.out.printf( "%s\t", element.getLineNumber() );
                System.out.printf( "%s\n", element.getMethodName() );
            }
        }
    }

    // lanca a excecao de volta para o main
    public static void method1() throws Exception {
        method2();
    }
    // lanca a excecao de volta para o method1
    public static void method2() throws Exception {
        method3();
    }
    // lanca a excecao de volta para o method2
    public static void method3() throws Exception {
        throw new Exception( "Exception thrown in method3" );
    }
}
