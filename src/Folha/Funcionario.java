package Folha;

public class Funcionario {

    private String nome;
    private Cargo cargo;
    private int mesContratacao;
    private int anoContratacao;
    private double horasExtras;

    public Funcionario(String nome, Cargo cargo, int mesContratacao, int anoContratacao, double horasExtras) {
        this.nome = nome;
        this.cargo = cargo;
        this.mesContratacao = mesContratacao;
        this.anoContratacao = anoContratacao;
        this.horasExtras = horasExtras;
    }

    public String getNome() { return nome; }
    public Cargo getCargo() { return cargo; }
    public int getMesContratacao() { return mesContratacao; }
    public int getAnoContratacao() { return anoContratacao; }
    public double getHorasExtras() { return horasExtras; }
}