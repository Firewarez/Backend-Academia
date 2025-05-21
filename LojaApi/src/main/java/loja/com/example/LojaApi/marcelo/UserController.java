package loja.com.example.LojaApi.usuarios;

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


//Recebe as requisições HTTP (como POST, GET, DELETE)
//Conversa com o UserService
//Retorna respostas HTTP com dados ou status

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> criar(@RequestBody UserEntity user) {
        user.setDataCadastro(LocalDate.now()); // Define a data de cadastro
        return ResponseEntity.ok(userService.salvar(user));
    }

    @GetMapping
    public List<UserEntity> listar() {
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> buscar(@PathVariable Long id) {
        return userService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
