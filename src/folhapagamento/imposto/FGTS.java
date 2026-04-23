package folhapagamento.imposto;

public class FGTS implements Imposto {

    @Override
    public double calcular(double salario) {
        return salario * 0.08;
    }
}
