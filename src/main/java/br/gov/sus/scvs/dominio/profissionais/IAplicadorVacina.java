// Package: br.gov.sus.scvs.interfaces.dominio.profissionais
package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

// Interface para profissionais que aplicam vacinas (ISP)
public interface IAplicadorVacina {
    void aplicarVacina(AplicacaoVacina app);
    boolean podeAplicarVacina();
}