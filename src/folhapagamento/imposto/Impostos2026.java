package folhapagamento.imposto;

public class Impostos2026 implements ImpostosPorAno {

    public Imposto getINSS() {
        return new INSS2026();
    }

    public Imposto getIRRF() {
        return new IRRF2026();
    }
   
    public Imposto getFGTS() {
        return new FGTS();
    }
}
