package br.gov.sus.scvs.dominio.vacina;

import java.util.ArrayList;
import java.util.List;

public class EstoqueVacinas implements IEstoqueManager {

    private List<LoteVacina> lotes;

    public EstoqueVacinas() {
        this.lotes = new ArrayList<>();
    }

    @Override
    public void adicionarLote(LoteVacina lote) {
        if (lote == null)
            throw new IllegalArgumentException("Lote não pode ser nulo");
        if (lote.isExpirado())
            throw new IllegalArgumentException("Lote expirado não pode ser adicionado");

        lotes.add(lote);
    }

    @Override
    public void removerVacina(Vacina vacina, int quantidade) {
        if (vacina == null || quantidade <= 0)
            throw new IllegalArgumentException("Vacina não pode ser nula e Quantidade deve ser positiva");

        int estoqueAtual = verificarQuantidade(vacina);
        if (estoqueAtual < quantidade) {
            throw new IllegalStateException("Estoque insuficiente para " + vacina.getNome());
        }

        int restante = quantidade;

        for (LoteVacina lote : lotes) {
            if (lote.getVacina().equals(vacina) && !lote.isExpirado()) {
                int qtdLote = lote.getQuantidade();

                if (qtdLote >= restante) {
                    lote.setQuantidade(qtdLote - restante);
                    break;
                } else {
                    lote.setQuantidade(0);
                    restante -= qtdLote;
                }
            }
        }
    }

    @Override
    public int verificarQuantidade(Vacina vacina) {
        if (vacina == null)
            return 0;

        int total = 0;
        for (LoteVacina lote : lotes) {
            if (lote.getVacina().equals(vacina) && !lote.isExpirado()) {
                total += lote.getQuantidade();
            }
        }
        return total;
    }

    @Override
    public List<Vacina> listarVacinasDisponiveis() {
        List<Vacina> vacinasDisponiveis = new ArrayList<>();

        for (LoteVacina lote : lotes) {
            if (lote.getQuantidade() > 0 && !lote.isExpirado()) {
                Vacina vacina = lote.getVacina();
                if (!vacinasDisponiveis.contains(vacina)) {
                    vacinasDisponiveis.add(vacina);
                }
            }
        }

        return vacinasDisponiveis;
    }

    public List<LoteVacina> listarLotesProximosVencer(int diasAntecedencia) {
        return new ArrayList<>();
    }
}