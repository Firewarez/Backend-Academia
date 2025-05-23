package loja.com.example.LojaApi.instrutor;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Optional<Instrutor> findByUsuarioId(Long usuarioId);
}