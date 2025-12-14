package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class Medico extends ProfissionalSaude {
    public Medico(String nome, String registro) {
        super(nome, registro);
        setEspecialidade("Clínico Geral");
    }

    @Override
    public void aplicarVacina(AplicacaoVacina app) {
        if (!podeAplicarVacina()) {
            throw new IllegalStateException("Médico não pode aplicar vacina no momento");
        }
        System.out.println("Médico " + getNome() + " supervisionou aplicação.");
    }
}
