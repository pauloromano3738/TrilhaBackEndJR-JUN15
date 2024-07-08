package com.codigocerto.TrilhaBackEndJR.controllers;

import com.codigocerto.TrilhaBackEndJR.models.tarefa.Tarefa;
import com.codigocerto.TrilhaBackEndJR.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/{id}")
    public void getTarefaById() {


    }

    @GetMapping()
    public void getAllTarefas() {

        List<Tarefa> tarefaList = tarefaRepository.findAll();
        System.out.println(tarefaList);
    }

    @PostMapping()
    public void createTarefa() {

    }

    @PutMapping("/{id}")
    public void updateTarefa() {

    }

    @DeleteMapping("/{id}")
    public void deleteTarefa() {

    }
}
