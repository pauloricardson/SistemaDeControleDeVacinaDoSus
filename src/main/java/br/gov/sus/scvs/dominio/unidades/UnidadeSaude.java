package br.gov.sus.scvs.dominio.unidades;

public abstract class UnidadeSaude implements IUnidadeAtendimento {
    private String nome;
    private String endereco;
    private String telefone;
    private boolean aberta;

    public UnidadeSaude(String nome, String endereco, String telefone, boolean aberta) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.aberta = aberta;
    }

    public String getNome() {
        return this.nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public boolean estaAberta() {
        return this.aberta;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        if(endereco == null || endereco.isEmpty())
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty())
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        this.telefone = telefone;
    }
}
