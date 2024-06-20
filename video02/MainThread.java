package video02;

public class MainThread extends Thread {

    public static int NUM_THREADS = 5;

    public static void main(String[] args) {

        long tempoInicio = System.nanoTime();

        Control[] controles = new Control[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            controles[i] = new Control(i);
            controles[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                controles[i].join();
            } catch (InterruptedException e) {
                System.out.println("Não conseguiu dar join(), motivo: " + e.getMessage());
            }
        }

        long tempoFinal = System.nanoTime();
        long tempoTotal = (tempoFinal - tempoInicio) / 1000000;

        System.out.println("Tempo total de execução: "+tempoTotal+" ms.");
    }

}
