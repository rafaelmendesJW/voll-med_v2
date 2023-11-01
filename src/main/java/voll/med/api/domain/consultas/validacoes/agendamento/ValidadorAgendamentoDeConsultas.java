package voll.med.api.domain.consultas.validacoes.agendamento;

import voll.med.api.domain.consultas.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {

    void validar(DadosAgendamentoConsulta dados);
}
