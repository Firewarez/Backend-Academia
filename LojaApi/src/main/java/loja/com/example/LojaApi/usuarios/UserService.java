package loja.com.example.LojaApi.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

//Service define as regras de query: validações, lógicas, verificações, etc.

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity salvar(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> listarTodos() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> buscarPorId(Long id) {
        return userRepository.findById(id);
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }
}
