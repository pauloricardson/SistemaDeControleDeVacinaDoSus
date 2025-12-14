package br.gov.sus.scvs.dominio.vacina;

import java.util.List;

public interface IEstoqueManager {
    void adicionarLote(LoteVacina lote);
    void removerVacina(Vacina vacina, int quantidade);
    int verificarQuantidade(Vacina vacina);
    List<Vacina> listarVacinasDisponiveis();
}