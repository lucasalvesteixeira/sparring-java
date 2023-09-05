package collections;

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

/*
 * O exemplo a seguir utiliza HashMap para contar o número 
 * de ocorrências de palavras em uma String.
*/

public class WordTypeCount {
    private Map< String, Integer > map;
    private Scanner scanner;
    
    public WordTypeCount() {
        map = new HashMap< String, Integer >(); // cria o HashMap
        scanner = new Scanner( System.in );
    
        createMap(); // cria o mapa baseado na entrada
        displayMap(); // exibe o conteúdo do mapa
    }

    private void createMap() {
        System.out.println( "Enter a string:" );
        String input = scanner.nextLine();
        
        // cria um StringTokenizer para a entrada
        StringTokenizer tokenizer = new StringTokenizer( input );
        
        // processa o texto da entrada
        while ( tokenizer.hasMoreTokens() ) // enquanto houver entrada
        {
            String word = tokenizer.nextToken().toLowerCase(); // pega a palavra
            // se o mapa contem a palavra
            if ( map.containsKey( word ) ) {
                int count = map.get( word ); // retorna a contagem atual
                map.put( word, count + 1 ); // incrementa a contagem
            } else
                map.put( word, 1 ); // adiciona uma nova palavra com o contador valendo 1
        }
    }

    private void displayMap() {
        Set< String > keys = map.keySet(); // obtem as chaves
        TreeSet< String > sortedKeys = new TreeSet< String >( keys ); // ordena as chaves
        
        System.out.println( "Map contains:\nKey\t\tValue" );
        
        // gera a saída para cada chave no mapa
        for ( String key : sortedKeys )
            System.out.printf( "%-10s%10s\n", key, map.get( key ) );
        
        System.out.printf("\nsize:%d\nisEmpty:%b\n", map.size(), map.isEmpty());
    }

    public static void main( String args[] ) {
        new WordTypeCount();
    }
}