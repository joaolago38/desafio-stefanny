package com.crud.cadastro.livro.desafiostefanini.service.impl;

import com.crud.cadastro.livro.desafiostefanini.model.Tarefas;
import com.crud.cadastro.livro.desafiostefanini.model.request.TarefasRequest;
import com.crud.cadastro.livro.desafiostefanini.model.response.ApiResponse;
import com.crud.cadastro.livro.desafiostefanini.model.response.TarefasResponse;
import com.crud.cadastro.livro.desafiostefanini.repository.TarefaRepository;
import com.crud.cadastro.livro.desafiostefanini.service.TarefaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    private ModelMapper modelMapper;


    @Override
    public  ResponseEntity<Tarefas> save(TarefasRequest tarefasRequest) {
        Tarefas tarefa = new Tarefas();
        modelMapper.map(tarefasRequest, tarefa);
        Tarefas novaTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<  >(novaTarefa, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Tarefas> getTarefas(Integer id) {
        Tarefas tarefa = tarefaRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(tarefa, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<TarefasResponse> updateTarefas(Integer id, TarefasRequest tarefasRequest) {
        Tarefas tarefas = tarefaRepository.findById(id).orElseThrow();
        Tarefas updatedTarefas = tarefaRepository.save(tarefas);
        TarefasResponse tarefasResponse = new TarefasResponse();
        modelMapper.map(updatedTarefas, tarefasResponse);
        return new ResponseEntity<>(tarefasResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteTarefas(Integer id) {
        Tarefas tarefas = tarefaRepository.findById(id).orElseThrow();
        if (tarefas == null) {
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE, "Album not found"), HttpStatus.NOT_FOUND);
        } else {
            tarefaRepository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted album"), HttpStatus.OK);
        }

    }


}
