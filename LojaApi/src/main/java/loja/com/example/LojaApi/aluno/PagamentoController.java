package loja.com.example.LojaApi.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoEntity> criar(@RequestBody PagamentoEntity pagamento) {
        try {
            PagamentoEntity novoPagamento = pagamentoService.salvar(pagamento);
            return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<PagamentoEntity> listar() {
        return pagamentoService.ListarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoEntity> buscar(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
