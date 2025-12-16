package br.gov.sus.scvs.notificacao;

import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;

public interface INotificacaoMassa {
    public void notificarCampanhaIniciada(CampanhaVacinacao campanha);
}
