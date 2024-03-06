package com.teste.primeiro_exemplo.model;

import javax.persistence.*;



/* Agora coloque todos os atributos da classe produto 
 * Separe todos com uma linha, clique com o botao direito -> Source Action -> Generate Getters and Setters
 * (Assim ele criara os getters e setters automaticamente)
 */


@Entity
public class Produto {
    //#region Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    private String observacao;
    //#endregion
    
    //Constructor
    public Produto(Integer id,String nome, Integer quantidade, Double valor, String observacao){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.observacao = observacao;
    }

    //#region Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //#endregion
}
