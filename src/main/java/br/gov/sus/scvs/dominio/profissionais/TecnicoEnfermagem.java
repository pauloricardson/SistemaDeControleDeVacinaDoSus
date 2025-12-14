package br.gov.sus.scvs.dominio.profissionais;

import br.gov.sus.scvs.servicos.AplicacaoVacina;

public class TecnicoEnfermagem extends ProfissionalSaude {
    private boolean certificadoVacinacaoAtualizado;

    public TecnicoEnfermagem(String nome, String registro, boolean certificadoVacinacaoAtualizado) {
        super(nome, registro);
        setEspecialidade("Enfermagem");
        this.certificadoVacinacaoAtualizado = certificadoVacinacaoAtualizado;
    }

    @Override
    public boolean podeAplicarVacina() {
        return certificadoVacinacaoAtualizado;
    }

    @Override
    public void aplicarVacina(AplicacaoVacina app) {
        if (!podeAplicarVacina()) {
            throw new IllegalStateException("Técnico não pode aplicar vacina - certificado vencido");
        }
        System.out.println("Técnico " + getNome() + " aplicou vacina.");
    }
}
