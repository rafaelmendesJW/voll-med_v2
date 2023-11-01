package voll.med.api.domain.consultas.validacoes.cancelamento;

import voll.med.api.domain.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
