package br.gov.sus.scvs.relatorios;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

import java.util.List;

public class RelatorioVacinas implements IRelatorioAplicacoes, IRelatorioCobertura, IRelatorioEstoque {
    private List<AplicacaoVacina> aplicacoes;

    public RelatorioVacinas(List<AplicacaoVacina> aplicacoes) {

        this.aplicacoes = aplicacoes;
    }

    @Override
    public String gerarRelatorioTotalAplicadas() {
        return "RELATÓRIO DE APLICAÇÕES\n" +
                "Total de aplicações: " + aplicacoes.size() + "\n" +
                "Período: ";
    }

    @Override
    public String gerarRelatorioCidadaosNaoVacinados() {
        return "";
    }

    @Override
    public String gerarRelatorioCoberturaPorRegiao() {
        return "COBERTURA POR REGIÃO\n" + "Relatório em construção...";
    }

    @Override
    public String gerarRelatorioConsumoPorUnidade() {
        return "CONSUMO POR UNIDADE\n" + "Relatório em construção...";
    }

    @Override
    public String gerarRelatorioLotesVencidos() {
        return "LOTES VENCIDOS\n" + "Relatório em construção...";
    }
}
