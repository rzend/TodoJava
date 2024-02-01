package todo.desafio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import todo.desafio.api.dominio.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TarefasRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTarefas dados){
        repository.save(new Tarefas(dados));
    }

    @GetMapping
    public Page<DadosListagemTarefas> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTarefas::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTarefa dados){
        var tarefa = repository.getReferenceById(dados.id());
        tarefa.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
