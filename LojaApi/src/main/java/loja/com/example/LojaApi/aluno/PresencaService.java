package loja.com.example.LojaApi.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresencaService {
    
    @Autowired
    private PresencaRepository presencaRepository;

    public PresencaEntity salvar(PresencaEntity user) {
        return presencaRepository.save(user);
    }

    public List<PresencaEntity> listarTodos() {
        return presencaRepository.findAll();
    }

    public Optional<PresencaEntity> buscarPorId(Long id) {
        return presencaRepository.findById(id);
    }

    public void deletar(Long id) {
        presencaRepository.deleteById(id);
    }
}
