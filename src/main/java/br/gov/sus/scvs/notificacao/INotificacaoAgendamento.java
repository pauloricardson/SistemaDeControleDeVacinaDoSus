package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;

public interface INotificacaoAgendamento {
    public void notificarAgendamentoConfirmado(Agendamento agendamento);
    public void notificarLembreteAgendamento(Agendamento agendamento);
}
