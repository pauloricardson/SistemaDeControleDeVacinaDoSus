package br.gov.sus.scvs.dominio.vacina;

import java.time.LocalDate;

public class LoteVacina {
    private String numeroLote;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private int quantidade;
    private Vacina vacina;

    public LoteVacina(String numeroLote, Vacina vacina, LocalDate dataFabricacao,
                      LocalDate dataValidade, int quantidade) {
        setNumeroLote(numeroLote);
        setVacina(vacina);
        setDataFabricacao(dataFabricacao);
        setDataValidade(dataValidade);
        setQuantidade(quantidade);
    }

    public String getNumeroLote() { return numeroLote; }
    public Vacina getVacina() { return vacina; }
    public int getQuantidade() { return quantidade; }
    public LocalDate getDataFabricacao() { return dataFabricacao; }
    public LocalDate getDataValidade() { return dataValidade; }

    public void setNumeroLote(String numeroLote) {
        if (numeroLote == null || numeroLote.isEmpty())
            throw new IllegalArgumentException("Número do lote não pode ser vazio");
        this.numeroLote = numeroLote;
    }

    public void setVacina(Vacina vacina) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        this.vacina = vacina;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa");
        this.quantidade = quantidade;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        if (dataFabricacao == null) throw new IllegalArgumentException("Data fabricação não pode ser nula");
        if (dataFabricacao.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data fabricação não pode ser futura");
        this.dataFabricacao = dataFabricacao;
    }

    public void setDataValidade(LocalDate dataValidade) {
        if (dataValidade == null) throw new IllegalArgumentException("Data validade não pode ser nula");
        if (dataFabricacao != null && dataValidade.isBefore(dataFabricacao))
            throw new IllegalArgumentException("Data validade deve ser após fabricação");
        this.dataValidade = dataValidade;
    }

    public boolean isExpirado() {
        return LocalDate.now().isAfter(dataValidade);
    }

    public boolean isProximoVencer(int diasAntecedencia) {
        return LocalDate.now().isAfter(dataValidade.minusDays(diasAntecedencia));
    }
}

