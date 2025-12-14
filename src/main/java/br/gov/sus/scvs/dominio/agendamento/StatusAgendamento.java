package br.gov.sus.scvs.dominio.agendamento;

public enum StatusAgendamento {
    AGENDADO,
    CONFIRMADO,
    CANCELADO,
    REALIZADO;

    public boolean estaAtivo() {
        return this == AGENDADO || this == CONFIRMADO;
    }
}