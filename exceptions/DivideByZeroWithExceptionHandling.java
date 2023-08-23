package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {
    
    //demonstra o disparo de uma exceção quando ocorre uma divisão por zero
    public static int quotient( int numerator, int denominator ) 
        throws ArithmeticException {
            return numerator / denominator; // possivel divisao por zero
    }

    public static void main( String args[] ) {
        Scanner scanner = new Scanner( System.in );
        boolean continueLoop = true; // determina se e necessario mais entrada

        do {
            try { // le dois numeros e calcula a divisao
                System.out.print( "Please enter an integer numerator: " );
                int numerator = scanner.nextInt();
                System.out.print( "Please enter an integer denominator: " );
                int denominator = scanner.nextInt();
                int result = quotient( numerator, denominator );
                System.out.printf( "\nResult: %d / %d = %d\n", numerator, denominator, result);
                continueLoop = false; // entrada ok, fim do loop
            } catch ( InputMismatchException inputMismatchException ) {
                System.err.printf( "\nException: %s\n", inputMismatchException );
                scanner.nextLine(); // descarta a entrada para o usuario tentar de novo
                System.out.println("You must enter integers. Please try again.\n" );
            } catch ( ArithmeticException arithmeticException ) {
                System.err.printf( "\nException: %s\n", arithmeticException );
                System.out.println("Zero is an invalid denominator. Please try again.\n" );
            }
        } while ( continueLoop );
    }
}
