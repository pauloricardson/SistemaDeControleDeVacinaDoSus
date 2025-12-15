package br.gov.sus.scvs.dominio.vacina;

public class Vacina implements IVacinaValidador {
    private String nome;
    private String fabricante;
    private String indicacao;
    private int dosesNecessarias;
    private boolean ativa;

    public Vacina(String nome, String fabricante, int dosesNecessarias) {
        setNome(nome);
        this.fabricante = fabricante;
        setDosesNecessarias(dosesNecessarias);
        this.ativa = true;
    }

    public String getNome() { return nome; }
    public String getFabricante() { return fabricante; }
    public String getIndicacao() { return indicacao; }
    public int getDosesNecessarias() { return dosesNecessarias; }
    public boolean isAtiva() { return ativa; }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome da vacina não pode ser vazio");
        this.nome = nome;
    }

    public void setDosesNecessarias(int doses) {
        if (doses <= 0) throw new IllegalArgumentException("Doses necessárias deve ser maior que zero");
        this.dosesNecessarias = doses;
    }

    public void setIndicacao(String indicacao) { this.indicacao = indicacao; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    @Override
    public boolean isValidaParaAplicacao() {
        return ativa && dosesNecessarias > 0;
    }
}