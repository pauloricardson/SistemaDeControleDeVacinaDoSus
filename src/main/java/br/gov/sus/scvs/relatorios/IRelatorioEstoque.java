package br.gov.sus.scvs.relatorios;

public interface IRelatorioEstoque {
    String gerarRelatorioConsumoPorUnidade();
    String gerarRelatorioLotesVencidos();
}
