package voll.med.api.domain.consultas.validacoes.cancelamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consultas.ConsultaRepository;
import voll.med.api.domain.consultas.DadosCancelamentoConsulta;

public class ValidadorHorarioAntecedenciaCancelamento implements ValidadorCancelamentoConsulta {
   
    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
