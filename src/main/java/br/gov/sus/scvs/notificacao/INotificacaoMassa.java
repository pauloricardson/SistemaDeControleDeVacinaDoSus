package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;
import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;

import java.util.List;

public interface INotificacaoMassa {
    public void notificarAgendamentosEmMassa(List<Agendamento> agendamentos);
    public void notificarCampanhaIniciada(CampanhaVacinacao campanha);
}
