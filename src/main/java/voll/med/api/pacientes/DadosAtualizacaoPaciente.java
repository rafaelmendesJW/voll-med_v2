package voll.med.api.pacientes;

import jakarta.validation.constraints.NotNull;
import voll.med.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull Long id,
        String email,
        String telefone,
        DadosEndereco endereco) {

}
