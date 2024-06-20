package video02;

import java.util.Random;

public class Control extends Thread {
    
    //public static int counter = 0;
    public int ARRAY_SIZE = 999999;
    public Random rand = new Random();
    public int threadNumero;

    public Control(int threadNumero) {
        this.threadNumero = threadNumero;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            fillArray(gerarArrayAleatorio());
        }
        
    }

    public int[] gerarArrayAleatorio() {
        int[] array = new int[ARRAY_SIZE];

        for (int i : array) {
            array[i] = rand.nextInt(11);
        }

        return array;
    }

    public void fillArray(int[] array) {
        int valorTotal = 0;

        for (int i : array) {
            valorTotal += array[i];
        }

        System.out.println("Valor total: "+valorTotal+" | Número da thread: "+this.threadNumero);

    }

}
