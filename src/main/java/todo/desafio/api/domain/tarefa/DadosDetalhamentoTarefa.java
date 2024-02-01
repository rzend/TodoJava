package todo.desafio.api.domain.tarefa;

public record DadosDetalhamentoTarefa(Long id, String nome, String descricao, Status status) {

    public DadosDetalhamentoTarefa(Tarefas tarefa){

        this(tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getStatus());
    }
}
