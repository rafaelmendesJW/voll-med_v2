package voll.med.api.domain.consultas.validacoes;

import voll.med.api.domain.consultas.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {
    void validar(DadosAgendamentoConsulta dados);
}
