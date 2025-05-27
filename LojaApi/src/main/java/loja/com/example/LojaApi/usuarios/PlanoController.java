package loja.com.example.LojaApi.usuarios;

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
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody PlanoEntity plano) {
        try {
            System.out.println("Received plano: " + plano.getNome() + ", price: " + plano.getPreco() +
                    ", months: " + plano.getDuracaoMeses());
            PlanoEntity novoPlano = planoService.salvar(plano);
            return new ResponseEntity<>(novoPlano, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving plan: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<PlanoEntity> listar() {
        return planoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoEntity> buscar(@PathVariable Long id) {
        return planoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        planoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
