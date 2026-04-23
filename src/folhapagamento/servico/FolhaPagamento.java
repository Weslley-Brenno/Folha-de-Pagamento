package folhapagamento.servico;

import folhapagamento.modelo.Funcionario;
import folhapagamento.modelo.ResultadoFolha;
import folhapagamento.imposto.ImpostoNovo;
import folhapagamento.imposto.ImpostosPorAno;

public class FolhaPagamento {

    public static ResultadoFolha gerarFolha(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {

        ResultadoFolha r = new ResultadoFolha();

        double salarioBase = f.getCargo().getSalarioBase();

        // VALOR DA HORA EXTRA + 50% (CLT)
        double valorHora = salarioBase / 220;
        double horasExtras = f.getHorasExtras() * valorHora * 1.5;

        // 13º SALÁRIO (duas parcelas)
        double decimoTerceiro = 0;

        if (mesFolha == 11) {
            decimoTerceiro = salarioBase / 2;
        } else if (mesFolha == 12) {
            decimoTerceiro = salarioBase / 2;
        }

        // FÉRIAS
        double ferias = 0;
        double adicionalFerias = 0;

        if (feriasNoMes) {
            ferias = salarioBase;
            adicionalFerias = ferias / 3;
        }

        // SALÁRIO BRUTO
        double bruto = salarioBase + horasExtras + decimoTerceiro + ferias + adicionalFerias;

        // Sistema de imposto
        ImpostosPorAno impostos = ImpostoNovo.getImpostos(anoFolha);

        double inss = impostos.getINSS().calcular(bruto);

        double baseIRRF = bruto - inss;
        if (baseIRRF < 0) {
            baseIRRF = 0;
        }
        double irrf = impostos.getIRRF().calcular(baseIRRF);
        double fgts = impostos.getFGTS().calcular(bruto);

        // SALÁRIO LÍQUIDO
        double liquido = bruto - inss - irrf;

        // PREENCHIMENTO DO RESULTADO
        r.nome = f.getNome();
        r.cargo = f.getCargo().getNome();
        r.salarioBase = salarioBase;
        r.horasExtras = horasExtras;
        r.decimoTerceiro = decimoTerceiro;
        r.ferias = ferias + adicionalFerias;
        r.inss = inss;
        r.irrf = irrf;
        r.fgts = fgts;
        r.bruto = bruto;
        r.liquido = liquido;

        return r;
    }
}
