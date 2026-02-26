package Folha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int continuar = 1;

        while (continuar == 1) {

            sc.nextLine();

            System.out.println("\nNome do funcionário:");
            String nome = sc.nextLine();

            System.out.println("\nEscolha o cargo:");
            System.out.println("1 - Auxiliar");
            System.out.println("2 - Encarregado");
            System.out.println("3 - Gerente");
            System.out.println("4 - Personalizado");

            int opcao = sc.nextInt();
            double salarioPersonalizado = 0;

            if (opcao == 4) {
                System.out.println("Informe o salário do cargo personalizado:");
                salarioPersonalizado = sc.nextDouble();
            }

            Cargo cargo = Cargo.criarCargoPadrao(opcao, salarioPersonalizado);

            System.out.println("Mês de contratação:");
            int mesContratacao = sc.nextInt();

            System.out.println("Ano de contratação:");
            int anoContratacao = sc.nextInt();

            System.out.println("Informe o mês da folha:");
            int mesFolha = sc.nextInt();

            System.out.println("Informe o ano da folha:");
            int anoFolha = sc.nextInt();

            // CALCULA TEMPO TRABALHADO
            int mesesTrabalhados =
                    (anoFolha - anoContratacao) * 12 +
                    (mesFolha - mesContratacao);

            boolean temDireitoFerias = mesesTrabalhados >= 12;
            boolean feriasNoMes = false;

            // VERIFICA FÉRIAS
            if (temDireitoFerias) {
                System.out.println("Funcionário está de férias neste mês?");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO");

                feriasNoMes = (sc.nextInt() == 1);
            } else {
                System.out.println("Funcionário ainda NÃO possui 12 meses. Férias indisponíveis.");
            }

            // HORAS EXTRAS
            double horasExtras = 0;

            if (!feriasNoMes) {
                System.out.println("Horas extras do mês:");
                horasExtras = sc.nextDouble();
            } else {
                System.out.println("Funcionário em férias não pode ter horas extras.");
            }

            Funcionario f = new Funcionario(
                    nome,
                    cargo,
                    mesContratacao,
                    anoContratacao,
                    horasExtras
            );

            FolhaPagamento.gerarFolha(f, mesFolha, anoFolha, feriasNoMes);

            System.out.println("\nDeseja calcular outro funcionário?");
            System.out.println("1 - SIM");
            System.out.println("2 - NÃO");

            continuar = sc.nextInt();
        }

        System.out.println("\nSistema encerrado.");
        sc.close();
    }
}