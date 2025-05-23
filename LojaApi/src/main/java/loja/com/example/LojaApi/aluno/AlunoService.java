package loja.com.example.LojaApi.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> listarPorPlano(Long idPlano) {
        return alunoRepository.findByPlanoId(idPlano);
    }

    public Optional<Aluno> buscarPorUsuario(Long idUsuario) {
        return alunoRepository.findByUsuarioId(idUsuario);
    }
}