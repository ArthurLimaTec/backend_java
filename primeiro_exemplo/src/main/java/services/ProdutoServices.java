package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository_old;

//Adicione o @:
@Service
public class ProdutoServices {
    
    @Autowired
    private ProdutoRepository_old produtoRepository;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retona o produto encontrado pelo seu ID.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        // Poderia ter alguma regra de negócio aqui caso tivesse
        return produtoRepository.adicionar(produto);
    }

    /**
     * Método para deletar produto da lista por ID.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @param id do produto
     * @return Retorna o produto após atualizar na lista.
     */
    public Produto atualizar(Integer id, Produto produto){
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }
    
}