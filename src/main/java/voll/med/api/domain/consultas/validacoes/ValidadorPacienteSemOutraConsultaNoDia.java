package voll.med.api.domain.consultas.validacoes;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.ConsultaRepository;
import voll.med.api.domain.consultas.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia {
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(),
                primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia!");
        }

    }

}
