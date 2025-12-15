package br.gov.sus.scvs.app;

import br.gov.sus.scvs.dominio.cidadao.Cidadao;
import br.gov.sus.scvs.dominio.profissionais.Enfermeiro;
import br.gov.sus.scvs.dominio.profissionais.TecnicoEnfermagem;
import br.gov.sus.scvs.dominio.unidades.PostoVolante;
import br.gov.sus.scvs.dominio.unidades.Ubs;
import br.gov.sus.scvs.dominio.vacina.EstoqueVacinas;
import br.gov.sus.scvs.dominio.vacina.Vacina;

public class Main2 {
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

        EstoqueVacinas estoque = new EstoqueVacinas();

    }
}
