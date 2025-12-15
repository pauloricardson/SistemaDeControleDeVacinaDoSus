package br.gov.sus.scvs.relatorios;

public interface IRelatorioAplicacoes {
    public String gerarRelatorioTotalAplicadas();
    public String gerarRelatorioEficaciaVacinal();
    public String gerarRelatorioCidadãosNaoVacinados();
}
