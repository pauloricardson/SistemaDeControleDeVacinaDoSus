package br.gov.sus.scvs.servicos;

import br.gov.sus.scvs.dominio.vacina.Vacina;
import br.gov.sus.scvs.notificacao.INotificacaoEstoque;
import br.gov.sus.scvs.relatorios.IRelatorioAplicacoes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorVacinas {
    private List<Vacina> vacinas;
    private IRelatorioAplicacoes relatorioAplicacoes;
    private INotificacaoEstoque notificacaoEstoque;
    private List<AplicacaoVacina> aplicacoes;

    // DIP: Dependemos de abstrações
    public GerenciadorVacinas(IRelatorioAplicacoes relatorioAplicacoes, INotificacaoEstoque notificacaoEstoque) {
        this.vacinas = new ArrayList<>();
        this.aplicacoes = new ArrayList<>();
        this.relatorioAplicacoes = relatorioAplicacoes;
        this.notificacaoEstoque = notificacaoEstoque;
    }

    public void cadastrarVacina(Vacina vacina) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        vacinas.add(vacina);
    }

    public void adicionarAplicacao(AplicacaoVacina aplicacao) {
        if (aplicacao == null) {
            throw new IllegalArgumentException("Aplicacao nao pode ser nula");
        }
        aplicacoes.add(aplicacao);
    }

    public void registrarAplicacao(AplicacaoVacina aplicacao) {
        if (aplicacao == null) throw new IllegalArgumentException("Aplicação não pode ser nula");
        aplicacoes.add(aplicacao);
        aplicacao.registrar();
    }

    public void gerarRelatorioAplicacoes() {
        System.out.println(relatorioAplicacoes.gerarRelatorioTotalAplicadas());
    }

    public List<Vacina> getVacinasCadastradas() {
        return new ArrayList<>(vacinas);
    }

    public int getTotalAplicacoes() {
        return aplicacoes.size();
    }
}
