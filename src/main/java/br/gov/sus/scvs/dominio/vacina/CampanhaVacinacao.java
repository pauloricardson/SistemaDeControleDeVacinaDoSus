package br.gov.sus.scvs.dominio.vacina;

import br.gov.sus.scvs.dominio.unidades.UnidadeSaude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampanhaVacinacao {
    private String nome;
    private String publicoAlvo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Vacina> vacinas;
    private List<UnidadeSaude> unidades;
    private boolean ativa;

    public CampanhaVacinacao(String nome, String publicoAlvo,
                             LocalDate dataInicio, LocalDate dataFim) {
        setNome(nome);
        setPublicoAlvo(publicoAlvo);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        this.vacinas = new ArrayList<>();
        this.unidades = new ArrayList<>();
        this.ativa = false;
    }

    public String getNome() { return nome; }
    public String getPublicoAlvo() { return publicoAlvo; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public boolean isAtiva() { return ativa; }
    public List<Vacina> getVacinas() { return new ArrayList<>(vacinas); }
    public List<UnidadeSaude> getUnidades() { return new ArrayList<>(unidades); }

    private void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome da campanha não pode ser vazio");
        this.nome = nome;
    }

    private void setPublicoAlvo(String publicoAlvo) {
        if (publicoAlvo == null || publicoAlvo.trim().isEmpty())
            throw new IllegalArgumentException("Público alvo não pode ser vazio");
        this.publicoAlvo = publicoAlvo;
    }

    private void setDataInicio(LocalDate dataInicio) {
        if (dataInicio == null) throw new IllegalArgumentException("Data início não pode ser nula");
        this.dataInicio = dataInicio;
    }

    private void setDataFim(LocalDate dataFim) {
        if (dataFim == null) throw new IllegalArgumentException("Data fim não pode ser nula");
        if (dataInicio != null && dataFim.isBefore(dataInicio))
            throw new IllegalArgumentException("Data fim deve ser após data início");
        this.dataFim = dataFim;
    }

    public void adicionarVacina(Vacina vacina) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        vacinas.add(vacina);
    }

    public void adicionarUnidade(UnidadeSaude unidade) {
        if (unidade == null) throw new IllegalArgumentException("Unidade não pode ser nula");
        unidades.add(unidade);
    }

    public void iniciarCampanha() {
        if (vacinas.isEmpty()) throw new IllegalStateException("Campanha sem vacinas definidas");
        if (unidades.isEmpty()) throw new IllegalStateException("Campanha sem unidades definidas");

        ativa = true;
        System.out.println("Campanha " + nome + " iniciada para " + publicoAlvo);
    }

    public void finalizarCampanha() {
        ativa = false;
        System.out.println("Campanha " + nome + " finalizada");
    }
}

