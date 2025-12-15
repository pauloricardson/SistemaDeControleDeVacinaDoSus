package br.gov.sus.scvs.dominio.unidades;

public abstract class UnidadeSaude implements IUnidadeAtendimento {
    private String nome;
    private String endereco;
    private String telefone;
    private boolean aberta;

    public UnidadeSaude(String nome) {
        setNome(nome);
        this.aberta = true;
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }

    @Override
    public boolean estaAberta() { return aberta; }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setAberta(boolean aberta) { this.aberta = aberta; }
}
