package br.gov.sus.scvs.servicos;

import br.gov.sus.scvs.dominio.cidadao.Cidadao;
import br.gov.sus.scvs.dominio.profissionais.ProfissionalSaude;
import br.gov.sus.scvs.dominio.unidades.UnidadeSaude;
import br.gov.sus.scvs.dominio.vacina.LoteVacina;
import br.gov.sus.scvs.dominio.vacina.Vacina;

import java.time.LocalDateTime;

public class AplicacaoVacina {
    private LocalDateTime dataHoraAplicacao;
    private int dose;
    private Cidadao cidadao;
    private Vacina vacina;
    private LoteVacina lote;
    private ProfissionalSaude profissional;
    private UnidadeSaude unidade;
    private boolean registrada;

    public AplicacaoVacina(Cidadao cidadao, Vacina vacina, int dose,
                           LoteVacina lote, ProfissionalSaude profissional,
                           UnidadeSaude unidade) {
        setCidadao(cidadao);
        setVacina(vacina);
        setDose(dose);
        setLote(lote);
        setProfissional(profissional);
        setUnidade(unidade);
        this.dataHoraAplicacao = LocalDateTime.now();
        this.registrada = false;
    }

    public Cidadao getCidadao() { return cidadao; }
    public Vacina getVacina() { return vacina; }
    public int getDose() { return dose; }
    public LoteVacina getLote() { return lote; }
    public ProfissionalSaude getProfissional() { return profissional; }
    public UnidadeSaude getUnidade() { return unidade; }
    public LocalDateTime getDataHoraAplicacao() { return dataHoraAplicacao; }
    public boolean isRegistrada() { return registrada; }

    private void setCidadao(Cidadao cidadao) {
        if (cidadao == null) throw new IllegalArgumentException("Cidadão não pode ser nulo");
        this.cidadao = cidadao;
    }

    private void setVacina(Vacina vacina) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        if (!vacina.isValidaParaAplicacao()) throw new IllegalArgumentException("Vacina não está ativa para aplicação");
        this.vacina = vacina;
    }

    private void setDose(int dose) {
        if (dose <= 0) throw new IllegalArgumentException("Dose deve ser maior que zero");
        this.dose = dose;
    }

    private void setLote(LoteVacina lote) {
        if (lote == null) throw new IllegalArgumentException("Lote não pode ser nulo");
        if (lote.isExpirado()) throw new IllegalArgumentException("Lote expirado não pode ser usado");
        if (lote.getQuantidade() <= 0) throw new IllegalArgumentException("Lote sem estoque disponível");
        this.lote = lote;
    }

    private void setProfissional(ProfissionalSaude profissional) {
        if (profissional == null) throw new IllegalArgumentException("Profissional não pode ser nulo");
        if (!profissional.podeAplicarVacina()) throw new IllegalArgumentException("Profissional não pode aplicar vacina");
        this.profissional = profissional;
    }

    private void setUnidade(UnidadeSaude unidade) {
        if (unidade == null) throw new IllegalArgumentException("Unidade não pode ser nula");
        if (!unidade.estaAberta()) throw new IllegalArgumentException("Unidade está fechada");
        this.unidade = unidade;
    }

    public void registrar() {
        if (registrada) {
            throw new IllegalStateException("Aplicação já registrada");
        }

        profissional.aplicarVacina(this);
        cidadao.adicionarAplicacao(this);
        registrada = true;

        System.out.println("Aplicação registrada: " + vacina.getNome() +
                " - Dose " + dose + " - Cidadão: " + cidadao.getNome());
    }
    public boolean podeSerRegistrada() {
        return !registrada &&
                cidadao != null &&
                vacina != null &&
                vacina.isValidaParaAplicacao() &&
                profissional != null &&
                profissional.podeAplicarVacina() &&
                unidade != null &&
                unidade.estaAberta();
    }
}
