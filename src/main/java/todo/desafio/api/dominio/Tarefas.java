package todo.desafio.api.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tarefas")
@Entity(name = "Tarefas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefas(DadosCadastroTarefas dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.status = dados.status();

    }

    public void atualizarInformacoes(DadosAtualizacaoTarefa dados) {
        this.status = dados.status();
    }
}
