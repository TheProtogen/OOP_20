import java.util.HashMap;

public class POmultiTarefas {
    public static void main(String[] args) {
        // 1
        nomeCheck("ProjectZomboid Inc.");      
        
        // 2
        int salariosPago = 70;                      
        
        // 3
        final int DIAS_FATURAMENTO = 5;             
        
        // 4
        double[] notasQuimica = {7.5,8,7,9};        
        
        // 5
        carroInfo();

        // 6
        double numeroOuro = (1 + Math.sqrt(5)) / 2;
        System.out.println(numeroOuro);

        // 7
        String[] alunosQuimica = {"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10"};

        int paresTenis = 10;
    }

    public static void carroInfo() {
        String placa = "ABC1234";
        String chassi = "1ABCDEFGHIJ234567";
        String modelo = "C6";
        String cor = "Branco";
        int ano = 2006;
        String nomeDono = "Joãozinho";
    }

    public static void nomeCheck (String nome) {
        if (nome.length() > 25) System.out.println("Nome da empresa excedeu o limite de caracteres.");
        else System.out.println("Nome aceito.");
    }
}
