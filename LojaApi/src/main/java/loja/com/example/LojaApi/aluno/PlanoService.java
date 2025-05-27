package loja.com.example.LojaApi.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public PlanoEntity salvar(PlanoEntity user) {
        return planoRepository.save(user);
    }

    public List<PlanoEntity> listarTodos() {
        return planoRepository.findAll();
    }

    public Optional<PlanoEntity> buscarPorId(Long id) {
        return planoRepository.findById(id);
    }

    public void deletar(Long id) {
        planoRepository.deleteById(id);
    }
}