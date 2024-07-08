package com.codigocerto.TrilhaBackEndJR.models.usuario;

public record UsuarioResponseDTO(Long id_usuario, String nome, String login, String senha) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId_usuario(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }
}
