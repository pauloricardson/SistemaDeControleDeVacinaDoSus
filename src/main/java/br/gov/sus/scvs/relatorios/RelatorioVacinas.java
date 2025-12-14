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
        return "📊 RELATÓRIO DE APLICAÇÕES\n" +
                "Total de aplicações: " + aplicacoes.size() + "\n" +
                "Período: " + getPeriodoRelatorio();
    }

    @Override
    public String gerarRelatorioEficaciaVacinal() {
        long total = aplicacoes.size();
        long completas = aplicacoes.stream()
                .filter(a -> a.getDose() >= a.getVacina().getDosesNecessarias())
                .count();

        double percentual = total > 0 ? (completas * 100.0 / total) : 0;

        return "📈 EFICÁCIA VACINAL\n" +
                "Aplicações totais: " + total + "\n" +
                "Ciclos completos: " + completas + "\n" +
                "Percentual completo: " + String.format("%.2f%%", percentual);
    }

    @Override
    public String gerarRelatorioCidadãosNaoVacinados() {
        // Implementação simplificada
        return "👥 CIDADÃOS NÃO VACINADOS\n" +
                "Relatório em construção...";
    }

    @Override
    public String gerarRelatorioCidadaosNaoVacinados() {
        return "";
    }

    @Override
    public String gerarRelatorioCoberturaPorRegiao() {
        return "🗺️ COBERTURA POR REGIÃO\n" +
                "Relatório em construção...";
    }

    @Override
    public String gerarRelatorioConsumoPorUnidade() {
        return "🏥 CONSUMO POR UNIDADE\n" +
                "Relatório em construção...";
    }

    @Override
    public String gerarRelatorioLotesVencidos() {
        return "⚠️ LOTES VENCIDOS\n" +
                "Relatório em construção...";
    }

    private String getPeriodoRelatorio() {
        if (aplicacoes.isEmpty()) return "Sem dados";

        var datas = aplicacoes.stream()
                .map(AplicacaoVacina::getDataHoraAplicacao)
                .sorted()
                .toList();

        return datas.get(0).toLocalDate() + " a " +
                datas.get(datas.size() - 1).toLocalDate();
    }
}
