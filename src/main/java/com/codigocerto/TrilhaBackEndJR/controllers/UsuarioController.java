package com.codigocerto.TrilhaBackEndJR.controllers;

import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import com.codigocerto.TrilhaBackEndJR.models.usuario.UsuarioRequestDTO;
import com.codigocerto.TrilhaBackEndJR.models.usuario.UsuarioResponseDTO;
import com.codigocerto.TrilhaBackEndJR.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("listar/{id}")
    public ResponseEntity getUsuarioById(@PathVariable Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return ResponseEntity.ok(usuarioOptional);
    }

    @GetMapping("/listar")
    public ResponseEntity getAllUsuarios() {

        List<UsuarioResponseDTO> usuarioList = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return ResponseEntity.ok(usuarioList);
    }


    @PutMapping("atualizar/{id}")
    public ResponseEntity updateUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO data) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuario = usuarioOptional.get();

        usuario.setNome(data.nome());
        usuario.setLogin(data.login());
        usuario.setSenha(data.senha());

        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Long id) {

        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
