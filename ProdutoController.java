package com.teste.primeiro_exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.services.ProdutoServices;
import org.springframework.web.bind.annotation.PutMapping;




//Adicione os @:
@RestController
@RequestMapping("/api/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoServices produtoService;

    @GetMapping 
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}") //Isso está dizendo que ele deverá levar em consideração o que vier depois da barra
    public Optional<Produto> obterPorId(@PathVariable Integer id){ //PathVariable: é o que vai fazê-lo considerar "/:{id}" como o id no programa
        return produtoService.obterPorId(id);
    }

    // Isso é o que fará com que as requisições sejam atendidas e adicionadas no backend
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return "Produto com ID: " + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizar(id, produto);
    }
}
