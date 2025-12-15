package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;

public interface INotificacaoEstoque {
    public void notificarVacinaProximaValidade(LoteVacina lote);
    public void notificarEstoqueBaixo(Vacina vacina);
}
