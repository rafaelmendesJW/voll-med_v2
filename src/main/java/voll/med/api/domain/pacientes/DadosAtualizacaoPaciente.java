package voll.med.api.domain.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import voll.med.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull Long id,
        String email,
        String telefone,
        @Valid DadosEndereco endereco) {

}
