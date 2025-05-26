package loja.com.example.LojaApi.planilha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoEntity, Long> {

    
    List<TreinoEntity> findByAlunoId(Long alunoId);

    List<TreinoEntity> findByInstrutorId(Long instrutorId);

    List<TreinoEntity> findByDataTreino(LocalDate dataTreino);

    List<TreinoEntity> findByAlunoIdAndDataTreino(Long alunoId, LocalDate dataTreino);
}