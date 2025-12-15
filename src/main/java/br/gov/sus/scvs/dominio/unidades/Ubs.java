package br.gov.sus.scvs.dominio.unidades;

public class Ubs extends UnidadeSaude {

    public Ubs(String nome, String endereco, String telefone, boolean aberta) {
        super(nome, endereco, telefone, aberta);
    }

    @Override
    public void realizarAtendimento() {
        if (!estaAberta()) {
            throw new IllegalStateException("UBS está fechada");
        }
        System.out.println("Atendimento em UBS: " + getNome());
    }
}
