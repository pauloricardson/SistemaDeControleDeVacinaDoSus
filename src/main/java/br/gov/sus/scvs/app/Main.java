package br.gov.sus.scvs.app;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;
import br.gov.sus.scvs.dominio.cidadao.Cidadao;
import br.gov.sus.scvs.dominio.cidadao.HistoricoVacinal;
import br.gov.sus.scvs.dominio.profissionais.Enfermeiro;
import br.gov.sus.scvs.dominio.profissionais.IAplicadorVacina;
import br.gov.sus.scvs.dominio.profissionais.Medico;
import br.gov.sus.scvs.dominio.profissionais.TecnicoEnfermagem;
import br.gov.sus.scvs.dominio.unidades.PostoVolante;
import br.gov.sus.scvs.dominio.unidades.Ubs;
import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;
import br.gov.sus.scvs.dominio.vacina.EstoqueVacinas;
import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;
import br.gov.sus.scvs.notificacao.INotificacaoEstoque;
import br.gov.sus.scvs.notificacao.NotificacaoVacina;
import br.gov.sus.scvs.relatorios.IRelatorioAplicacoes;
import br.gov.sus.scvs.relatorios.RelatorioVacinas;
import br.gov.sus.scvs.servicos.AplicacaoVacina;
import br.gov.sus.scvs.servicos.GerenciadorVacinas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        // Crair o Cidadao
        Cidadao roberta = new Cidadao("Roberta Bezerra", "12345678955", "15/03/2005", "Sitio Atoleiro, Varzea-CE");
        Cidadao eduarda = new Cidadao("Eduarda Marque", "78945612388", "14/05/2005", "Acopiara-CE");

        // cRiando os Enfermeiros
        TecnicoEnfermagem mariana = new TecnicoEnfermagem("Mariana Rafela", "COREN-2541", true);
        Enfermeiro jaqueline = new Enfermeiro("Jaqueline Miranda", "COREN-665520");

        // Criando nossas unidades de saúde
        Ubs ubsMulungu = new Ubs("UBS Comunidade do Mulungu", "Sítio Mulungu, Quixelô-CE", "8835817745", true);
        PostoVolante postoVolante = new PostoVolante("Posto Volante Capital do Centro-Sul vulgo Iguatu", "R. Dr. Agenor Araujo, 135 - Iguatu/CE", "8835815567", true, "Praça das Crianças");

        // Cadastrando nossas vacinas
        Vacina coronavac = new Vacina("CoronaVac", "Sinovac", "Para COVID-19", 2);
        Vacina gripe = new Vacina("Influenza", "Butantan", "Para gripe", 1);

        // Criamos o estoque
        EstoqueVacinas estoque = new EstoqueVacinas();

        //criamos o lote
        LoteVacina loteCoronavac = new LoteVacina("LOTE-C19-123456", coronavac, LocalDate.of(2025, 3, 15), LocalDate.of(2026, 03, 15), 150000);
        LoteVacina loteGripe = new LoteVacina("LOTE-INF-1255266", gripe, LocalDate.of(2025, 1, 20), LocalDate.of(2025, 12, 19), 20000);

        // adicionando o lote ao estoque
        estoque.adicionarLote(loteCoronavac);
        estoque.adicionarLote(loteGripe);

        List<AplicacaoVacina> todasAplicacoes = new ArrayList<>();

        // Criando as aplicações de vacina
        AplicacaoVacina aplicacao1 = new AplicacaoVacina(eduarda, coronavac, 1, loteCoronavac, mariana, ubsMulungu);
        AplicacaoVacina aplicacao2 = new AplicacaoVacina(roberta, gripe, 1, loteGripe, mariana, postoVolante);

        IAplicadorVacina medico1 = new Medico("Paulo Ricardson", "CRM-253554");
        medico1.podeAplicarVacina();
        medico1.aplicarVacina(aplicacao1);

        todasAplicacoes.add(aplicacao1);
        todasAplicacoes.add(aplicacao2);

        HistoricoVacinal historicoEduarda = new HistoricoVacinal();
        historicoEduarda.adicionarAplicacao(aplicacao1);

        HistoricoVacinal hitoricoRoberta = new HistoricoVacinal();
        hitoricoRoberta.adicionarAplicacao(aplicacao2);

        Agendamento agendamento1 = new Agendamento(LocalDate.of(2025, 12, 21), LocalTime.of(13, 30, 00), eduarda, coronavac, ubsMulungu);

        NotificacaoVacina not = new NotificacaoVacina();
        not.notificarAgendamento(agendamento1);

        CampanhaVacinacao capanha1 = new CampanhaVacinacao("Cpanha de Vacinação Contra Gripe", "IDOSOS", LocalDate.of(2026, 01, 01), LocalDate.of(2026, 2, 1));
        capanha1.adicionarUnidade(ubsMulungu);
        capanha1.adicionarVacina(gripe);
        capanha1.iniciarCampanha();

        IRelatorioAplicacoes relatorio1 = new RelatorioVacinas(todasAplicacoes);
        INotificacaoEstoque not2 = new NotificacaoVacina();

        GerenciadorVacinas gerenciador = new GerenciadorVacinas(relatorio1, not2);
        gerenciador.gerarRelatorioAplicacoes();
        gerenciador.getNotificacaoEstoque().notificarEstoqueBaixo(gripe);
        gerenciador.getNotificacaoEstoque().notificarVacinaProximaValidade(loteGripe);

    }
}
