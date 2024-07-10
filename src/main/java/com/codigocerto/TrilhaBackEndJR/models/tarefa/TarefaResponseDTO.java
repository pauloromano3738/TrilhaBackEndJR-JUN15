package com.codigocerto.TrilhaBackEndJR.models.tarefa;

import java.util.Date;

public record TarefaResponseDTO(Long id_tarefa, String titulo, String descricao, Date data, Long usuario_id) {

    public TarefaResponseDTO(Tarefa tarefa) {
        this(tarefa.getId_tarefa(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getData(), tarefa.getUsuario().getId_usuario());
    }
}
