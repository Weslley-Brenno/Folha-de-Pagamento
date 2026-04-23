package folhapagamento.modelo;

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

    public int calcularMesesTrabalhados(int mesBase, int anoBase) {
        return (anoBase - this.anoContratacao) * 12 + (mesBase - this.mesContratacao);
    }

    public boolean temDireitoAFerias(int mesBase, int anoBase) {
        return calcularMesesTrabalhados(mesBase, anoBase) >= 12;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getMesContratacao() {
        return mesContratacao;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }
}
