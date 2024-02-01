package todo.desafio.api.dominio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTarefa(
        @NotNull
        Long id,
        Status status) {
}
