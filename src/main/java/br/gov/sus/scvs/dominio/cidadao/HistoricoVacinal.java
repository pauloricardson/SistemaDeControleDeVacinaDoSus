package br.gov.sus.scvs.dominio.cidadao;


import br.gov.sus.scvs.servicos.AplicacaoVacina;

import java.util.ArrayList;
import java.util.List;

public class HistoricoVacinal {
    private List<AplicacaoVacina> aplicacoes;

    public HistoricoVacinal() {
        this.aplicacoes = new ArrayList<>();
    }

    public void adicionarAplicacao(AplicacaoVacina app) {
        if (app == null) throw new IllegalArgumentException("Aplicação não pode ser nula");
        aplicacoes.add(app);
    }

    public List<AplicacaoVacina> getAplicacoes() {
        return new ArrayList<>(aplicacoes);
    }

    public int getTotalAplicacoes() {
        return aplicacoes.size();
    }

    public boolean possuiVacinaCompleta(String nomeVacina, int dosesNecessarias) {
        long count = aplicacoes.stream()
                .filter(a -> a.getVacina().getNome().equals(nomeVacina))
                .count();
        return count >= dosesNecessarias;
    }
}