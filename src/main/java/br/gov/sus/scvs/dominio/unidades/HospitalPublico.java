package br.gov.sus.scvs.dominio.unidades;

public class HospitalPublico extends UnidadeSaude {
    private int leitosDisponiveis;

    public HospitalPublico(String nome, String endereco, String telefone, boolean aberta, int leitosDisponiveis) {
        super(nome, endereco, telefone, aberta);
        this.leitosDisponiveis = leitosDisponiveis;
    }

    @Override
    public void realizarAtendimento() {
        if (!estaAberta()) {
            throw new IllegalStateException("Hospital está fechado");
        }
        System.out.println("Atendimento em Hospital Público: " + getNome());
    }
}
