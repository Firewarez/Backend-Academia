package loja.com.example.LojaApi.planilha;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    @Transactional
    public TreinoEntity criarTreino(TreinoEntity treino) {
        if (treino.getDataTreino() == null) {
            treino.setDataTreino(LocalDate.now());
        }
        return treinoRepository.save(treino);
    }

    public List<TreinoEntity> listarTodosTreinos() {
        return treinoRepository.findAll();
    }

    public Optional<TreinoEntity> buscarTreinoPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<TreinoEntity> buscarTreinosPorAlunoId(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }

    @Transactional
    public TreinoEntity atualizarTreino(Long id, TreinoEntity treinoAtualizado) {
        return treinoRepository.findById(id)
            .map(treinoExistente -> {
                treinoExistente.setAluno(treinoAtualizado.getAluno());
                treinoExistente.setInstrutor(treinoAtualizado.getInstrutor());
                treinoExistente.setDataTreino(treinoAtualizado.getDataTreino());
                treinoExistente.setTipoTreino(treinoAtualizado.getTipoTreino());
                treinoExistente.setObservacoes(treinoAtualizado.getObservacoes());
                return treinoRepository.save(treinoExistente);
            })
            .orElseThrow(() -> new RuntimeException("Treino não encontrado com id: " + id));
    }

    @Transactional
    public void deletarTreino(Long id) {
        if (!treinoRepository.existsById(id)) {
            throw new RuntimeException("Treino não encontrado com id: " + id);
        }
        treinoRepository.deleteById(id);
    }
}