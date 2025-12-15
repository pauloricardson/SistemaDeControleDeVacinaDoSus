package br.gov.sus.scvs.dominio.cidadao;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class Cidadao implements IHistoricoVacinal {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private HistoricoVacinal historicoVacinal;

    public Cidadao(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
        this.historicoVacinal = new HistoricoVacinal();
    }

    public Cidadao(String nome, String cpf, String dataNascimento, String endereco) {
        this(nome, cpf);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public HistoricoVacinal getHistoricoVacinal() {
        return historicoVacinal;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isEmpty())
            throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento == null || dataNascimento.isEmpty()) {
            throw new IllegalArgumentException("Data de nascimento não pode ser vazia");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty())
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        this.endereco = endereco;
    }

    @Override
    public void adicionarAplicacao(AplicacaoVacina aplicacao) {
        historicoVacinal.adicionarAplicacao(aplicacao);
    }

    @Override
    public int obterTotalAplicacoes() {
        return historicoVacinal.getTotalAplicacoes();
    }
}