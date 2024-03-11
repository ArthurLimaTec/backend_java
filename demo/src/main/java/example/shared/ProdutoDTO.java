package example.shared;


public class ProdutoDTO {
    //#region Atributos

    private Integer id;

    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    private String observacao;
    //#endregion
    
    // Construtor padrão sem argumentos
    /*Em frameworks de persistência de dados como Hibernate, 
    é comum que uma classe de entidade (como a classe Produto) tenha um construtor padrão (sem argumentos) 
    para que o Hibernate possa instanciar essa classe ao recuperar os dados do banco de dados. */
    public ProdutoDTO() {

    }
    
    // Com o constructor acima, ainda não sei se esse é necessário:
    // public Produto(Integer id, String nome, Integer quantidade, Double valor, String observacao) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.quantidade = quantidade;
    //     this.valor = valor;
    //     this.observacao = observacao;
    // }

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
