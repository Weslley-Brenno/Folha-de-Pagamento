package folhapagamento.imposto;

public class ImpostoNovo {

    public static ImpostosPorAno getImpostos(int ano) {
        if (ano <= 2025) {
            return new Impostos2025();
        } else {
            return new Impostos2026();
        }
    }
}
