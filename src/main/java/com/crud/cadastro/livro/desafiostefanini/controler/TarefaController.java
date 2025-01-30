package com.crud.cadastro.livro.desafiostefanini.controler;

import com.crud.cadastro.livro.desafiostefanini.model.Tarefas;
import com.crud.cadastro.livro.desafiostefanini.model.request.TarefasRequest;
import com.crud.cadastro.livro.desafiostefanini.model.response.ApiResponse;
import com.crud.cadastro.livro.desafiostefanini.model.response.TarefasResponse;
import com.crud.cadastro.livro.desafiostefanini.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefas> addTarefas(@Valid @RequestBody TarefasRequest tarefasRequest) {
        return tarefaService.save(tarefasRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> getTarefas(@PathVariable(name = "id") Integer id) {
        return tarefaService.getTarefas(id);
    }

    @PutMapping("/{id}")
     public ResponseEntity<TarefasResponse> updateTarefas(@PathVariable(name = "id") Integer id, @Valid @RequestBody TarefasRequest tarefasRequest) {
        return tarefaService.updateTarefas(id, tarefasRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteATarefa(@PathVariable(name = "id") Integer id) {
        return tarefaService.deleteTarefas(id);
    }


}
