package Folha;

public class Cargo {

    private String nome;
    private double salarioBase;

    public Cargo(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public static Cargo criarCargoPadrao(int opcao, double salarioPersonalizado) {
        switch (opcao) {
            case 1: return new Cargo("Auxiliar", 1621);
            case 2: return new Cargo("Encarregado", 2500);
            case 3: return new Cargo("Gerente", 5000);
            case 4: return new Cargo("Personalizado", salarioPersonalizado);
            default: return new Cargo("Auxiliar", 1621);
        }
    }
}