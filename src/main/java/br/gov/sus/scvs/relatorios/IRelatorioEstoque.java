package br.gov.sus.scvs.relatorios;

public interface IRelatorioEstoque {
    public String gerarRelatorioConsumoPorUnidade();
    public String gerarRelatorioLotesVencidos();
}
