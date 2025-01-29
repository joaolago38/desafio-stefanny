package com.crud.cadastro.livro.desafiostefanini.model.request;

import lombok.Data;


@Data
public class TarefasRequest {
    private  String id;
    private  String descricao;
    private String dataCriacao;
    private String status;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
