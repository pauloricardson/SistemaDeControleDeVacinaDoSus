package br.gov.sus.scvs.dominio.unidades;

public class Ubs extends UnidadeSaude {

    public Ubs(String nome) {
        super(nome);
    }

    @Override
    public void realizarAtendimento() {
        if (!estaAberta()) {
            throw new IllegalStateException("UBS está fechada");
        }
        System.out.println("Atendimento em UBS: " + getNome());
    }
}
