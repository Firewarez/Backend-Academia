package loja.com.example.LojaApi.instrutores;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor salvar(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public List<Instrutor> listarTodos() {
        return instrutorRepository.findAll();
    }

    public Optional<Instrutor> buscarPorId(Long id) {
        return instrutorRepository.findById(id);
    }

    public void deletar(Long id) {
        instrutorRepository.deleteById(id);
    }

    public Optional<Instrutor> buscarPorUsuario(Long usuarioId) {
        return instrutorRepository.findByUsuarioId(usuarioId);
    }
}