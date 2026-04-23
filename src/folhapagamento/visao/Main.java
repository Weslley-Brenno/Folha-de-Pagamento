package folhapagamento.visao;

import folhapagamento.modelo.Cargo;
import folhapagamento.modelo.CargoPadrao;
import folhapagamento.modelo.Funcionario;
import folhapagamento.modelo.ResultadoFolha;
import folhapagamento.servico.FolhaPagamento;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int continuar = 1;

        while (continuar == 1) {

            System.out.println("\nNome do funcionário:");
            String nome = "";
            while (nome.trim().isEmpty()) {
                nome = sc.nextLine();
            }

            System.out.println("\nEscolha o cargo:");

            CargoPadrao[] cargosEnum = CargoPadrao.values();
            for (int i = 0; i < cargosEnum.length; i++) {
                System.out.println((i + 1) + " - " + cargosEnum[i].getNome());
            }
            int opcaoPersonalizada = cargosEnum.length + 1;
            System.out.println(opcaoPersonalizada + " - Personalizado");

            int opcao = sc.nextInt();
            Cargo cargoSelecionado;

            if (opcao >= 1 && opcao <= cargosEnum.length) {
                CargoPadrao padrao = cargosEnum[opcao - 1];
                cargoSelecionado = new Cargo(padrao.getNome(), padrao.getSalarioBase());
            } else {
                System.out.println("Informe o salário do cargo personalizado:");
                double salarioPersonalizado = sc.nextDouble();
                cargoSelecionado = new Cargo("Personalizado", salarioPersonalizado);
            }

            System.out.println("Mês de contratação:");
            int mesContratacao = sc.nextInt();

            System.out.println("Ano de contratação:");
            int anoContratacao = sc.nextInt();

            System.out.println("Informe o mês da folha (1 a 12):");
            int mesFolha = sc.nextInt();

            System.out.println("Informe o ano da folha:");
            int anoFolha = sc.nextInt();

            Funcionario f = new Funcionario(nome, cargoSelecionado, mesContratacao, anoContratacao, 0);

            boolean feriasNoMes = false;

            if (f.temDireitoAFerias(mesFolha, anoFolha)) {
                System.out.println("Funcionário está de férias neste mês?");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO");

                feriasNoMes = (sc.nextInt() == 1);
            } else {
                System.out.println("Funcionário ainda NÃO possui 12 meses. Férias indisponíveis.");
            }

            // HORAS EXTRAS
            if (!feriasNoMes) {
                System.out.println("Horas extras do mês:");
                f.setHorasExtras(sc.nextDouble());
            } else {
                System.out.println("Funcionário em férias não pode ter horas extras.");
            }

            ResultadoFolha resultado = FolhaPagamento.gerarFolha(f, mesFolha, anoFolha, feriasNoMes);

            ImprimirFolha.imprimir(resultado);

            System.out.println("\nDeseja calcular outro funcionário?");
            System.out.println("1 - SIM");
            System.out.println("2 - NÃO");

            continuar = sc.nextInt();
        }

        System.out.println("\nSistema encerrado.");
        sc.close();
    }
}
