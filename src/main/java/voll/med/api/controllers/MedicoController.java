package voll.med.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import voll.med.api.medicos.DadosAtualizacaoMedico;
import voll.med.api.medicos.DadosCadastroMedico;
import voll.med.api.medicos.DadosListagemMedico;
import voll.med.api.medicos.Medico;
import voll.med.api.medicos.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    /*
     * @DeleteMapping("/{id}")
     * 
     * @Transactional
     * public void excluir(@PathVariable Long id){
     * repository.deleteById(id);
     * 
     * }
     */

    @DeleteMapping("/{id}")
    @Transactional 
    public void excluirLogico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluirLogico();

    }

}
