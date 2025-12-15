package br.gov.sus.scvs.dominio.vacina;

public class Vacina implements IVacinaValidador {
    private String nome;
    private String fabricante;
    private String indicacao;
    private int dosesNecessarias;
    private boolean ativa;

    public Vacina(String nome, String fabricante, String indicacao, int dosesNecessarias) {
        setNome(nome);
        setFabricante(fabricante);
        setIndicacao(indicacao);
        setDosesNecessarias(dosesNecessarias);
        this.ativa = true;
    }

    public String getNome() {
        return this.nome;
    }
    public String getFabricante() {
        return this.fabricante;
    }
    public String getIndicacao() {
        return this.indicacao;
    }
    public int getDosesNecessarias() {
        return this.dosesNecessarias;
    }
    public boolean isAtiva() {
        return this.ativa;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome da vacina não pode ser vazio");
        this.nome = nome;
    }

    public void setFabricante(String fabricante) {
        if(fabricante == null)
            throw new IllegalArgumentException("Nome do fabricante não pode ser vazio");
        this.fabricante = fabricante;
    }

    public void setIndicacao(String indicacao) {
        if(indicacao == null)
            throw new IllegalArgumentException("Nome da indicação não pode ser vazio");
        this.indicacao = indicacao;
    }

    public void setDosesNecessarias(int doses) {
        if (doses <= 0)
            throw new IllegalArgumentException("Doses necessárias deve ser maior que zero");
        this.dosesNecessarias = doses;
    }


    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public boolean isValidaParaAplicacao() {
        return this.ativa && this.dosesNecessarias > 0;
    }
}