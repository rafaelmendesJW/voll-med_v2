package voll.med.api.domain.consultas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voll.med.api.domain.medicos.MedicoRepository;
import voll.med.api.domain.pacientes.PacienteRepository;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired 
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados){
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);

    }
    
}
