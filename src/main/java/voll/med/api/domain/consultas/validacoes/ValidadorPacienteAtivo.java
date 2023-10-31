package voll.med.api.domain.consultas.validacoes;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.DadosAgendamentoConsulta;
import voll.med.api.domain.pacientes.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }

    }
}
