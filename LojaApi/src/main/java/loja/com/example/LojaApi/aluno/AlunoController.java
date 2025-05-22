package loja.com.example.LojaApi.alunos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        aluno.setDataInicio(LocalDate.now()); // Define a data de início automaticamente
        return ResponseEntity.ok(alunoService.salvar(aluno));
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints adicionais específicos para Aluno
    @GetMapping("/plano/{idPlano}")
    public List<Aluno> listarPorPlano(@PathVariable Long idPlano) {
        return alunoService.listarPorPlano(idPlano);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Aluno> buscarPorUsuario(@PathVariable Long idUsuario) {
        return alunoService.buscarPorUsuario(idUsuario)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}