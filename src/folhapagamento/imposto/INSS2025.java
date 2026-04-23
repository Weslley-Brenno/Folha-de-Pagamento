package folhapagamento.imposto;

public class INSS2025 implements Imposto {

    @Override
    public double calcular(double salario) {

        double inss = 0;

        if (salario > 0) {
            double faixa1 = Math.min(salario, 1412.00);
            inss += faixa1 * 0.075;
        }

        if (salario > 1412.00) {
            double faixa2 = Math.min(salario, 2666.68) - 1412.00;
            inss += faixa2 * 0.09;
        }

        if (salario > 2666.68) {
            double faixa3 = Math.min(salario, 4000.03) - 2666.68;
            inss += faixa3 * 0.12;
        }

        if (salario > 4000.03) {
            double faixa4 = Math.min(salario, 7786.02) - 4000.03;
            inss += faixa4 * 0.14;
        }

        return inss;
    }
}
