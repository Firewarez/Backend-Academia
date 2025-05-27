package loja.com.example.LojaApi.aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaRepository extends JpaRepository<PresencaEntity, Long> {

    List<PresencaEntity> findByAlunoId(Long alunoId);
}
