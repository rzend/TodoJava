package todo.desafio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import todo.desafio.api.domain.tarefa.*;


@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TarefasRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTarefas dados, UriComponentsBuilder uriBuilder) {
        var tarefa = new Tarefas(dados);
        repository.save(tarefa);
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTarefa(tarefa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTarefas>> listar(Pageable paginacao) {
        var response = repository.findAll(paginacao).map(DadosListagemTarefas::new);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTarefa dados) {
        var tarefa = repository.getReferenceById(dados.id());
        tarefa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var tarefa = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
