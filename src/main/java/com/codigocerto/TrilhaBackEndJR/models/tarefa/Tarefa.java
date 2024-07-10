package com.codigocerto.TrilhaBackEndJR.models.tarefa;

import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_tarefa")
@Entity(name = "tarefa")
@Table(name = "tarefa")
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;
    private String titulo;
    private String descricao;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarefa(TarefaRequestDTO data, Usuario usuario) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.data = data.data();
        this.usuario = usuario;
    }
}

