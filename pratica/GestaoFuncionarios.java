package pratica;

import java.time.LocalDate;
import java.util.Scanner;

public class GestaoFuncionarios {
    private int indice;
    private Funcionario[] funcionario;
    private Scanner scan = new Scanner(System.in);

    public GestaoFuncionarios() {
        this.indice = 50;
        this.funcionario = new Funcionario[indice];
    }



    public void criar() {
        System.out.println("Insira o ID: ");
        Long id = scan.nextLong();

        scan.nextLine();
        System.out.println("Insira o nome: ");
        String nome = scan.nextLine();

        System.out.println("Insira a matricula: ");
        String matricula = scan.nextLine();

        System.out.println("Admissão: ");
        String dataAdmissao = scan.nextLine();
        LocalDate dtAdimissao = LocalDate.parse(dataAdmissao);

        System.out.println("Demissão: ");
        String dataDemissao = scan.nextLine();
        LocalDate dtDemissao = LocalDate.parse(dataDemissao);

        System.out.println("Salario: ");
        float salario = scan.nextFloat();

        scan.nextLine();
        System.out.println("Horario: ");
        String horario = scan.nextLine();

        funcionario[indice] = new Funcionario(id, nome, matricula, dtAdimissao, dtDemissao, salario, horario);

    }

    public void exibir(Funcionario funcionario) {
        funcionario.exibir();
    }

    public boolean isFull() {
        return indice == funcionario.length;
    }

    public boolean isEmpty() {
        return indice == 0;
    }

}
