package voll.med.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import voll.med.api.medicos.DadosListagemMedico;
import voll.med.api.pacientes.DadosAtualizacaoPaciente;
import voll.med.api.pacientes.DadosCadastroPaciente;
import voll.med.api.pacientes.DadosListagemPaciente;
import voll.med.api.pacientes.Paciente;
import voll.med.api.pacientes.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
       // return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
       return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

   /* @GetMapping
    public List<Paciente> listar() {
        return repository.findAll();
    }*/ 

     @PutMapping
     @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
       var paciente = repository.getReferenceById(dados.id());
       paciente.atualizarInformacoes(dados);

    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);

    }

}
