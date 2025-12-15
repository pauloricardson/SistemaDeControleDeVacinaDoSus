package br.gov.sus.scvs.dominio.profissionais;

public abstract class ProfissionalSaude implements IAplicadorVacina {
    private String nome;
    private String registro;
    private String especialidade;

    public ProfissionalSaude(String nome, String registro) {
        setNome(nome);
        setRegistro(registro);
    }

    public String getNome() { return nome; }
    public String getRegistro() { return registro; }
    public String getEspecialidade() { return especialidade; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setRegistro(String registro) {
        if (registro == null || registro.trim().isEmpty())
            throw new IllegalArgumentException("Registro não pode ser vazio");
        this.registro = registro;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean podeAplicarVacina() {
        return true; // Implementação padrão, pode ser sobrescrita
    }
}