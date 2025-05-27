package loja.com.example.LojaApi.aluno;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @Column(name = "metodo_pagamento", nullable = false, length = 100)
    private String metododepagamento;

    @Column(nullable = false, length = 100)
    private String status;

    @Column(nullable = false)
    private double valor;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMetododepagamento() {
        return metododepagamento;
    }

    public void setMetododepagamento(String metododepagamento) {
        this.metododepagamento = metododepagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDatapagamento() {
        return dataPagamento;
    }

    public void setDatapagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
