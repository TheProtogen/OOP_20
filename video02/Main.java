package video02;

public class Main {
    public static void main(String[] args) {
        Control controle = new Control(0);
        
        long tempoInicio = System.nanoTime();

        for (int i = 0; i < 5; i++) {
            controle.fillArray(controle.gerarArrayAleatorio());
        }

        long tempoFinal = System.nanoTime();
        long tempoTotal = (tempoFinal - tempoInicio) / 1000000;

        System.out.println("Tempo total de execução: "+tempoTotal+" ms.");

    }
}
