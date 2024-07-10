package com.codigocerto.TrilhaBackEndJR.models.tarefa;

import java.util.Date;

public record TarefaRequestDTO(String titulo, String descricao, Date data, Long usuario_id) {
}
