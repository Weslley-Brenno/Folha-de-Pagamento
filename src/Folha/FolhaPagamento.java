package Folha;

public class FolhaPagamento {

    public static void gerarFolha(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {

        double salarioBase = f.getCargo().getSalarioBase();

        // VALOR DA HORA EXTRA + 50% (CLT)
        double valorHora = salarioBase / 220;
        double horasExtras = f.getHorasExtras() * valorHora * 1.5;

        // 13º SALÁRIO DIVIDIDO SOBRE 2 PARCELAS
        double decimoTerceiro = 0;

        if (mesFolha == 11) {
            decimoTerceiro = salarioBase / 2; // 1ª parcela
        } else if (mesFolha == 12) {
            decimoTerceiro = salarioBase / 2; // 2ª parcela
        }

        // FÉRIAS (somente se tirar férias)
        double ferias = 0;
        double adicionalFerias = 0;

        if (feriasNoMes) {
            ferias = salarioBase;
            adicionalFerias = ferias / 3;
        }

        // CALCULO DO SALARIO BRUTO TOTAL
        double bruto = salarioBase + horasExtras + decimoTerceiro + ferias + adicionalFerias;

        // Impostos do mês
        double inss = CalcularImposto.calcularINSS(bruto);
        double irrf = CalcularImposto.calcularIRRF(bruto);
        double fgts = CalcularImposto.calcularFGTS(bruto);

        double liquido = bruto - inss - irrf;

        System.out.println("\n===== FOLHA DE PAGAMENTO =====");
        System.out.println("Funcionário: " + f.getNome());
        System.out.println("Cargo: " + f.getCargo().getNome());
        System.out.printf("Salário Base: R$ %.2f\n", salarioBase);
        System.out.printf("Horas Extras: R$ %.2f\n", horasExtras);

        if (decimoTerceiro > 0)
            System.out.printf("13º Salário: R$ %.2f\n", decimoTerceiro);

        if (feriasNoMes)
            System.out.printf("Férias + 1/3: R$ %.2f\n", ferias + adicionalFerias);

        System.out.println("\n--- IMPOSTOS ---");
        System.out.printf("INSS: R$ %.2f\n", inss);
        System.out.printf("IRRF: R$ %.2f\n", irrf);
        System.out.printf("FGTS (informativo): R$ %.2f\n", fgts);

        System.out.println("\n--- TOTAIS ---");
        System.out.printf("TOTAL BRUTO: R$ %.2f\n", bruto);
        System.out.printf("TOTAL LÍQUIDO: R$ %.2f\n", liquido);
    }
}
