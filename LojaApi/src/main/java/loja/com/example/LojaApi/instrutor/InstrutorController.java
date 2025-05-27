package loja.com.example.LojaApi.instrutor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @PostMapping
    public ResponseEntity<Instrutor> criar(@RequestBody Instrutor instrutor) {
        try {
            // Check required fields
            if (instrutor.getUsuario() == null || instrutor.getUsuario().getId() == null) {
                return ResponseEntity.badRequest().build();
            }

            // Não defina o ID aqui, deixe o @MapsId e o serviço cuidarem disso
            // instrutor.setId(instrutor.getUsuario().getId()); // Remova esta linha

            Instrutor novoInstrutor = instrutorService.salvar(instrutor);
            return ResponseEntity.ok(novoInstrutor);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorna corpo nulo para ajudar
                                                                                       // na depuração
        }
    }

    @GetMapping
    public List<Instrutor> listar() {
        return instrutorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> buscar(@PathVariable Long id) {
        return instrutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        instrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Instrutor> buscarPorUsuario(@PathVariable Long usuarioId) {
        return instrutorService.buscarPorUsuario(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}