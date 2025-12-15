package br.gov.sus.scvs.dominio.profissionais;

public abstract class ProfissionalSaude implements IAplicadorVacina {
    private String nome;
    private String registro;
    private String especialidade;

    public ProfissionalSaude(String nome, String registro, String especialidade) {
        setNome(nome);
        setRegistro(registro);
        setEspecialidade(especialidade);
    }

    public String getNome() {
        return this.nome;
    }
    public String getRegistro() {
        return this.registro;
    }
    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setRegistro(String registro) {
        if (registro == null || registro.isEmpty())
            throw new IllegalArgumentException("Registro não pode ser vazio");
        this.registro = registro;
    }

    public void setEspecialidade(String especialidade) {
        if(especialidade == null || especialidade.isEmpty())
            throw new IllegalArgumentException("Especialidade não pode ser vazio");
        this.especialidade = especialidade;
    }

    @Override
    public boolean podeAplicarVacina() {
        return true;
    }
}