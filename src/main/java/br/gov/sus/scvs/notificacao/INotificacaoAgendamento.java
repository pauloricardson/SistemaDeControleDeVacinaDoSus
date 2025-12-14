package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;

public interface INotificacaoAgendamento {
    void notificarAgendamentoConfirmado(Agendamento agendamento);
    void notificarLembreteAgendamento(Agendamento agendamento);
}
