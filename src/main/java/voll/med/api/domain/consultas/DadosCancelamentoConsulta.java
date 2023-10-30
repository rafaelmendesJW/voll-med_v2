package voll.med.api.domain.consultas;

public record DadosCancelamentoConsulta(
        @NotNull Long idConsulta,
        @NotNull MotivoCancelamento motivo) {

}
