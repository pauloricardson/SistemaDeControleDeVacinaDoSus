// Package: br.gov.sus.scvs.interfaces.dominio.unidades
package br.gov.sus.scvs.dominio.unidades;

// Interface para unidades que realizam atendimento (ISP)
public interface IUnidadeAtendimento {
    void realizarAtendimento();
    boolean estaAberta();
}