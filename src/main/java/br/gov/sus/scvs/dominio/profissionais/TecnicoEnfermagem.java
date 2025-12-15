package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class TecnicoEnfermagem extends ProfissionalSaude {

    public TecnicoEnfermagem(String nome, String registro, boolean certificadoVacinacaoAtualizado) {
        super(nome, registro);
        setEspecialidade("Enfermagem");
    }

    @Override
    public boolean podeAplicarVacina() {
        return true;
    }

    @Override
    public void aplicarVacina(AplicacaoVacina app) {
        if (!podeAplicarVacina()) {
            throw new IllegalStateException("Técnico não pode aplicar vacina - certificado vencido");
        }
        System.out.println("Técnico " + getNome() + " aplicou vacina.");
    }
}
