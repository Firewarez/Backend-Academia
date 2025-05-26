package loja.com.example.LojaApi.planilha;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "treino")
public class TreinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treino")
    private Long id;

    @Column(name = "id_aluno", nullable = false)
    private Long alunoId; // fk do aluno

    // descomentar pra testar quando tiver feito a entidade aluno
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_aluno", nullable = false)
    // private AlunoEntity aluno;

    @Column(name = "id_instrutor")
    private Long instrutorId; // fk instrutor

    // mesma coisa do de cima com o instrutor
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_instrutor", referencedColumnName = "id_usuario") // se pk da tabela instrutor = id_usuario
    // private InstrutorEntity instrutor;

    @Column(name = "data_treino")
    private LocalDate dataTreino;

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

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(Long instrutorId) {
        this.instrutorId = instrutorId;
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

    // testar quando definirem a entidade aluno corretamente
    /*
    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public InstrutorEntity getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(InstrutorEntity instrutor) {
        this.instrutor = instrutor;
    }
    */
}