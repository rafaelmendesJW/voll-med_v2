package voll.med.api.domain.consultas.validacoes;



import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.DadosAgendamentoConsulta;
import voll.med.api.domain.medicos.MedicoRepository;

public class ValidadorMedicoAtivo {
    
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }
        Boolean medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído!");
        }

    }

}
