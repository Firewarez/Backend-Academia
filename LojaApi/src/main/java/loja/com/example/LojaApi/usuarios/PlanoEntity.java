package loja.com.example.LojaApi.usuarios;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "plano")
public class PlanoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(name = "duracao_meses", nullable = false)
    private Integer duracaoMeses;


    @Lob //Explicita no banco de dados o tipo texto podendo armazenar mais de 10,000 caracteres.
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
