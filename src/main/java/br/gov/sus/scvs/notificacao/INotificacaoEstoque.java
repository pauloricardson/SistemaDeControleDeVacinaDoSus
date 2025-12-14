package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;

public interface INotificacaoEstoque {
    void notificarVacinaProximaValidade(LoteVacina lote);
    void notificarEstoqueBaixo(Vacina vacina);
}
