package br.gov.sus.scvs.dominio.cidadao;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public interface IHistoricoVacinal {
    void adicionarAplicacao(AplicacaoVacina aplicacao);
    int obterTotalAplicacoes();

    int getTotalAplicacoes();
}
