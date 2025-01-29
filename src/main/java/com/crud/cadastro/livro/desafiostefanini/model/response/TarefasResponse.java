package com.crud.cadastro.livro.desafiostefanini.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarefasResponse {
    private  String id;
    private  String descricao;
    private String dataCriacao;
    private String status;
}
