package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public interface IAplicadorVacina {
    void aplicarVacina(AplicacaoVacina app);
    boolean podeAplicarVacina();
}