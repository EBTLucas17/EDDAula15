
package com.mycompany.pilhasaleatorias;
import java.util.*;

public class PilhasAleatorias {
    public static void main(String[] args) {
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        List<Integer> numerosSorteados = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1;
            numerosSorteados.add(numero);

            if (numero >= 1 && numero <= 3)
                pilha1.push(numero);
            else if (numero >= 4 && numero <= 6)
                pilha2.push(numero);
            else if (numero >= 7 && numero <= 9)
                pilha3.push(numero);
        }
        int contadorSorteados = 0;
        while (!pilha1.isEmpty() && !pilha2.isEmpty() && !pilha3.isEmpty() && contadorSorteados < 100) {
            int numeroSorteado = random.nextInt(3) + 1;
            contadorSorteados++;

            if (numeroSorteado == 1) {
                if (pilha2.isEmpty() || pilha3.isEmpty())
                    continue;

                int topoPilha2 = pilha2.pop();
                int topoPilha3 = pilha3.pop();
                pilha1.push(topoPilha2);
                pilha1.push(topoPilha3);

                System.out.println("Empilhando os números " + topoPilha2 + " e " + topoPilha3 + " na pilha 1");
            } else if (numeroSorteado == 2) {
                if (pilha1.isEmpty() || pilha3.isEmpty())
                    continue;

                int topoPilha1 = pilha1.pop();
                int topoPilha3 = pilha3.pop();
                pilha2.push(topoPilha1);
                pilha2.push(topoPilha3);

                System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha3 + " na pilha 2");
            } else if (numeroSorteado == 3) {
                if (pilha1.isEmpty() || pilha2.isEmpty())
                    continue;

                int topoPilha1 = pilha1.pop();
                int topoPilha2 = pilha2.pop();
                pilha3.push(topoPilha1);
                pilha3.push(topoPilha2);

                System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha2 + " na pilha 3");
            }
        }
 System.out.println("\nPilha 1: ");
        printStack(pilha1);
        System.out.println("\nPilha 2: ");
        printStack(pilha2);
        System.out.println("\nPilha 3: ");
        printStack(pilha3);

        if (pilha1.isEmpty())
            System.out.println("\nO programa foi encerrado porque a pilha 1 está vazia.");
        else if (pilha2.isEmpty())
            System.out.println("\nO programa foi encerrado porque a pilha 2 está vazia.");
        else if (pilha3.isEmpty())
            System.out.println("\nO programa foi encerrado porque a pilha 3 está vazia.");
        else if (contadorSorteados >= 100)
            System.out.println("\nO programa foi encerrado porque foram sorteados 100 números.");
    }

    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}
