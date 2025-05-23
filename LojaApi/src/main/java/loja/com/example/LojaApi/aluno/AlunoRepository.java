package loja.com.example.LojaApi.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByPlanoId(Long idPlano);
    Optional<Aluno> findByUsuarioId(Long idUsuario);
}