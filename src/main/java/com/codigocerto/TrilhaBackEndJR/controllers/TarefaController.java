package com.codigocerto.TrilhaBackEndJR.controllers;

import com.codigocerto.TrilhaBackEndJR.models.tarefa.Tarefa;
import com.codigocerto.TrilhaBackEndJR.models.tarefa.TarefaRequestDTO;
import com.codigocerto.TrilhaBackEndJR.models.tarefa.TarefaResponseDTO;
import com.codigocerto.TrilhaBackEndJR.models.usuario.Usuario;
import com.codigocerto.TrilhaBackEndJR.repositories.TarefaRepository;
import com.codigocerto.TrilhaBackEndJR.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("listar/{id}")
    public ResponseEntity getTarefaById(@PathVariable Long id) {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        return ResponseEntity.ok(tarefaOptional);
    }

    @GetMapping("/listar")
    public ResponseEntity getAllTarefas() {

        List<TarefaResponseDTO> tarefaList = tarefaRepository.findAll().stream().map(TarefaResponseDTO::new).toList();
        return ResponseEntity.ok(tarefaList);
    }

    @PostMapping("/adicionar")
    public ResponseEntity createTarefa(@RequestBody @Valid TarefaRequestDTO data) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(data.usuario_id());
        Usuario usuario = usuarioOptional.get();

        Tarefa tarefa = new Tarefa(data, usuario);
        tarefaRepository.save(tarefa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity updateTarefa(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO data) {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        Tarefa tarefa = tarefaOptional.get();

        tarefa.setTitulo(data.titulo());
        tarefa.setDescricao(data.descricao());
        tarefa.setData(data.data());

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(data.usuario_id());
        Usuario usuario = usuarioOptional.get();

        tarefa.setUsuario(usuario);

        tarefaRepository.save(tarefa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity deleteTarefa(@PathVariable Long id) {

        tarefaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
