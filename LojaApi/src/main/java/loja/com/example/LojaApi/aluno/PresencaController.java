package loja.com.example.LojaApi.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presença")
public class PresencaController {
    
    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public List<PresencaEntity> listar() {
        return presencaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresencaEntity> buscar(@PathVariable Long id) {
        return presencaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PresencaEntity> deletar(@PathVariable Long id) {
        presencaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
