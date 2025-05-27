package loja.com.example.LojaApi.planilha;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    private final TreinoService treinoService;


    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping
    public ResponseEntity<TreinoEntity> criarTreino(@RequestBody TreinoEntity treino) {
        TreinoEntity novoTreino = treinoService.criarTreino(treino);
        return new ResponseEntity<>(novoTreino, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TreinoEntity>> listarTodosTreinos() {
        List<TreinoEntity> treinos = treinoService.listarTodosTreinos();
        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoEntity> buscarTreinoPorId(@PathVariable Long id) {
        return treinoService.buscarTreinoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<TreinoEntity>> buscarTreinosPorAlunoId(@PathVariable Long alunoId) {
        List<TreinoEntity> treinos = treinoService.buscarTreinosPorAlunoId(alunoId);
        if (treinos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(treinos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoEntity> atualizarTreino(@PathVariable Long id, @RequestBody TreinoEntity treinoAtualizado) {
        try {
            TreinoEntity treino = treinoService.atualizarTreino(id, treinoAtualizado);
            return ResponseEntity.ok(treino);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTreino(@PathVariable Long id) {
        try {
            treinoService.deletarTreino(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}