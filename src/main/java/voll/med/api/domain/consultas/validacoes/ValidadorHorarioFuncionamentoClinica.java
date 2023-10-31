package voll.med.api.domain.consultas.validacoes;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.DadosAgendamentoConsulta;

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados) {

        LocalDateTime dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do dia ou horario do funcionamento da clínica");
        }

    }
}
