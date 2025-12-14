package br.gov.sus.scvs.dominio.agendamento;


import br.gov.sus.scvs.dominio.cidadao.Cidadao;
import br.gov.sus.scvs.dominio.unidades.UnidadeSaude;
import br.gov.sus.scvs.dominio.vacina.Vacina;
import java.time.LocalDate;
import java.time.LocalTime;

// SRP Aplicado: Agendamento apenas gerencia dados do agendamento
public class Agendamento {
    private LocalDate dataAgendada;
    private LocalTime horario;
    private Cidadao cidadao;
    private Vacina vacina;
    private UnidadeSaude unidade;
    private StatusAgendamento status;

    public Agendamento(LocalDate dataAgendada, LocalTime horario, Cidadao cidadao, Vacina vacina, UnidadeSaude unidade) {
        setDataAgendada(dataAgendada);
        setHorario(horario);
        setCidadao(cidadao);
        setVacina(vacina);
        setUnidade(unidade);
        this.status = StatusAgendamento.AGENDADO;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public UnidadeSaude getUnidade() {
        return unidade;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        if (dataAgendada == null) throw new IllegalArgumentException("Data agendada não pode ser nula");
        if (dataAgendada.isBefore(LocalDate.now())) throw new IllegalArgumentException("Data agendada não pode ser no passado");
        this.dataAgendada = dataAgendada;
    }

    public void setHorario(LocalTime horario) {
        if (horario == null) throw new IllegalArgumentException("Horário não pode ser nulo");
        this.horario = horario;
    }

    private void setCidadao(Cidadao cidadao) {
        if (cidadao == null) throw new IllegalArgumentException("Cidadão não pode ser nulo");
        this.cidadao = cidadao;
    }

    public void setVacina(Vacina vacina) {
        if (vacina == null) throw new IllegalArgumentException("Vacina não pode ser nula");
        this.vacina = vacina;
    }

    public void setUnidade(UnidadeSaude unidade) {
        if (unidade == null) throw new IllegalArgumentException("Unidade de saúde não pode ser nula");
        this.unidade = unidade;
    }

    public void setStatus(StatusAgendamento status) {
        if (status == null) throw new IllegalArgumentException("Status não pode ser nulo");
        this.status = status;
    }
}
