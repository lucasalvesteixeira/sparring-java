package raw_type;

import generics.Stack;

public class RawType {

    /*
     * - O compilador utiliza o tipo Object implicitamente, criando uma pilha para qualquer tipo de elemento;
     * - Ha inseguranca quanto ao tipo dos dados armazenados;
     * - Os tipos crus sao importantes para a compatibilidade das versoes antigas do Java.
     *    - Por exemplo, as estruturas do Java Collections Framework armazenavam referencias a classe Object
     *      e agora sao classes genericas;
     *    - Eh possivel atribuir uma estrutura de tipo cru a uma estrutura que especifique o tipo, veja abaixo.
     */ 

    public static void main(String args[]) {
        // Stack importado do pacote generics
        Stack objectStack = new Stack( 5 ); // nenhum tipo especificado (tipo Cru)
        Object objectOne = new Object();
        Object objectTwo = new Object();
        objectOne = 1;
        objectTwo = "2";
        
        objectStack.push(objectOne);
        objectStack.push(objectTwo);

        System.out.println(objectStack.pop().toString());
        System.out.println(objectStack.pop().toString());
    }
    
}
