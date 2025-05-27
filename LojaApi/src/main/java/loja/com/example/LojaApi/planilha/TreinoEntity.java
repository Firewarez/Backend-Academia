package loja.com.example.LojaApi.planilha;

import jakarta.persistence.*;
import java.time.LocalDate;
import loja.com.example.LojaApi.aluno.Aluno;
import loja.com.example.LojaApi.instrutor.Instrutor;

@Entity
@Table(name = "treino")
public class TreinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treino")
    private Long id;

    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instrutor", referencedColumnName = "id_usuario") // se pk da tabela instrutor = id_usuario
    private Instrutor instrutor;

    @Column(name = "data_treino")
    private LocalDate dataTreino = LocalDate.now();

    @Column(name = "tipo_treino", length = 100)
    private String tipoTreino;

    @Lob // Spring define lob para texto grandes como se fosse o tipo TEXT do mysql
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public LocalDate getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

}