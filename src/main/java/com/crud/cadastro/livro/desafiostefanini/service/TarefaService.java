package com.crud.cadastro.livro.desafiostefanini.service;

import com.crud.cadastro.livro.desafiostefanini.model.Tarefas;
import com.crud.cadastro.livro.desafiostefanini.model.request.TarefasRequest;
import com.crud.cadastro.livro.desafiostefanini.model.response.ApiResponse;
import com.crud.cadastro.livro.desafiostefanini.model.response.TarefasResponse;
import org.springframework.http.ResponseEntity;

public interface TarefaService {

    ResponseEntity<Tarefas> save(TarefasRequest tarefasRequest);

    ResponseEntity<Tarefas> getTarefas(Integer id);

    ResponseEntity<TarefasResponse> updateTarefas(Integer id, TarefasRequest tarefasRequest);

    ResponseEntity<ApiResponse> deleteTarefas(Integer id);


}
