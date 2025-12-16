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

    public AplicacaoVacina(Cidadao cidadao, Vacina vacina, int dose, LoteVacina lote, ProfissionalSaude profissional, UnidadeSaude unidade) {
        setCidadao(cidadao);
        setVacina(vacina);
        setDose(dose);
        setLote(lote);
        setProfissional(profissional);
        setUnidade(unidade);
        this.dataHoraAplicacao = LocalDateTime.now();
        this.registrada = false;
        registrar();
    }

    public Cidadao getCidadao() {
        return this.cidadao;
    }
    public Vacina getVacina() {
        return this.vacina;
    }
    public int getDose() {
        return this.dose;
    }
    public LoteVacina getLote() {
        return this.lote;
    }
    public ProfissionalSaude getProfissional() {
        return this.profissional;
    }
    public UnidadeSaude getUnidade() {
        return this.unidade;
    }
    public LocalDateTime getDataHoraAplicacao() {
        return this.dataHoraAplicacao;
    }
    public boolean isRegistrada() {
        return this.registrada;
    }

    public void setCidadao(Cidadao cidadao) {
        if (cidadao == null)
            throw new IllegalArgumentException("Cidadão não pode ser nulo");
        this.cidadao = cidadao;
    }

    public void setVacina(Vacina vacina) {
        if (vacina == null)
            throw new IllegalArgumentException("Vacina não pode ser nula");
        this.vacina = vacina;
    }

    public void setDose(int dose) {
        if (dose <= 0)
            throw new IllegalArgumentException("Dose não pode ser vazia");
        this.dose = dose;
    }

    public void setLote(LoteVacina lote) {
        if (lote == null)
            throw new IllegalArgumentException("Lote não pode ser nulo");
        this.lote = lote;
    }

    public void setProfissional(ProfissionalSaude profissional) {
        if (profissional == null)
            throw new IllegalArgumentException("Profissional não pode ser nulo");
        this.profissional = profissional;
    }

    public void setUnidade(UnidadeSaude unidade) {
        if (unidade == null)
            throw new IllegalArgumentException("Unidade não pode ser nula");
        this.unidade = unidade;
    }

    public void registrar() {
        if (registrada) {
            throw new IllegalStateException("Aplicação já registrada");
        }

        profissional.aplicarVacina(this);
        cidadao.adicionarAplicacao(this);
        registrada = true;

        System.out.println("Aplicação registrada: " + vacina.getNome() + " - Dose " + dose + " - Cidadão: " + cidadao.getNome());
    }
}
