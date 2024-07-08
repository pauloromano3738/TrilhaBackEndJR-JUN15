package com.codigocerto.TrilhaBackEndJR.models.tarefa;

import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id_tarefa")
@Entity(name = "tarefa")
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
