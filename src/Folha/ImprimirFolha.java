package Folha;

public class ImprimirFolha {

    public static void imprimir(ResultadoFolha r) {

        System.out.println("\n===== FOLHA DE PAGAMENTO =====");
        System.out.println("Funcionário: " + r.nome);
        System.out.println("Cargo: " + r.cargo);

        System.out.printf("Salário Base: R$ %.2f\n", r.salarioBase);
        System.out.printf("Horas Extras: R$ %.2f\n", r.horasExtras);

        if (r.decimoTerceiro > 0)
            System.out.printf("13º Salário: R$ %.2f\n", r.decimoTerceiro);

        if (r.ferias > 0)
            System.out.printf("Férias + 1/3: R$ %.2f\n", r.ferias);

        System.out.println("\n--- IMPOSTOS ---");
        System.out.printf("INSS: R$ %.2f\n", r.inss);
        System.out.printf("IRRF: R$ %.2f\n", r.irrf);
        System.out.printf("FGTS (informativo): R$ %.2f\n", r.fgts);

        System.out.println("\n--- TOTAIS ---");
        System.out.printf("TOTAL BRUTO: R$ %.2f\n", r.bruto);
        System.out.printf("TOTAL LÍQUIDO: R$ %.2f\n", r.liquido);
    }
}