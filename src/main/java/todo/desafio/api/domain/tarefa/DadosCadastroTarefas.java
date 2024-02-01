package todo.desafio.api.domain.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTarefas(

        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Status status) {
}
