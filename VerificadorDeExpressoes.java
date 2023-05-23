
package com.mycompany.pilhasaleatorias;
import java.util.*;

public class VerificadorDeExpressoes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite uma expressão matemática: ");
        String expressao = entrada.nextLine();
        entrada.close();

        if (verificarParenteses(expressao)) {
            System.out.println("A expressão está correta!");
        } else {
            System.out.println("A expressão está incorreta!");
        }
    }

    public static boolean verificarParenteses(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; 
                } else {
                    char topoPilha = pilha.pop();
                    if (!verificarCorrespondencia(topoPilha, caractere)) {
                        return false; 
                    }
                }
            }
        }

        return pilha.isEmpty(); // Verifica se não sobrou algum abre parênteses sem o correspondente fecha parênteses
    }

    public static boolean verificarCorrespondencia(char abre, char fecha) {
        return (abre == '(' && fecha == ')') || (abre == '[' && fecha == ']') || (abre == '{' && fecha == '}');
    }
}
