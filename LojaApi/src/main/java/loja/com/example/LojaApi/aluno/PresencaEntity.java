package loja.com.example.LojaApi.aluno;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "presenca")
public class PresencaEntity {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "presenca_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    private LocalTime horaEntrada;

    @Column(nullable = false)
    private LocalTime horaSaida;

    @Column(nullable = false)
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime gethoraEntrada() {
        return horaEntrada;
    }

    public void SethoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime gethoraSaida() {
        return horaSaida;
    }

    public void sethoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDate getdata() {
        return data;
    }

    public void setdata(LocalDate data) {
        this.data = data;
    }
}
