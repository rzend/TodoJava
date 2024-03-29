package todo.desafio.api.domain.tarefa;

public record DadosListagemTarefas(Long id, String nome, String descricao, Status status) {

    public DadosListagemTarefas(Tarefas tarefa) {
        this(tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getStatus());
    }
}
