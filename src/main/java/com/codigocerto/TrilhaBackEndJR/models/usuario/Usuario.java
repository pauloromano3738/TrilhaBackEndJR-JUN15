package com.codigocerto.TrilhaBackEndJR.models.usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome;
    private String login;
    private String senha;

    public Usuario(UsuarioRequestDTO data) {
        this.nome = data.nome();
        this.login = data.login();
        this.senha = data.senha();
    }
}
