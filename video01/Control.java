package video01;

import java.util.Random;

public class Control {

    public static int counter = 1;
    public int ARRAY_TAMANHO = 999999;

    public void realizarSomaTotal(int[] arrayFeito) {
        int valorTotal = 0;

        for (int i : arrayFeito) {
            valorTotal += arrayFeito[i];
        }

        
        System.out.println("Valor total: "+valorTotal+" | Contador: "+counter);
        counter++;
    }

    public int[] gerarArrayAleatorio() {
        Random rand = new Random();
        int[] array = new int[ARRAY_TAMANHO];

        for (int i : array) {
            array[i] = rand.nextInt(11);
        }

        return array;
    }
}
