package Folha;

public class Impostos2025 implements ImpostosPorAno {

    public Imposto getINSS() {
        return new INSS2025();
    }

    public Imposto getIRRF() {
        return new IRRF2025();
    }

    public Imposto getFGTS() {
        return new FGTS();
    }
}