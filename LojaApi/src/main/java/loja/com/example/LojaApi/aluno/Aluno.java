package loja.com.example.LojaApi.aluno;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import loja.com.example.LojaApi.usuarios.UserEntity;
import loja.com.example.LojaApi.usuarios.PlanoEntity;
import loja.com.example.LojaApi.aluno.PagamentoEntity;
import loja.com.example.LojaApi.planilha.TreinoEntity;
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
    private PlanoEntity plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<PagamentoEntity> pagamentos;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<TreinoEntity> treinos;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Presencia> presencas;

    // Construtores
    public Aluno() {
    }

    public Aluno(UserEntity usuario, LocalDate dataInicio, PlanoEntity plano) {
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

    public PlanoEntity getPlano() {
        return plano;
    }

    public void setPlano(PlanoEntity plano) {
        this.plano = plano;
    }

    public List<PagamentoEntity> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PagamentoEntity> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<TreinoEntity> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<TreinoEntity> treinos) {
        this.treinos = treinos;
    }

    public List<Presencia> getPresencas() {
        return presencas;
    }

    public void setPresencas(List<Presencia> presencas) {
        this.presencas = presencas;
    }
}