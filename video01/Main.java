package video01;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Control controle = new Control();
        

        long tempoInicial = System.nanoTime();
        int[] arrayFeito = new int[controle.ARRAY_TAMANHO];

        for (int i = 0; i < 5; i++) {
            arrayFeito = controle.gerarArrayAleatorio();
            controle.realizarSomaTotal(arrayFeito);
        }

        long tempoFinal = System.nanoTime();
        long tempoTotal = (tempoFinal - tempoInicial) / 1000000;

        System.out.println("Tempo total: "+tempoTotal+" ms.");
        

    }
}
