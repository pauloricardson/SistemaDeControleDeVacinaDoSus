package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;
import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;
import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;

import java.time.LocalDate;

public class NotificacaoVacina implements INotificacaoEstoque, INotificacaoAgendamento, INotificacaoMassa {

    @Override
    public void notificarVacinaProximaValidade(LoteVacina lote) {

        LocalDate hoje = LocalDate.now();

        if (lote.getDataValidade().isBefore(hoje.plusDays(7)) || lote.getDataValidade().isEqual(hoje.plusDays(7))) {
            System.out.println("ALERTA: Vacina lote " + lote.getNumeroLote() +
                    " (" + lote.getVacina().getNome() + ") próxima da validade. Data de validade: " + lote.getDataValidade());
            return;
        }
        System.out.println("O lote não está perto da validade");
//        System.out.println("ALERTA: Vacina lote " + lote.getNumeroLote() +
//                " (" + lote.getVacina().getNome() + ") próxima da validade.");
    }

    @Override
    public void notificarEstoqueBaixo(Vacina vacina) {
        System.out.println("ALERTA: Estoque baixo para " + vacina.getNome() +
                " - Reabastecimento necessário.");
    }

    @Override
    public void notificarAgendamento(Agendamento agendamento) {
        System.out.println("Agendamento confirmado: " + agendamento.getCidadao().getNome() +
                " - " + agendamento.getDataAgendada() + " " + agendamento.getHorario() + " - Situação: " + agendamento.getStatus());
    }

    @Override
    public void notificarCampanhaIniciada(CampanhaVacinacao campanha) {
        System.out.println("Campanha iniciada: " + campanha.getNome() +
                " - Público: " + campanha.getPublicoAlvo());
    }
}
