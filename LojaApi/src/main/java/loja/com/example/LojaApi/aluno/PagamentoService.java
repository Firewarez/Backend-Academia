package loja.com.example.LojaApi.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoEntity salvar(PagamentoEntity user) {
        return pagamentoRepository.save(user);
    }

    public List<PagamentoEntity> ListarTodos() {
        return pagamentoRepository.findAll();
    }

    public Optional<PagamentoEntity> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
