package br.gov.sus.scvs.dominio.unidades;

public class PostoVolante extends UnidadeSaude {
    private String localizacaoAtual;

    public PostoVolante(String nome, String endereco, String telefone, boolean aberta, String localizacaoAtual) {
        super(nome, endereco, telefone, aberta);
        this.localizacaoAtual = localizacaoAtual;
    }

    public void setLocalizacaoAtual(String localizacao) {
        this.localizacaoAtual = localizacao;
    }

    @Override
    public void realizarAtendimento() {
        if (!estaAberta()) {
            throw new IllegalStateException("Posto Volante está fechado");
        }
        System.out.println("Atendimento móvel em Posto Volante: " + getNome()
                + " - Local: " + localizacaoAtual);
    }
}
