package com.codigocerto.TrilhaBackEndJR.controllers;

import com.codigocerto.TrilhaBackEndJR.models.usuario.LoginRequestDTO;
import com.codigocerto.TrilhaBackEndJR.models.usuario.RegisterRequestDTO;
import com.codigocerto.TrilhaBackEndJR.models.usuario.LoginResponseDTO;
import com.codigocerto.TrilhaBackEndJR.infra.security.TokenService;
import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import com.codigocerto.TrilhaBackEndJR.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO data) {

        Usuario usuario = this.usuarioRepository.findByLogin(data.login()).orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(data.senha(), usuario.getSenha())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new LoginResponseDTO(usuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO data){

        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByLogin(data.login());

        if (usuarioOptional.isEmpty()) {
            Usuario newUsuario = new Usuario();
            newUsuario.setNome(data.nome());
            newUsuario.setLogin(data.login());
            newUsuario.setLogin(data.login());
            newUsuario.setSenha(passwordEncoder.encode(data.senha()));
            this.usuarioRepository.save(newUsuario);

            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new LoginResponseDTO(newUsuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
