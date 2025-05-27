package loja.com.example.LojaApi.aluno;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoEntity salvar(PagamentoEntity pagamento) {
        if(pagamento.getDatapagamento() == null) {
            pagamento.setDatapagamento(LocalDate.now());
        }
        return pagamentoRepository.save(pagamento);
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