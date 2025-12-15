package br.gov.sus.scvs.dominio.vacina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstoqueVacinas implements IEstoqueManager {
    private Map<Vacina, Integer> estoque;

    public EstoqueVacinas() {
        this.estoque = new HashMap<>();
    }

    @Override
    public void adicionarLote(LoteVacina lote) {
        if (lote == null) throw new IllegalArgumentException("Lote não pode ser nulo");
        if (lote.isExpirado()) throw new IllegalArgumentException("Lote expirado não pode ser adicionado");

        estoque.put(lote.getVacina(),
                estoque.getOrDefault(lote.getVacina(), 0) + lote.getQuantidade());
    }

    @Override
    public void removerVacina(Vacina vacina, int quantidade) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");

        int estoqueAtual = estoque.getOrDefault(vacina, 0);
        if (estoqueAtual < quantidade) {
            throw new IllegalStateException("Estoque insuficiente para " + vacina.getNome());
        }
        estoque.put(vacina, estoqueAtual - quantidade);
    }

    @Override
    public int verificarQuantidade(Vacina vacina) {
        return estoque.getOrDefault(vacina, 0);
    }

    @Override
    public List<Vacina> listarVacinasDisponiveis() {
        return estoque.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<LoteVacina> listarLotesProximosVencer(int diasAntecedencia) {
        return new ArrayList<>();
    }
}
