package br.gov.sus.scvs.dominio.cidadao;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class Cidadao implements IHistoricoVacinal {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private HistoricoVacinal historicoVacinal;

    public Cidadao(String nome, String cpf, String dataNascimento, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        this.historicoVacinal = new HistoricoVacinal();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public HistoricoVacinal getHistoricoVacinal() {
        return this.historicoVacinal;
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
        if (endereco == null || endereco.isEmpty())
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