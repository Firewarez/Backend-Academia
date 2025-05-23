package loja.com.example.LojaApi.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/{usuarioId}/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoEntity> criarEndereco(@PathVariable Long usuarioId, @RequestBody EnderecoEntity endereco) {
        EnderecoEntity enderecoSalvo = enderecoService.salvar(usuarioId, endereco);
        return ResponseEntity.ok(enderecoSalvo);
    }

    @GetMapping
    public List<EnderecoEntity> listarEnderecos(@PathVariable Long usuarioId) {
        return enderecoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoEntity> buscarEndereco(@PathVariable Long id) {
        return enderecoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
