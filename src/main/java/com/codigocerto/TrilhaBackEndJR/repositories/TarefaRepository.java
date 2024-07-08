package com.codigocerto.TrilhaBackEndJR.repositories;

import com.codigocerto.TrilhaBackEndJR.models.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
