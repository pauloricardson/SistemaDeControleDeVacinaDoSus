package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class Enfermeiro extends ProfissionalSaude {
    public Enfermeiro(String nome, String registro) {
        super(nome, registro);
        setEspecialidade("Enfermagem");
    }

    @Override
    public void aplicarVacina(AplicacaoVacina app) {
        System.out.println("Enfermeiro " + getNome() + " aplicou vacina.");
    }
}
