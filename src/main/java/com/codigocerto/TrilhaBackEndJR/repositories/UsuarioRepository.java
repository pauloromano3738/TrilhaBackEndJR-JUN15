package com.codigocerto.TrilhaBackEndJR.repositories;

import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
