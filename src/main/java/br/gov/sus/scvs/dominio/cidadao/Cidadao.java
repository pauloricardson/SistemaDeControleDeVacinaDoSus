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

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public String getEndereco() { return endereco; }
    public HistoricoVacinal getHistoricoVacinal() { return historicoVacinal; }

    // Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isEmpty())
            throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf;
    }

    // Implementação da interface IHistoricoVacinal
    @Override
    public void adicionarAplicacao(AplicacaoVacina app) {
        historicoVacinal.adicionarAplicacao(app);
    }

    @Override
    public int obterTotalAplicacoes() {
        return 0;
    }

    @Override
    public int getTotalAplicacoes() {
        return historicoVacinal.getTotalAplicacoes();
    }
}