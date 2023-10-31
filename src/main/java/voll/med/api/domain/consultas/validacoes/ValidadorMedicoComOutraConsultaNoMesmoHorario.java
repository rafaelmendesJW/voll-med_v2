package voll.med.api.domain.consultas.validacoes;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.ConsultaRepository;
import voll.med.api.domain.consultas.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(),
                dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Medico já possui outra consulta agendada nesse mesmo horário!");
        }
    }

}
