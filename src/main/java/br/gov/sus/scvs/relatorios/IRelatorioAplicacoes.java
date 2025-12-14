package br.gov.sus.scvs.relatorios;

public interface IRelatorioAplicacoes {
    String gerarRelatorioTotalAplicadas();
    String gerarRelatorioEficaciaVacinal();

    String gerarRelatorioCidadãosNaoVacinados();
}
