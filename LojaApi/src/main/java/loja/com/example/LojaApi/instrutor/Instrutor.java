package loja.com.example.LojaApi.instrutor;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import loja.com.example.LojaApi.usuarios.UserEntity;

@Entity
@Table(name = "instrutor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Instrutor {

    @Id
    @Column(name = "id_usuario")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) // É uma boa prática usar LAZY aqui
    @MapsId // <<< ADICIONE ESTA ANOTAÇÃO
    @JoinColumn(name = "id_usuario", referencedColumnName = "user_id")
    private UserEntity usuario;

    @Column(name = "registro_cref", length = 20)
    private String registroProfissional;

    @Column(name = "horario", length = 59)
    private String horarioDisponivel;

    @Column(name = "especialidade", length = 189)
    private String especializacao;

    // Construtor padrão
    public Instrutor() {
    }

    // Construtor com campos obrigatórios
    public Instrutor(UserEntity usuario, String registroProfissional, String especializacao) {
        this.usuario = usuario;
        this.registroProfissional = registroProfissional;
        this.especializacao = especializacao;
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

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}