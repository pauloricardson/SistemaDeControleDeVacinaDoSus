package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;
import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;
import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;

import java.util.List;

public class NotificacaoVacina implements INotificacaoEstoque, INotificacaoAgendamento, INotificacaoMassa {

    @Override
    public void notificarVacinaProximaValidade(LoteVacina lote) {
        System.out.println("ALERTA: Vacina lote " + lote.getNumeroLote() +
                " (" + lote.getVacina().getNome() + ") próxima da validade.");
    }

    @Override
    public void notificarEstoqueBaixo(Vacina vacina) {
        System.out.println("ALERTA: Estoque baixo para " + vacina.getNome() +
                " - Reabastecimento necessário.");
    }

    @Override
    public void notificarAgendamentoConfirmado(Agendamento agendamento) {
        System.out.println("Agendamento confirmado: " + agendamento.getCidadao().getNome() +
                " - " + agendamento.getDataAgendada() + " " + agendamento.getHorario());
    }

    @Override
    public void notificarLembreteAgendamento(Agendamento agendamento) {
        System.out.println("Lembrete: Agendamento amanhã para " + agendamento.getCidadao().getNome());
    }

    @Override
    public void notificarAgendamentosEmMassa(List<Agendamento> agendamentos) {
        System.out.println("Notificação em massa: " + agendamentos.size() +
                " agendamentos confirmados para a campanha.");
    }

    @Override
    public void notificarCampanhaIniciada(CampanhaVacinacao campanha) {
        System.out.println("Campanha iniciada: " + campanha.getNome() +
                " - Público: " + campanha.getPublicoAlvo());
    }
}
