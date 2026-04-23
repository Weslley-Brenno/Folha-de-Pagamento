package folhapagamento.modelo;

public enum CargoPadrao {
    AUXILIAR("Auxiliar", 1621.0),
    ENCARREGADO("Encarregado", 2500.0),
    GERENTE("Gerente", 5000.0);

    private final String nome;
    private final double salarioBase;

    CargoPadrao(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
