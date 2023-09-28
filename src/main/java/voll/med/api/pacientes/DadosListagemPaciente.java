package voll.med.api.pacientes;

public record DadosListagemPaciente(Long id,String nome, String email, String telefone, String cpf) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
    
}