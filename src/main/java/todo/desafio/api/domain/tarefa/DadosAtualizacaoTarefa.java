package todo.desafio.api.domain.tarefa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTarefa(
        @NotNull
        Long id,
        Status status) {
}
