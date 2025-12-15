package br.gov.sus.scvs.app;

import br.gov.sus.scvs.dominio.agendamento.Agendamento;
import br.gov.sus.scvs.dominio.agendamento.StatusAgendamento;
import br.gov.sus.scvs.dominio.cidadao.Cidadao;
import br.gov.sus.scvs.dominio.cidadao.HistoricoVacinal;
import br.gov.sus.scvs.dominio.profissionais.Enfermeiro;
import br.gov.sus.scvs.dominio.profissionais.Medico;
import br.gov.sus.scvs.dominio.profissionais.TecnicoEnfermagem;
import br.gov.sus.scvs.dominio.unidades.HospitalPublico;
import br.gov.sus.scvs.dominio.unidades.PostoVolante;
import br.gov.sus.scvs.dominio.unidades.Ubs;
import br.gov.sus.scvs.dominio.vacina.CampanhaVacinacao;
import br.gov.sus.scvs.dominio.vacina.EstoqueVacinas;
import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;
import br.gov.sus.scvs.notificacao.INotificacaoEstoque;
import br.gov.sus.scvs.relatorios.IRelatorioAplicacoes;
import br.gov.sus.scvs.servicos.AplicacaoVacina;
import br.gov.sus.scvs.servicos.GerenciadorVacinas;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println("============================================");
//        System.out.println("SISTEMA DE VACINACAO - INICIALIZANDO");
//        System.out.println("============================================\n");
//
//        System.out.println("1. CRIACAO DOS OBJETOS");
//        System.out.println("----------------------");
//
//        System.out.println("\n1.1 CIDADAOS:");
//        Cidadao joao = new Cidadao("Joao Silva", "12345678901", "15/03/1980", "Rua A, 123");
//        Cidadao maria = new Cidadao("Maria Santos", "98765432100", "22/07/1995", "Av. B, 456");
//        Cidadao pedro = new Cidadao("Pedro Costa", "11122233344", "10/11/1972", "Rua C, 789");
//
//        System.out.println("Cidadao criado: " + joao.getNome() + " - CPF: " + joao.getCpf());
//        System.out.println("Cidadao criado: " + maria.getNome() + " - CPF: " + maria.getCpf());
//        System.out.println("Cidadao criado: " + pedro.getNome() + " - CPF: " + pedro.getCpf());
//
//        System.out.println("\n1.2 PROFISSIONAIS DE SAUDE:");
//        Medico draAna = new Medico("Dra. Ana Mendes", "CRM-SP12345");
//        TecnicoEnfermagem tecnicoCarlos = new TecnicoEnfermagem("Carlos Oliveira", "COREN-SP54321", true);
//        Enfermeiro enfermeiraBeatriz = new Enfermeiro("Beatriz Souza", "COREN-SP98765");
//
//        System.out.println("Medico criado: " + draAna.getNome() + " - Registro: " + draAna.getRegistro());
//        System.out.println("Tecnico criado: " + tecnicoCarlos.getNome() + " - Registro: " + tecnicoCarlos.getRegistro());
//        System.out.println("Enfermeira criada: " + enfermeiraBeatriz.getNome() + " - Registro: " + enfermeiraBeatriz.getRegistro());
//
//        System.out.println("\n1.3 UNIDADES DE SAUDE:");
//        Ubs ubsCentro = new Ubs("UBS Centro");
//        ubsCentro.setEndereco("Av. Central, 100");
//        ubsCentro.setTelefone("(11) 3333-4444");
//
//        HospitalPublico hospitalMunicipal = new HospitalPublico("Hospital Municipal");
//        hospitalMunicipal.setEndereco("Rua das Flores, 500");
//        hospitalMunicipal.setTelefone("(11) 5555-6666");
//
//        PostoVolante postoMovel = new PostoVolante("Posto Volante Zona Norte");
//        postoMovel.setEndereco("Praca da Arvore - Zona Norte");
//        postoMovel.setLocalizacaoAtual("Praca Central");
//
//        System.out.println("UBS criada: " + ubsCentro.getNome());
//        System.out.println("Hospital criado: " + hospitalMunicipal.getNome());
//        System.out.println("Posto Volante criado: " + postoMovel.getNome());
//
//        System.out.println("\n1.4 VACINAS:");
//        Vacina coronavac = new Vacina("CoronaVac", "Sinovac", 2);
//        coronavac.setIndicacao("Prevencao COVID-19");
//
//        Vacina pfizer = new Vacina("Pfizer", "Pfizer/BioNTech", 2);
//        pfizer.setIndicacao("Prevencao COVID-19");
//
//        Vacina influenza = new Vacina("Influenza", "Butantan", 1);
//        influenza.setIndicacao("Prevencao Gripe");
//
//        System.out.println("Vacina criada: " + coronavac.getNome());
//        System.out.println("Vacina criada: " + pfizer.getNome());
//        System.out.println("Vacina criada: " + influenza.getNome());
//
//        System.out.println("\n2. GERENCIAMENTO DE ESTOQUE");
//        System.out.println("---------------------------");
//
//        EstoqueVacinas estoque = new EstoqueVacinas();
//
//        LoteVacina loteCoronavac1 = new LoteVacina(
//                "LOTE-CV-2023-001",
//                coronavac,
//                LocalDate.of(2023, 1, 15),
//                LocalDate.of(2026, 6, 15),
//                1000
//        );
//
//        LoteVacina lotePfizer1 = new LoteVacina(
//                "LOTE-PF-2023-001",
//                pfizer,
//                LocalDate.of(2023, 2, 1),
//                LocalDate.of(2026, 7, 1),
//                500
//        );
//
//        LoteVacina loteInfluenza1 = new LoteVacina(
//                "LOTE-IN-2023-001",
//                influenza,
//                LocalDate.of(2023, 3, 10),
//                LocalDate.of(2026, 3, 10),
//                300
//        );
//
//        estoque.adicionarLote(loteCoronavac1);
//        estoque.adicionarLote(lotePfizer1);
//        estoque.adicionarLote(loteInfluenza1);
//
//        System.out.println("Lotes adicionados ao estoque:");
//        System.out.println("- CoronaVac: " + estoque.verificarQuantidade(coronavac) + " doses");
//        System.out.println("- Pfizer: " + estoque.verificarQuantidade(pfizer) + " doses");
//        System.out.println("- Influenza: " + estoque.verificarQuantidade(influenza) + " doses");
//
//        System.out.println("\n3. APLICACOES DE VACINA");
//        System.out.println("-----------------------");
//
//        List<AplicacaoVacina> todasAplicacoes = new ArrayList<>();
//
//        System.out.println("\n3.1 APLICACAO 1 - Joao (CoronaVac - Dose 1):");
//        AplicacaoVacina aplicacao1 = new AplicacaoVacina(
//                joao,
//                coronavac,
//                1,
//                loteCoronavac1,
//                tecnicoCarlos,
//                ubsCentro
//        );
//
//        if (aplicacao1.podeSerRegistrada()) {
//            aplicacao1.registrar();
//            estoque.removerVacina(coronavac, 1);
//            todasAplicacoes.add(aplicacao1);
//            System.out.println("Aplicacao registrada com sucesso");
//            System.out.println("Estoque atual: CoronaVac - " + estoque.verificarQuantidade(coronavac) + " doses");
//        }
//
//        System.out.println("\n3.2 APLICACAO 2 - Maria (Pfizer - Dose 1):");
//        AplicacaoVacina aplicacao2 = new AplicacaoVacina(
//                maria,
//                pfizer,
//                1,
//                lotePfizer1,
//                enfermeiraBeatriz,
//                hospitalMunicipal
//        );
//
//        if (aplicacao2.podeSerRegistrada()) {
//            aplicacao2.registrar();
//            estoque.removerVacina(pfizer, 1);
//            todasAplicacoes.add(aplicacao2);
//            System.out.println("Aplicacao registrada com sucesso");
//            System.out.println("Estoque atual: Pfizer - " + estoque.verificarQuantidade(pfizer) + " doses");
//        }
//
//        System.out.println("\n3.3 APLICACAO 3 - Pedro (Influenza - Dose Unica):");
//        AplicacaoVacina aplicacao3 = new AplicacaoVacina(
//                pedro,
//                influenza,
//                1,
//                loteInfluenza1,
//                draAna,
//                postoMovel
//        );
//
//        if (aplicacao3.podeSerRegistrada()) {
//            aplicacao3.registrar();
//            estoque.removerVacina(influenza, 1);
//            todasAplicacoes.add(aplicacao3);
//            System.out.println("Aplicacao registrada com sucesso");
//            System.out.println("Estoque atual: Influenza - " + estoque.verificarQuantidade(influenza) + " doses");
//        }
//
//        System.out.println("\n4. HISTORICOS VACINAIS");
//        System.out.println("----------------------");
//
//        System.out.println("\nHistorico de Joao:");
//        HistoricoVacinal historicoJoao = joao.getHistoricoVacinal();
//        System.out.println("Total de aplicacoes: " + historicoJoao.getTotalAplicacoes());
//        for (AplicacaoVacina a : historicoJoao.getAplicacoes()) {
//            System.out.println("- " + a.getVacina().getNome() + " - Dose " + a.getDose() +
//                    " - Data: " + a.getDataHoraAplicacao().toLocalDate());
//        }
//
//        System.out.println("\nHistorico de Maria:");
//        HistoricoVacinal historicoMaria = maria.getHistoricoVacinal();
//        System.out.println("Total de aplicacoes: " + historicoMaria.getTotalAplicacoes());
//
//        System.out.println("\nHistorico de Pedro:");
//        HistoricoVacinal historicoPedro = pedro.getHistoricoVacinal();
//        System.out.println("Total de aplicacoes: " + historicoPedro.getTotalAplicacoes());
//
//        System.out.println("\n5. AGENDAMENTOS");
//        System.out.println("---------------");
//
//        Agendamento agendamento1 = new Agendamento(
//                LocalDate.now().plusDays(7),
//                LocalTime.of(14, 30),
//                joao,
//                coronavac,
//                ubsCentro
//        );
//
//        Agendamento agendamento2 = new Agendamento(
//                LocalDate.now().plusDays(10),
//                LocalTime.of(9, 0),
//                maria,
//                pfizer,
//                hospitalMunicipal
//        );
//
//        System.out.println("Agendamento 1 criado:");
//        System.out.println("- Cidadao: " + agendamento1.getCidadao().getNome());
//        System.out.println("- Vacina: " + agendamento1.getVacina().getNome());
//        System.out.println("- Data: " + agendamento1.getDataAgendada());
//        System.out.println("- Status: " + agendamento1.getStatus());
//
//        System.out.println("\nAgendamento 2 criado:");
//        System.out.println("- Cidadao: " + agendamento2.getCidadao().getNome());
//
//        agendamento1.setStatus(StatusAgendamento.CONFIRMADO);
//        System.out.println("\nAgendamento 1 confirmado!");
//        System.out.println("Novo status: " + agendamento1.getStatus());
//        System.out.println("Esta ativo? " + agendamento1.getStatus().estaAtivo());
//
//        System.out.println("\n6. CAMPANHA DE VACINACAO");
//        System.out.println("------------------------");
//
//        CampanhaVacinacao campanhaCovid = new CampanhaVacinacao(
//                "Campanha COVID-19 2023",
//                "Idosos acima de 60 anos",
//                LocalDate.of(2023, 4, 1),
//                LocalDate.of(2023, 4, 30)
//        );
//
//        campanhaCovid.adicionarVacina(coronavac);
//        campanhaCovid.adicionarVacina(pfizer);
//        campanhaCovid.adicionarUnidade(ubsCentro);
//        campanhaCovid.adicionarUnidade(hospitalMunicipal);
//
//        System.out.println("Campanha criada: " + campanhaCovid.getNome());
//        System.out.println("Publico alvo: " + campanhaCovid.getPublicoAlvo());
//
//        try {
//            campanhaCovid.iniciarCampanha();
//        } catch (Exception e) {
//            System.out.println("Erro ao iniciar campanha: " + e.getMessage());
//        }
//
//        System.out.println("\n7. GERENCIADOR DE VACINAS");
//        System.out.println("-------------------------");
//
//        IRelatorioAplicacoes relatorioImpl = new IRelatorioAplicacoes() {
//            @Override
//            public String gerarRelatorioTotalAplicadas() {
//                return "RELATORIO DE APLICACOES\nTotal de aplicacoes: " + todasAplicacoes.size();
//            }
//
//            @Override
//            public String gerarRelatorioEficaciaVacinal() {
//                return "EFICACIA VACINAL\nDados em analise...";
//            }
//
//            @Override
//            public String gerarRelatorioCidadãosNaoVacinados() {
//                return "CIDADAOS NAO VACINADOS\nRelatorio em construcao...";
//            }
//        };
//
//        INotificacaoEstoque notificacaoImpl = new INotificacaoEstoque() {
//            @Override
//            public void notificarVacinaProximaValidade(LoteVacina lote) {
//                System.out.println("Notificacao: Lote " + lote.getNumeroLote() + " proximo do vencimento");
//            }
//
//            @Override
//            public void notificarEstoqueBaixo(Vacina vacina) {
//                System.out.println("Notificacao: Estoque baixo de " + vacina.getNome());
//            }
//        };
//
//        GerenciadorVacinas gerenciador = new GerenciadorVacinas(relatorioImpl, notificacaoImpl);
//
//        gerenciador.cadastrarVacina(coronavac);
//        gerenciador.cadastrarVacina(pfizer);
//        gerenciador.cadastrarVacina(influenza);
//
//        gerenciador.adicionarAplicacao(aplicacao1);
//        gerenciador.adicionarAplicacao(aplicacao2);
//        gerenciador.adicionarAplicacao(aplicacao3);
//
//        System.out.println("Gerenciador configurado com " + gerenciador.getVacinasCadastradas().size() + " vacinas");
//        System.out.println("Total de aplicacoes registradas: " + gerenciador.getTotalAplicacoes());
//
//        System.out.println("\nGerando relatorio:");
//        gerenciador.gerarRelatorioAplicacoes();
//
//        System.out.println("\nTestando notificacoes:");
//        notificacaoImpl.notificarEstoqueBaixo(coronavac);
//        notificacaoImpl.notificarVacinaProximaValidade(loteCoronavac1);
//
//        System.out.println("\n8. TESTES DE VALIDACAO");
//        System.out.println("----------------------");
//
//        System.out.println("\nTeste 1 - Cidadao com CPF invalido:");
//        try {
//            Cidadao cidadaoInvalido = new Cidadao("Teste", "123");
//            System.out.println("ERRO: Cidadao com CPF invalido foi criado");
//        } catch (IllegalArgumentException e) {
//            System.out.println("CORRETO: " + e.getMessage());
//        }
//
//        System.out.println("\nTeste 2 - Agendamento com data passada:");
//        try {
//            Agendamento agendamentoInvalido = new Agendamento(
//                    LocalDate.now().minusDays(1),
//                    LocalTime.of(10, 0),
//                    joao,
//                    coronavac,
//                    ubsCentro
//            );
//            System.out.println("ERRO: Agendamento com data passada foi criado");
//        } catch (IllegalArgumentException e) {
//            System.out.println("CORRETO: " + e.getMessage());
//        }
//
//        System.out.println("\nTeste 3 - Vacina sem doses necessarias:");
//        try {
//            Vacina vacinaInvalida = new Vacina("Teste", "Fabricante", 0);
//            System.out.println("ERRO: Vacina com 0 doses foi criada");
//        } catch (IllegalArgumentException e) {
//            System.out.println("CORRETO: " + e.getMessage());
//        }
//
//        System.out.println("\n9. PRINCIPIOS SOLID APLICADOS");
//        System.out.println("-----------------------------");
//
//        System.out.println("\nSRP (Single Responsibility Principle):");
//        System.out.println("- Cidadao: gerencia apenas dados pessoais");
//        System.out.println("- HistoricoVacinal: gerencia apenas historico");
//        System.out.println("- Agendamento: gerencia apenas dados de agendamento");
//        System.out.println("- EstoqueVacinas: gerencia apenas estoque");
//
//        System.out.println("\nOCP (Open/Closed Principle):");
//        System.out.println("- Pode criar novo ProfissionalSaude sem modificar base");
//        System.out.println("- Pode criar nova UnidadeSaude sem modificar base");
//
//        System.out.println("\nLSP (Liskov Substitution Principle):");
//        System.out.println("- Medico, Enfermeiro, Tecnico: todos sao ProfissionalSaude");
//
//        System.out.println("\nISP (Interface Segregation Principle):");
//        System.out.println("- INotificacaoEstoque: apenas notificacoes de estoque");
//        System.out.println("- IRelatorioAplicacoes: apenas relatorios de aplicacao");
//
//        System.out.println("\nDIP (Dependency Inversion Principle):");
//        System.out.println("- GerenciadorVacinas depende de interfaces");
//
//        System.out.println("\n============================================");
//        System.out.println("RESUMO DO SISTEMA");
//        System.out.println("============================================");
//
//        System.out.println("\nCIDADAOS CADASTRADOS: 3");
//        System.out.println("PROFISSIONAIS CADASTRADOS: 3");
//        System.out.println("UNIDADES CADASTRADAS: 3");
//        System.out.println("VACINAS CADASTRADAS: 3");
//        System.out.println("APLICACOES REALIZADAS: " + todasAplicacoes.size());
//        System.out.println("AGENDAMENTOS CRIADOS: 2");
//
//        int totalEstoque = estoque.verificarQuantidade(coronavac) +
//                estoque.verificarQuantidade(pfizer) +
//                estoque.verificarQuantidade(influenza);
//        System.out.println("TOTAL DE DOSES EM ESTOQUE: " + totalEstoque);
//
//        System.out.println("\n============================================");
//        System.out.println("SISTEMA FINALIZADO COM SUCESSO");
//        System.out.println("============================================");
   }
}
