package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

// A primeira coisa que precisamos fazer é adicionar este import e o @ abaixo:
// import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.model.exception.ResourceNotFoundException;

@Repository
// Agora adicione os atributos 
public class ProdutoRepository_old {
    //#region Atributos:
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;
    //#endregion

    //#region Metodos:
    //Agora, preciso criar os métodos:
    /** ISSO É UM JAVADOC: é o que o usuário vai ver quando passar o mouse em cima
     * 
     * Retorna uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retona o produto encontrado pelo seu ID.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que sera adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        
        ultimoId++;
        
        produto.setId(ultimoId);
        produtos.add(produto);
        
        return produto;
    }

    /**
     * Metodo para deletar produto da lista por ID.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @return Retorna o produto apos atualizar na lista.
     */
    public Produto atualizar(Produto produto){
        //Encontrar o produto na lista:
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não pode ser atualizado, pois não existe.");
        }
        
        //Remover o produto antigo da lista
        deletar(produto.getId());

        //Depois, adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;

        //#endregion
    }
}
