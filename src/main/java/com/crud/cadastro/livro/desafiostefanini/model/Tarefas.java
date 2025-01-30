package com.crud.cadastro.livro.desafiostefanini.model;


import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "tarefas")
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "descricao")
    private  String descricao;
    @Column(name = "dataCriacao")
    private String dataCriacao;
    @Column(name = "status")
    private String status;


}
