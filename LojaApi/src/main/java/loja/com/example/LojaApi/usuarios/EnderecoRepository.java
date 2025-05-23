package loja.com.example.LojaApi.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    List<EnderecoEntity> findByUsuarioId(Long usuarioId);
}
