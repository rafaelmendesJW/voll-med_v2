package voll.med.api.domain.medicos;

import jakarta.validation.constraints.NotNull;
import voll.med.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco) {

}
