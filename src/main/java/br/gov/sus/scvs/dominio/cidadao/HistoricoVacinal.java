package br.gov.sus.scvs.dominio.cidadao;


import br.gov.sus.scvs.servicos.AplicacaoVacina;
import java.util.ArrayList;
import java.util.List;

public class HistoricoVacinal {

    private ArrayList<AplicacaoVacina> aplicacoes;

    public HistoricoVacinal() {

        this.aplicacoes = new ArrayList<>();
    }

    public List<AplicacaoVacina> getAplicacoes() {
        return this.aplicacoes;
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

    public void adicionarAplicacao(AplicacaoVacina app) {
        if (app == null)
            throw new IllegalArgumentException("Aplicação não pode ser nula");
        aplicacoes.add(app);
    }


}