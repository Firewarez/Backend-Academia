package loja.com.example.LojaApi.aluno;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import loja.com.example.LojaApi.usuarios.UserEntity;
import loja.com.example.LojaApi.planos.Plano;
import loja.com.example.LojaApi.pagamentos.Pagamento;
import loja.com.example.LojaApi.treinos.Treino;
import loja.com.example.LojaApi.presencia.Presencia;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "user_id", nullable = false)
    private UserEntity usuario;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @ManyToOne
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Treino> treinos;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Presencia> presencas;

    // Construtores
    public Aluno() {
    }

    public Aluno(UserEntity usuario, LocalDate dataInicio, Plano plano) {
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.plano = plano;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public List<Presencia> getPresencas() {
        return presencas;
    }

    public void setPresencas(List<Presencia> presencas) {
        this.presencas = presencas;
    }
}