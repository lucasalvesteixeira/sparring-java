package exceptions;

public class UsingExceptions {

    public static void main(String args[]) {
        try {
            throwException();
        } catch (Exception exception) {
            System.err.println("Exception handled in main");
        }
        doesNotThrowException();
    }
    
    // demonstra try...catch...finally
    public static void throwException() throws Exception {
        try { // lanca uma excecao e imediatamente a captura
            System.out.println( "Method throwException" ); 
            throw new Exception(); // gera a excecao
        } catch ( Exception exception ) { // captura a excecao lancada no try 
            System.err.println("Exception handled in method throwException" );
            throw exception; // lanca novamente para mais processamento
            
            // qualquer codigo aqui serua inatingivel
        } finally { // executa independentemente do que ocorre no try...catch
            System.err.println( "Finally executed in throwException" ); 
        }
        
        // qualquer codigo aqui seria inatingivel
    }
    
    
    // demonstra o finally quando nao ocorre excecao
    public static void doesNotThrowException() {
        try { // o bloco try nao lanca excecoes
            System.out.println( "Method doesNotThrowException" );
        } catch ( Exception exception ) { // nao e executado
            System.err.println( exception );
        } finally { // executa independentemente do que ocorre no try...catch
            System.err.println( "Finally executed in doesNotThrowException" );
        }
        
        System.out.println( "End of method doesNotThrowException" );
    }
}
