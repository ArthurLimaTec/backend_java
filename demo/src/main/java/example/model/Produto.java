package example.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Produto")
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
    
    // Construtor padrão sem argumentos
    /*Em frameworks de persistência de dados como Hibernate, 
    é comum que uma classe de entidade (como a classe Produto) tenha um construtor padrão (sem argumentos) 
    para que o Hibernate possa instanciar essa classe ao recuperar os dados do banco de dados. */
    public Produto() {

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
